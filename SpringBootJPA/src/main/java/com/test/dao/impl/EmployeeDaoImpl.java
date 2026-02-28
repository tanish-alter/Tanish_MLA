package com.test.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EmployeeRepository repository;
	@Override
	public Employee saveEmployee(Employee emp) {
		
		return repository.save(emp);
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) {
		
		return repository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		
		return repository.save(emp);
	}

	@Override
	public List<Employee> deleteEmployeeById(int id) {
		
		repository.deleteById(id);
		
		return repository.findAll();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repository.findAll();
	}

}
