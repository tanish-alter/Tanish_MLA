package com.test.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.BookDao;
import com.test.entity.Book;
import com.test.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private BookRepository repository;
	@Override
	public Book saveBook(Book book) {
		
		return repository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		
		return repository.save(book);
	}

	@Override
	public Optional<Book> getBookById(int id) {
		
		return repository.findById(id);
	}

	@Override
	public List<Book> deleteBookById(int id) {
		
		repository.deleteById(id);
		
		return repository.findAll();
	}

	@Override
	public List<Book> getAllBooks() {
		
		return repository.findAll();
	}

}
