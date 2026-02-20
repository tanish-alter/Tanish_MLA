package com.test;

import java.util.List;

public class CustDemo {
	
	public static void main(String[] args) {
		
		CustDao cdao = new CustDao();
		
		Customer cst = new Customer();
		
		cst.setC_id(1);
		
		cst.setC_name("Hello");
		
		cst.setC_city("Mumbai");
		
		/* cdao.saveCustomer(cst); */
		
		cdao.updateCustomer(cst);
		
		//List<Customer> list = cdao.getAllCustomers();
		
		//list.forEach(System.out::println);
	}

}
