package com.test;

import java.util.List;

public class TestDemo {
	
	public static void main  (String[] args) {
		StudDao edao = new StudDao();
	
		Student stud1 = new Student();
	
		stud1.setUSN(1);
		stud1.setName("GCAM");
		stud1.setSch("Google");
		stud1.setCity("MELBOURNE");
		
		//edao.saveEmployee(emp1);
		
		edao.updateEmployee(stud1);
		
		System.out.println("Added Student Data.");
		
		List<Student> data = edao.getAllStudents();

		data.forEach(System.out::println);
	
	}
}
