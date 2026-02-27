package com.test;

import java.util.Arrays;
import java.util.List;

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

        Transaction tx = session.beginTransaction();

        // Create Orders
        Order o1 = new Order();
        o1.setO_name("Orange");
        o1.setO_price("5");   // fixed datatype

        Order o2 = new Order();
        o2.setO_name("Apple");
        o2.setO_price("10");

        
        List<Order> list = Arrays.asList(o1, o2);
        
        // Create Customer
        
        Customer cst = new Customer();
        cst.setC_name("Rohit");
        cst.setOrders(list);
        
        
        //Set relationship properly (VERY IMPORTANT)
        //o1.setCustomer(cst);
        //o2.setCustomer(cst);

        
        

        session.persist(cst);

        tx.commit();

        session.close();
 
    }
}