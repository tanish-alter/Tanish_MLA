package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao empDao;

    @Override
    public Customer saveCustomer(Customer employee) {
        return empDao.saveCustomer(employee);
    }

    @Override
    public Customer updateCustomer(Customer employee) {
        return empDao.updateCustomer(employee);
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return empDao.getCustomerById(id);
    }

    @Override
    public List<Customer> deleteCustomerById(int id) {
        return empDao.deleteCustomerById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return empDao.getAllCustomers();
    }
}