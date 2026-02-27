package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ctx.registerShutdownHook();
		
		Triangle t = ctx.getBean("triangle" , Triangle.class);
		
		t.draw();
	}

}
