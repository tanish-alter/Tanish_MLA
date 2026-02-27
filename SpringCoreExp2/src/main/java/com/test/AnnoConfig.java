package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AnnoConfig {
	@Bean
	@Primary
	public Customer getCustomer() {
		
		return new Customer();
	}
	
	@Bean
	public Address getAddress() {
		return new Address();		
	}
}
