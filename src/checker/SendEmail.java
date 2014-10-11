package checker;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendEmail {
	
	
	public void mail(String data,String appversion){
 
//	public static void main(String[] args) {
 
		final String username = "versionchecker1@gmail.com";
		final String password = "version@123";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Amazon-checker@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("pradil90@gmail.com"));
//			message.setRecipients(Message.RecipientType.CC,
//					InternetAddress.parse("rinitageorge@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear viewer,"
				+ "\n\n This is a test mail for Amazon Tool checker Version1.1\n\n"
					+ "Current version for the App:" + appversion + "\n\n" + data
					+ "\n\nThank and Regards" + "\nAmazon version checker Team");
 
			Transport.send(message);
 
			System.out.println("Successfully sent");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
//}

