package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.service.EmployeeService;

public class SpringMain {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeService empService = ctx.getBean("employeeService", EmployeeService.class);
		
		System.out.println(empService.getEmployee().getName());
		
		empService.getEmployee().setName("Rohit");
		
		empService.getEmployee().throwException();
	}

}
