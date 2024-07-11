package mypck;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePC")
public class UpdatePC extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdatePC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=(Connection)this.getServletContext().getAttribute("mycon");
		try {
			PreparedStatement ps=con.prepareStatement("update productcategory set pcname=? where pcid=?");
			ps.setString(1, request.getParameter("pcnm"));
			ps.setString(2, request.getParameter("pcid"));
			int n=ps.executeUpdate();
			response.sendRedirect("showPC.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
