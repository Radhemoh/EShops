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

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=(Connection)this.getServletContext().getAttribute("mycon");
		try {
			PreparedStatement ps=con.prepareStatement("update products set pname=?,pdesc=?,price=?,discountper=? where pid=?");
			ps.setString(1, request.getParameter("pnm"));
			ps.setString(2, request.getParameter("pdesc"));
			ps.setInt(3, Integer.parseInt(request.getParameter("price")));
			ps.setInt(4, Integer.parseInt(request.getParameter("disc")));
			ps.setString(5, request.getParameter("pid"));
			int n=ps.executeUpdate();
			response.sendRedirect("showpro.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
