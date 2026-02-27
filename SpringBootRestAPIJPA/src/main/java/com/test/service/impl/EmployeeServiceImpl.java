package com.test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.EmployeeDao;
import com.test.entity.Employee;
import com.test.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao empDao;

    @Override
    public Employee saveEmployee(Employee employee) {
        return empDao.saveEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return empDao.updateEmployee(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return empDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> deleteEmployeeById(int id) {
        return empDao.deleteEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empDao.getAllEmployees();
    }
}