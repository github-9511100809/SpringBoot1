package com.ayaz.android.helpers;

import java.util.Date;
import java.util.Properties;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.hibernate.grammars.hql.HqlParser.VariableContext;
import org.hibernate.query.NativeQuery.ReturnableResultNode;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendEmail {
	public static Boolean sendmail(String email, String password) {
		// variabe for G-mail
		String host = "smtp.gmail.com";

		// get the system system properties
		Properties properties = System.getProperties();

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "ture");
		properties.put("mail.smtp.auth", "true");
		properties.put("authentication", "plain");
		properties.put("domain", "gmail.com");

		/// step1
		/// get the session object
		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("khanayaz4961@gmail.com", "johnsimon");

			}

		});
		session.setDebug(true);

		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

			mimeMessage.setSubject("your password is ", password);

			String conten = "<h2>QUERY : Siddiquiayaz  </h2>\r\n  " + "\r\n " + "\r\n  "
					+ "<table style=\"width:100%;border: 1px solid black;\">\r\n  "
					+ "<tr style=\"border: 1px solid black;\">\r\n"
					+ "<th style=\"border: 1px solid black;\">firstname</th> \r\n"
					+ "<th style=\"border: 1px solid black;\">lastname</th> \r\n"
					+ "<th style=\"border: 1px solid black;\">Course</th> \r\n"
					+ "<th style=\"border: 1px solid black;\">Email</th> \r\n"
					+ "<th style=\"border: 1px solid black;\">mobile</th> \r\n" + "</tr>\r\n" + "</tr>\r\n"
					+ "<td style=\"border: 1px solid black;\">" + email + "</td> \r\n" + "</tr>\r\n" + "\r\n"
					+ "</tabl>";
                 
			  mimeMessage.setContent(conten ,"text/htl");
			  mimeMessage.setSentDate(new Date());
			  Transport.send(mimeMessage);
			  System.out.println("succsess fully send");
			  return true;
			
		} catch (Exception e) {
			  
			e.printStackTrace();
			return false;
			
		}

		
	}

}
