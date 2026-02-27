package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String o_name;
	
	private String o_price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public String getO_price() {
		return o_price;
	}

	public void setO_price(String o_price) {
		this.o_price = o_price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", o_name=" + o_name + ", o_price=" + o_price + "]";
	}
	
	
	
}
