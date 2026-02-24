package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		
//		Customer obj = ctx.getBean("cst",Customer.class);
//		
//		System.out.println(obj);
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoConfig.class);
		
		Address aobj = ctx.getBean(Address.class);
		
		aobj.setCity("Tirumala");
		aobj.setState("AP");
		aobj.setCountry("IN");
		
		Customer cst = ctx.getBean(Customer.class);
		
		cst.setId(06);
		cst.setName("SKY");
		cst.setAdr(aobj);
		
		System.out.println(cst);
	
	}
}
