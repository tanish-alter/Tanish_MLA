package com.test.service;

import java.util.List;
import java.util.Optional;
import com.test.entity.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer cmr);
	
	public Optional<Customer> getCustomerById(int id);
	
	public List<Customer> deleteCustomerById(int id);
	
	public List<Customer> getAllCustomers();

	public Customer updateCustomer(Customer cmr);

}
