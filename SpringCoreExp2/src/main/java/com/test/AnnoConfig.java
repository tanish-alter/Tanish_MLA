package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConfig {
	@Bean
	public Address getAddress() {
		return new Address();		
	}
	
	@Bean
	public Customer getCustomer() {
		
		return new Customer();
	}
}
