package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Book obj = new Book();
		obj.setB_name("SQL");
		obj.setB_author("Infosys");
		obj.setB_price(3);
		
		//insert command
//		session.persist(obj);
//		t.commit();
		
		//read command
//		Book b = session.get(Book.class, 1);
//		System.out.println(b);
		
		//update command
//		b.setB_name("HTML");
//		b.setB_author("Rohit");
//		b.setB_price(2);
//		session.persist(b);
//		t.commit();
		
//		delete command
//		session.remove(b);
//		t.commit();
		
//		read all record
//		List<Book> books = session.createNativeQuery("SELECT * FROM book", Book.class).list();
//		books.forEach(System.out::println);
		
//		or
		
//		List<Book> list = session.createQuery("from Book").list();
//		list.forEach(System.out::println);
		System.out.println("Done");
	}
}
