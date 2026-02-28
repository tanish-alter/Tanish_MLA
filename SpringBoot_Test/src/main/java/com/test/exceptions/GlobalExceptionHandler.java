package com.test.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> employeeNotFoundException(CustomerNotFoundException e, WebRequest request){
		
		ErrorMessage message = new ErrorMessage();

        message.setTimestamp(new Date());
        message.setMessage(e.getMessage());   
        message.setUrl(request.getDescription(false));
        message.setStatusCode(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> UnknownException(CustomerNotFoundException e, WebRequest request){
		
		ErrorMessage message = new ErrorMessage();

        message.setTimestamp(new Date());
        message.setMessage(e.getMessage());
        message.setUrl(request.getDescription(false));
        message.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		
		
	}
}
