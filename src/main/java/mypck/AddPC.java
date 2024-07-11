package mypck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddPC")
public class AddPC extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddPC() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
    Connection con=(Connection)this.getServletContext().getAttribute("mycon");
   try
   {
    PreparedStatement ps =con.prepareStatement("insert into productCategory values(?,?)");
    ps.setString(1, request.getParameter("pcid"));
    ps.setString(2, request.getParameter("pcname"));
    int n=ps.executeUpdate();
    if(n>0)
    {
    	out.write("<h2>Product Category Added Successfully</h2>");
    	out.write("<a href=addpc.jsp>Add More Product </a> <br>");
    	out.write("<a href=adminhome.jsp>Home </a> <br>");
    
    }
    else
    {
    	out.print("<h2>Product Could Not Be Added</h2>");
    }
   }
   catch(Exception e1)
   {
	   e1.printStackTrace();
   }
}
	
}
