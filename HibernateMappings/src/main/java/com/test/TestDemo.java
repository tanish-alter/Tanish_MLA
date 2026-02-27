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
        Orders o1 = new Orders();
        o1.setO_name("Laptop");
        o1.setO_price(234);

        Orders o2 = new Orders();
        o2.setO_name("Mouse");     // fixed (was setting o1 again)
        o2.setO_price(12);

        // Create User
        User uobj = new User();
        uobj.setU_name("Rohit");

        // Set relationship properly
        o1.setUser(uobj);
        o2.setUser(uobj);

        List<Orders> listOrder = Arrays.asList(o1, o2);
        uobj.setOrders(listOrder);

        session.persist(uobj);

        tx.commit();   // missing commit
        session.close();
        sf.close();    // close factory
    }
}