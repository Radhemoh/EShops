package mypck;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetProduct() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String	pcid=request.getParameter("pcid");
	Connection con=(Connection)this.getServletContext().getAttribute("mycon");
	try {
		PreparedStatement ps=con.prepareStatement("select pid,pname from products where pcid=?");
		ps.setString(1, pcid);
		ResultSet rs=ps.executeQuery();
		ArrayList<String[]> list=new ArrayList<String[]>();
		while(rs.next())
		{
			String pro[]=new String[2];
			pro[0]=rs.getString(1);
			pro[1]=rs.getString(2);
			list.add(pro);
		}
		Gson gson=new Gson();
	    String data=gson.toJson(list);
		response.getWriter().write(data);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}


