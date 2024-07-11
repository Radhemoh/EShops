package mypck;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to=request.getParameter("to");
		String cc=request.getParameter("cc");
		String bcc=request.getParameter("bcc");
		String from=request.getParameter("from");
		String pass=request.getParameter("pass");
		String sub=request.getParameter("sub");
		String cnt=request.getParameter("cnt");
		
		Properties props=System.getProperties();
		props.setProperty("mail.smtp.host","smpt.gmail.com");
		props.setProperty("mail.smpt.port", "587");
		props.setProperty("mail.smpt.auth", "true");
		props.setProperty("mail.smpt.starttls.enable", "true");
		
	    Session session=Session.getDefaultInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,pass);
			}
	    });	
	    MimeMessage msg=new MimeMessage(session);
	    try
	    {
	    msg.addRecipient(RecipientType.TO, new InternetAddress(to));
	    msg.addRecipient(RecipientType.CC, new InternetAddress(cc));
	    msg.addRecipient(RecipientType.BCC, new InternetAddress(bcc));
	    
	    msg.setSubject(sub);
	    msg.setText(cnt);
	    Transport.send(msg);
	    response.getWriter().write("<h1> Mail sent Successfully ...</h1>");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}

}
