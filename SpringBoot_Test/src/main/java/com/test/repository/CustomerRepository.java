package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT c FROM Customer c WHERE c.phone = :phone")
	List<Customer> getCustomersByPhone(@Param("phone") String phone);
	
	@Query("SELECT c FROM Customer c WHERE c.name = :name")
	List<Customer> getCustomerByName(@Param("name") String name);

	@Query("SELECT c FROM Customer c ORDER BY c.name ASC")
	List<Customer> getCustomerByAsc();

	@Query("SELECT c FROM Customer c WHERE LOWER(c.email) LIKE LOWER(CONCAT('%', :domain))")
	List<Customer> getCustomersByEmailDomain(@Param("domain") String domain);

}