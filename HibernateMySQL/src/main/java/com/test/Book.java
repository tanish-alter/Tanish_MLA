package com.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
//	@Column(name = "book_name",nullable=false,precision=50)
	private String b_name;
	
	private String b_author;
	
	private int b_price;
	
	
	public Book() {
	}
	
	public Book(int id, String b_name, String b_author, int b_price) {
		super();
		this.id = id;
		this.b_name = b_name;
		this.b_author = b_author;
		this.b_price = b_price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_author() {
		return b_author;
	}
	public void setB_author(String b_author) {
		this.b_author = b_author;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", b_name=" + b_name + ", b_author=" + b_author + ", b_price=" + b_price + "]";
	}
	
}
