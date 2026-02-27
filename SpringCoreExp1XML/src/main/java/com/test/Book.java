package com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

public class Book {
	private int id;
	
	private String name;
	
	private String author;
	
	private int price;
	
	@Autowired
	private List<BookDetails> listbd;

	public List<BookDetails> getListbd() {
		return listbd;
	}

	public void setListbd(List<BookDetails> listbd) {
		this.listbd = listbd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + ", listbd=" + listbd
				+ "]";
	}
	
}
