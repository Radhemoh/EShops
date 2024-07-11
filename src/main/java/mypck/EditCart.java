package mypck;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/EditCart")
public class EditCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditCart() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String pid=request.getParameter("pid");
		HttpSession session=request.getSession();
		ArrayList<String>list=(ArrayList)session.getAttribute("cart");
		
		list.remove(pid);
		session.setAttribute("cart", list);
		response.sendRedirect("showcart.jsp");
	}
}
