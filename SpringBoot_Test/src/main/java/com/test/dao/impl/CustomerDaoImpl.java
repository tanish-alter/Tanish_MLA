package com.test.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.repository.CustomerRepository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private CustomerRepository repository;
	@Override
	public Customer saveCustomer(Customer cmr) {
		
		return repository.save(cmr);
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {
		
		return repository.findById(id);
	}

	@Override
	public Customer updateCustomer(Customer cmr) {
		
		return repository.save(cmr);
	}

	@Override
	public List<Customer> deleteCustomerById(int id) {
		
		repository.deleteById(id);
		
		return repository.findAll();
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return repository.findAll();
	}

}
