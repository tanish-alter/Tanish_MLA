package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	
}
