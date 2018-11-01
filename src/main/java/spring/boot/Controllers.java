package spring.boot;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hibernate.StoreSendMail;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import mailer.CheckingMails;
import mailer.*;
import mailer.Mail;
import com.dao.*;
import com.model.*;

@RestController
public class Controllers {
	@GET
	@Produces("application/json")
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/getAllMail")
	public ArrayList<Mail> getAllMail() {
		return new CheckingMails().getMailData();

	}

	@RequestMapping("/sendMail/{to}/{subject}/{text}")
	public String sendmail(@PathVariable("to") String to, @PathVariable("subject") String subject,
			@PathVariable("text") String text) {
		String result = "false";
		System.out.println("hi controller");
		System.out.println(to + subject + text);
		StoreSendMail SSM = new StoreSendMail();
		String result1 = SSM.storeMail(to, subject, text);
		if (result1 != "false") {
			SendMail sm = new SendMail();
			result = sm.Send(to, subject, text);
		}
		return result;
	}

	@RequestMapping("/addMember/{name}/{country}")
	public Boolean addMember(@PathVariable("name") String name, @PathVariable("country") String country) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);
		Person person = new Person();
		person.setName(name);
		person.setCountry(country);

		Boolean result = personDAO.save(person);

		System.out.println("Person::" + person);

		// List<Person> list = personDAO.list();
		//
		// for (Person p : list) {
		// System.out.println("Person List::" + p);
		// }
		context.close();
		return result;

	}

}
