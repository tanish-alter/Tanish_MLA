package com.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.TypedQuery;

import org.hibernate.*;

public class EmpDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf =  cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		List<String> s1 = Arrays.asList("JAVA","CLOUD","DevOps");
		
		List<String> s2 = Arrays.asList("php","Python","React");
		
		Employee emp1 = new Employee();
		
		emp1.setE_name("Rohit");
		
		emp1.setSkills(s1);
		
		Employee emp2 = new Employee();
		
		emp2.setE_name("Kohli");
		
		emp2.setSkills(s2);
		
//		session.persist(emp1);
//		
//		session.persist(emp2);
		
		
		
		t.commit();
		
		TypedQuery<Employee> tq = session.createQuery("from Employee");
		
		List<Employee> list = tq.getResultList();
		
		Iterator<Employee> itr =list.iterator();
		
		while(itr.hasnext()) {
			
			Employee emp = itr.next();
			
			System.out.println("Employee : " +emp.getE_name());
			
			skills.forEach(System.out.println);
			
			
		}
		
		session.close();
	}
}
