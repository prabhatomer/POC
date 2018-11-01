package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.model.Person;

public class PersonDAOImpl implements PersonDAO {
	private SessionFactory sessionfactory;

	public void setSessonfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		System.out.print(this.sessionfactory);
	}

	public Boolean save(Person P) {
		Session session = this.sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		Integer id = (Integer) session.save(P);
		if (id > 0) {
			tx.commit();
			session.close();
			return true;
		} else {
			session.close();
			return false;

		}

	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {
		Session session = this.sessionfactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}

}
