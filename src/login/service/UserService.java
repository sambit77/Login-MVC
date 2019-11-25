package login.service;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import login.db.Users;

public class UserService {

	public static void sendPassword(Users ob) 
	{
		// TODO Auto-generated method stub
		
		    String to = ob.getEmail();
		    String subject = "Password Sent";
		    String message = "Hello Dear , Your Password is : " + ob.getPassword();

		    String from = "samenterpriseedition@gmail.com";
		    final String password = "playinggames";
		    try
		    {
		      Properties props = new Properties();
		      props.put("mail.smtp.host", "smtp.gmail.com");
		      props.put("mail.smtp.socketFactory.port", "465");
		      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.port", "465");

		      Authenticator auth = new Authenticator() {
		        public PasswordAuthentication getPasswordAuthentication() {
		          return new PasswordAuthentication(from, password);
		        }
		      };
		      Session session = Session.getInstance(props, auth);

		      MimeMessage msg = new MimeMessage(session);
		      msg.setFrom(new InternetAddress(from));
		      msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		      msg.setSubject(subject);
		      msg.setText(message);

		      Transport.send(msg);
		      System.out.println("Message delivered successfully , Check your mail ...........");
		    }
		    catch (MessagingException e)
		    {
		      e.printStackTrace();
		
	}
	}
}


