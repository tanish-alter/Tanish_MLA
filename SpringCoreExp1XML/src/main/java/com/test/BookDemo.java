package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookDemo {
	public static void main(String[] args) {
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		
//		Book b = (Book)ctx.getBean("bk"); //Object has to be type-casted to Book type
//	
//		System.out.println(b);
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoConfig.class);
		
		BookDetails b1= ctx.getBean(BookDetails.class);
		
		Book b2 = ctx.getBean(Book.class);
		
		b1.setPages(2200);
		b1.setPublisher("MLA");
		b1.setYear(2026);
		
		List<BookDetails> list = new ArrayList<>();
		
		list.add(b1);
		
		b2.setId(201);
		b2.setName("Spring Notes");
		b2.setAuthor("Arjun");
		b2.setPrice(5);
		b2.setListbd(list);
		
		System.out.println(b2);
	
	}
}
