package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchFactory {
	SessionFactory factory=null;
	public SessionFactory getFactory()
	{
		try {
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			return factory;
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	}

}
