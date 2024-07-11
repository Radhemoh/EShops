package mypck;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Add2Cart")
public class Add2Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Add2Cart() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String pid=request.getParameter("pid");
	HttpSession session=request.getSession();
	ArrayList<String>list=(ArrayList)session.getAttribute("cart");
	if(list==null)
	{
		list=new ArrayList<String>();
	}
	list.add(pid);
	request.getSession().setAttribute("cart", list);
	response.sendRedirect("buyer.jsp");
	}

}
