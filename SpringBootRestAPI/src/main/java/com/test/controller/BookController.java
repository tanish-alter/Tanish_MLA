package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.BookService;
import com.test.entity.Book;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	//To secure and Handle HTTP Protocol
	@PostMapping(value="/create",consumes="application/json")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		
		Book bk=bookService.saveBook(book);
		
		if(bk!=null) {
			return new ResponseEntity<>(bk, HttpStatus.CREATED);
			
		}
		else {
			return new ResponseEntity<>(bk, HttpStatus.NO_CONTENT);
		}	
	}
	
	@GetMapping(value="/list", produces="application/json")
	public ResponseEntity<List<Book>> listAllBooks(){
		
		List<Book> list = bookService.getAllBooks();
		
		if(list.size() > 0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public ResponseEntity<Optional<Book>> getBookById(@PathVariable int id){
		
		Optional <Book> bk = bookService.getBookById(id);
		
		if(bk != null ) {
			return new ResponseEntity<>(bk, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(bk, HttpStatus.NO_CONTENT);
		}
	}
	
	
	@PutMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity <Book> updateBookById(@PathVariable int id, @RequestBody Book book){
		
		book.setId(id);
		
		Book bk = bookService.updateBook(book);
		
		if(bk != null ) {
			return new ResponseEntity<>(bk, HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>(bk, HttpStatus.BAD_REQUEST);
		}
	}

		
	@DeleteMapping(value="/{id}", consumes = "application/json")
	public ResponseEntity <List<Book>> deleteBookById(@PathVariable int id){
		
		List<Book> list = bookService.deleteBookById(id);
 	
		if( list.size()> 0 ) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.NO_CONTENT);
		}
	}

}
