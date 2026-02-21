package com.test;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private String c_name;
	
	@ManyToMany(targetEntity = Order.class, cascade=CascadeType.ALL)
	@JoinTable(name="cst_rdr", joinColumns = {@JoinColumn(name ="c_id")}, inverseJoinColumns = {@JoinColumn(name="o_id")})
	
	private List<Order> orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", c_name=" + c_name + ", orders=" + orders + "]";
	}
	
}
