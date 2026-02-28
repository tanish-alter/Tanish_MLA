package com.test.dao;

import java.util.List;
import java.util.Optional;

import com.test.entity.Customer;

public interface CustomerDao {
	
	public Customer saveCustomer(Customer cmr);
	
	public Optional<Customer> getCustomerById(int id);
	
	public Customer updateCustomer(Customer cmr);
	
	public List<Customer> deleteCustomerById(int id);
	
	public List<Customer> getAllCustomers();
}
