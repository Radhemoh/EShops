package mypck;

import java.sql.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyConnection implements ServletContextListener {
    public static Connection con;
    
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshops?useSSL=false","root","root");
		    sce.getServletContext().setAttribute("mycon",con);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	
		try
		{
			con.close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

	
}
