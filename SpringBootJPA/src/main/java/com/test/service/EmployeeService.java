package com.test.service;

import java.util.List;
import java.util.Optional;
import com.test.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp);
	
	public Optional<Employee> getEmployeeById(int id);
	
	public Employee updateEmployee(Employee emp);
	
	public List<Employee> deleteEmployeeById(int id);
	
	public List<Employee> getAllEmployees();
}
