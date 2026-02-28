package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("SELECT e FROM Employee e WHERE e.company = :company")
	List<Employee> getEmployeesByCompany(@Param("company") String company);
	
	@Query("SELECT e FROM Employee e WHERE e.name = :name")
	List<Employee> getEmployeeByName(@Param("name") String name);

	@Query("SELECT e FROM Employee e ORDER BY e.name ASC")
	List<Employee> getEmployeeByAsc();

}