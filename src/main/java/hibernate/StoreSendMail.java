package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreSendMail {
	public String storeMail(String to, String subject, String message) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Transaction tx = null;

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		try {
			Session session = factory.openSession();
			tx = session.beginTransaction();
			SendMailPojo SMP = new SendMailPojo();
			SMP.setMailid(1);
			SMP.setTo("ds");
			SMP.setSubject("sds");
			SMP.setMessage("sdsdssdsd");
			SMP.setDate(date);
			session.save(SMP);
			tx.commit();
			return "true";
		} catch (HibernateException e) {
			System.err.print(e);
			if (tx != null)
				tx.rollback();
			return "false";
		}
	}
}
