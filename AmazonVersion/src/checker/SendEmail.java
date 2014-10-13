package checker;

import java.util.Properties;
import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendEmail {
	

		
	public void mail(){

 
		final String username = "versionchecker1@gmail.com";
		final String password = "version@123";
 
		//Mail properties setting//
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		//Mail user authentication//
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
			//Current time//
			Date date=new Date();
			String rundate=date.toString();
			
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Amazon-checker@gmail.com"));
			
			//Setting recipient for the report//
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("pradil90@gmail.com"));
			//Setting suject line//
			message.setSubject("Amazon version checker tool report | " + rundate);
			//Setting the report data//
			message.setText("Dear viewer,"
				+ "\n\n This is an automated mail alert from Amazon Version checker Tool  Version2.0\n\n"
					+ Amazon.facebookresult + "\n" 
				    + Amazon.netflixresult + "\n" 
				    + Amazon.youtuberesult + "\n" 
				    + Amazon.rokuresult + "\n"
				    + Amazon.twitterresult + "\n"
				    + Amazon.pandoraresult + "\n"
					+ "\n\nThanks and Regards" + "\nAmazon version checker Team");
			

			//sending generated Message//
			Transport.send(message);
 
			System.out.println("Successfully sent");
			
			//Error handling//
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}


