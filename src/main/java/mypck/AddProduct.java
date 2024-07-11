package mypck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		Connection con=(Connection)this.getServletContext().getAttribute("mycon");
		try {
			PreparedStatement ps=con.prepareStatement("insert into products values(?,?,?,?,?,?)");
			ps.setString(1, request.getParameter("pid"));
			ps.setString(2, request.getParameter("pnm"));
			ps.setString(3, request.getParameter("pdesc"));
			ps.setString(4, request.getParameter("price"));
			ps.setString(5, request.getParameter("disc"));
			ps.setString(6, request.getParameter("pcid"));
			int n=ps.executeUpdate();
			if(n>0) {
				out.write("<h2>Product Added Successfully...</h2>");
				out.write("<a href=addpro.jsp>Add More Products</a><br>");
				out.write("<a href=seller.jsp>Home</a><br>");
			}
			else {
				out.print("<h2>Product could not be added....</h>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}