package com.test.service;

import java.util.List;
import java.util.Optional;

import com.test.entity.Book;

public interface BookService {
public Book saveBook(Book book);
	
	public Book updateBook(Book book);
	
	public Optional<Book> getBookById(int id);
	
	public List<Book> deleteBookById(int id);
	
	public List<Book> getAllBooks();
}
