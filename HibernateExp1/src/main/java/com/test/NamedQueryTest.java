package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jakarta.persistence.Query;
import org.hibernate.cfg.Configuration;

public class NamedQueryTest {
	public static void main(String[] args) {
	
		Configuration cfg = new Configuration();
				
		cfg.configure("hibernate.cfg.xml");
				
		SessionFactory sf = cfg.buildSessionFactory();
				
		Session session = sf.openSession();
				
		Transaction t = session.beginTransaction();
				
		Query query = session.createNamedQuery("customquery");
		
		query.setParameter("name", "sky");
		
		List list = query.getResultList();
		
		System.out.println(list);
		
		session.close();
				
		
		

	}
}
