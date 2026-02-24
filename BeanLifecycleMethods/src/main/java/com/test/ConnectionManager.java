package com.test;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class ConnectionManager {
	
	private boolean isConnected = false;
	
	@PostConstruct
	public void connect() {
		System.out.println("Connecting to external service.........");
		
		isConnected = true;
		
		System.out.println("Connection Established........ isConnected : "+ isConnected);
		
		
	}
	
	@PreDestroy
	public void disconnect() {
		
		System.out.println("Disconnecting from the Host....");
		
		isConnected  = false;
		
		System.out.println("Connection Closed !!!!!!  isConnected : "+ isConnected);
	}
	
	public void operation() {
		
		if(isConnected) {
			
			System.out.println("performing operation with the Connection...");
		}
		else {
			
			System.out.println("operation failed not connected...");
		}
	}

}
