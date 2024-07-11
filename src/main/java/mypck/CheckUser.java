package mypck;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet(
		urlPatterns = { "/CheckUser" }, 
		initParams = { 
				@WebInitParam(name = "adminid", value = "radhe"), 
				@WebInitParam(name = "adminpass", value = "radhe")
		})
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean found;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		String chk=request.getParameter("chk");
		
		response.setContentType("text/html");
		PrintWriter out= response. getWriter();
		Connection con=(Connection)this.getServletContext().getAttribute("mycon");
		try
		{
		PreparedStatement ps = con.prepareStatement("select * from users where userid=? and password=?");
		ps.setString(1, uid);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		boolean found=rs.next();
	
		if(found)
		{         
			
			String uname=rs.getString(2);
			String userid=rs.getString(1);
			HttpSession session=request.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("userid", userid);
			
			if(chk!=null)
			{         
				Cookie ck1=new Cookie("uid",uid);
				Cookie ck2=new Cookie("pass",pass);
				
				ck1.setMaxAge(60*60*24);
				ck1.setMaxAge(60*60);
				
				response.addCookie(ck1);
				response.addCookie(ck2);
				
			}
			String utype=rs.getString(4);
			if(utype.equalsIgnoreCase("seller"))
			response.sendRedirect("seller.jsp");
			
			else	
			response.sendRedirect("buyer.jsp");
			
		}
		else if(uid.equalsIgnoreCase(this.getInitParameter("adminid")) && pass.equalsIgnoreCase(this.getInitParameter("adminpass")) )
		{

			
			response.sendRedirect("adminhome.jsp");
		}
		else
		{
			out.println("<h3>Invalid Credentials..</h3>");
			out.println("<a href=login.jsp>Try-Again</a>");
		}
		
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

}
