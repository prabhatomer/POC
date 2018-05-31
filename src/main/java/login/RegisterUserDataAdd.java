package login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RegisterUserDataAdd {
	public Integer addUserData(String username, String password, String email) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Transaction tx = null;
		Session session = factory.openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			RegisterPojo rp = new RegisterPojo();
			rp.setUsername(username);
			rp.setPassword(password);
			rp.setEmail(email);
			session.save(rp);
			
			LoginPojo lp=new LoginPojo();
			lp.setUsername(username);
			lp.setPassword(password);
			session.save(lp);
			
			tx.commit();
			session.clear();
			return 1;
		} catch (Exception e) {
			session.close();
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}
}
