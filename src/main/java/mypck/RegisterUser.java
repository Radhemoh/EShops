package mypck;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
		response.setContentType("text/html");
		Connection con=(Connection)this.getServletContext().getAttribute("mycon");
	try
   {
	
	PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?,?)");
	ps.setString(1, request.getParameter("uid"));
	ps.setString(2, request.getParameter("unm"));
	ps.setString(3, request.getParameter("pass"));
	ps.setString(4, request.getParameter("utype"));
	ps.executeUpdate();
	response.getWriter().write("<h3>Register Successfully..</h3>");
	response.getWriter().write("<a href='home.jsp'>Home</a>");
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}

}
	}
