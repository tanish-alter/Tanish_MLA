package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.FruitsDao;
import com.test.model.Fruits;


public class TestDemo {
	public static void main(String[] args) {
		
	
	ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
	
	FruitsDao dao = ctx.getBean(FruitsDao.class);
	
	Fruits f = new Fruits();
	
	f.setId(201);
	f.setName("Mango");
	f.setPrice(50);
	f.setQuantity(15);
	
	dao.saveFruits(f);
	
	List<Fruits> list = dao.selectFruits();
	
	list.forEach(System.out::println);
}
}