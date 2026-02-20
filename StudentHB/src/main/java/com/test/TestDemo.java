package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		College c1 = new College();
		c1.setC_name("MLA");
		Student s1 = new Student();
		s1.setC_name("Rohit");
		s1.setS_type("Regular");
		s1.setS_branch("SOFTWARE");
		
		Faculty f1 = new Faculty();
		f1.setC_name("Arjun");
		f1.setF_type("Regular");
		f1.setF_skill("Admin");
		
		session.persist(c1);
		session.persist(s1);
		session.persist(f1);
		
		session.persist(c1);
		session.persist(s1);
		t.commit();
		session.close();
	}
}