package dump;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibTest {
	public static void main(String args[]) {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		System.out.println(cfg);
		SessionFactory factory =cfg.buildSessionFactory();
		System.out.println(factory);
		Transaction tx=null;
		try {
			Session session=factory.openSession();
			tx=session.beginTransaction();
			Product p=new Product();
			p.setPrice(12);
			p.setProductId(12);
			p.setProName("ndfd");
			session.save(p);
		
			tx.commit();
			System.out.println("pass");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail");
		}
	}
}
