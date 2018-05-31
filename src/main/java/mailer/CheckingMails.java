package mailer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;





public class CheckingMails {

	public static ArrayList<Mail> check(String host, String storeType, String user, String password) {
		ArrayList<Mail> mailList=new ArrayList<Mail>();
		
		try {

			// create properties field
			Properties properties = new Properties();

			properties.put("mail.pop3.host", host);
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("pop3s");

			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.getMessages();
			System.out.println("messages.length---" + messages.length);

			Logger logger = Logger.getLogger("MyLog");
			FileHandler fh;
			// This block configure the logger with handler and formatter
			 fh = new FileHandler("/Users/prabhatomer/Documents/MyLogFile.log");
			 logger.addHandler(fh);
			 SimpleFormatter formatter = new SimpleFormatter();
			 fh.setFormatter(formatter);

			// the following statement is used to log any messages
			logger.info(String.valueOf(messages.length));
			
			for (int i = 0, n = messages.length; i < 4; i++) {
				Message message = messages[i];
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				logger.info(String.valueOf(i + 1));
				
				System.out.println("Subject: " + message.getSubject());
				logger.info(String.valueOf(message.getSubject()));
				
				System.out.println("From: " + message.getFrom()[0]);
				logger.info(String.valueOf(message.getFrom()[0]));
				
				System.out.println("Text: " + message.getContent().toString());
				logger.info(message.getContent().toString());
				
				Mail m=new Mail();
				m.setFrom(message.getFrom()[0].toString());
				m.setSubject(message.getSubject().toString());
				m.setText(message.getContent().toString());
				System.out.println("m object"+ m.getText());
				mailList.add(m);
			}

			// close the store and folder objects
			emailFolder.close(false);
			store.close();
			return mailList;


		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return null;
		} catch (MessagingException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public ArrayList<Mail> getMailData(){

		String host = "pop.gmail.com";// change accordingly
		String mailStoreType = "pop3";
		String username = "tom99911@gmail.com";// change accordingly
		String password = "i";// change accordingly

		return check(host, mailStoreType, username, password);

	}

}