package com.test;


import jakarta.persistence.*;
import jakarta.persistence.NamedQuery;

@Entity
@Table(name="customer")
@NamedQueries({
	@NamedQuery(name = "customquery", query ="from Customer c where c.c_name = :name")
	//"C"ustomer capital
})

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int c_id;
	
	private String c_name;
	
	private String c_city;
	
	public Customer() {
		
	}

	public Customer (int c_id, String c_name, String c_city) {
		
		this.c_id=c_id;
		this.c_name=c_name;
		this.c_city=c_city;
	}
	
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_city() {
		return c_city;
	}

	public void setC_city(String c_city) {
		this.c_city = c_city;
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", c_name=" + c_name + ", c_city=" + c_city + "]";
	}
	
	
}
