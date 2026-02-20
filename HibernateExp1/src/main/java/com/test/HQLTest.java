package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;

public class HQLTest {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		//String hql = "From Book B";
		
		String hql = "select c.c_name from Customer c";
		
		//String hql = "delete from Book where id = :bid";
		
		/*
		 * Query query = session.createQuery(hql);
		 * 
		 * query.setParameter("bid", 52);
		 * 
		 * int row = query.executeUpdate();
		 * 
		 * t.commit();
		 * 
		 * //List list = query.getResultList();
		 * 
		 * System.out.println(row+" Deleted Successfully.");
		 * 
		 * session.close();
		 */
	}
}
