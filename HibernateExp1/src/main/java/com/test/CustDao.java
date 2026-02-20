package com.test;


import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;


public class CustDao {

    private static SessionFactory sf;

    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sf = cfg.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getDBSession() {
        return sf.openSession();
    }

    public void saveCustomer(Customer cst) {
        Session session = getDBSession();
        Transaction t = session.beginTransaction();

        session.persist(cst);

        t.commit();
        session.close();
    }

    public List<Customer> getAllCustomers() {
        Session session = getDBSession();

        Query<Customer> q = session.createQuery("from Customer", Customer.class);
        List<Customer> list = q.list();

        session.close();
        return list;
    }
    
    public void updateCustomer(Customer cst) {
    	Session session = CustDao.getDBSession();
    	Transaction t = session.beginTransaction();
    	Customer obj = session.find(Customer.class, cst);
    	obj.setC_name(cst.getC_name());
    	obj.setC_city(cst.getC_city());
    	session.persist(obj);
    	t.commit();
    }
}