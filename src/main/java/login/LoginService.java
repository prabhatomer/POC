package login;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoginService {
	public Integer login(String username, String password) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Transaction tx = null;
		Session session = factory.openSession();
		int result = 0;
		try {
			tx = session.beginTransaction();
			String hql = "FROM LoginPojo E WHERE E.username = :username";
			Query query = session.createQuery(hql);
			query.setParameter("username", username);
			List results = query.list();

			for (Iterator iterator = results.iterator(); iterator.hasNext();) {
				LoginPojo employee = (LoginPojo) iterator.next();
				if (password.equals(employee.getPassword())) {
					result = 1;
				}
				System.out.println("First Name: " + employee.getUsername());
				System.out.println("  Last Name: " + employee.getPassword());

			}
			tx.commit();
			session.clear();
			return result;
		} catch (Exception e) {
			session.close();
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;
	}
}
