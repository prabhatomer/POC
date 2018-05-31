package mailer;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {
	public static String send(final String from, final String password, String to, String sub, String msg) {
		// Get properties object
		System.out.println(from+password+to+sub+msg);
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setContent(msg, "text/html");
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
			return "true";
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String Send(String to, String sub, String msg) {
		String result = SendMail.send("tom99911@gmail.com", "iam9838586161", to, sub, msg);
		return result;
	}

}
