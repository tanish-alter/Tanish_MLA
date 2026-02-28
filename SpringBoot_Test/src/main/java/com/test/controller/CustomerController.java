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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Customer;
import com.test.exceptions.CustomerNotFoundException;
import com.test.repository.CustomerRepository;
import com.test.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/customer/v1/api")
@Tag(name="CUSTOMER CRUD OPERATIONS")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private CustomerRepository repository;
	
	@PostMapping("/create")
	@Operation(summary="CREATE Customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer emp){
		Customer cobj=service.saveCustomer(emp);
		
		if(cobj != null) {
			return new ResponseEntity<>(cobj,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(cobj,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/list", produces="application/json")
	@Operation(summary="LISTING ALL CustomerS")
	public ResponseEntity<List<Customer>> listAllCustomers(){
		
		List<Customer> list=service.getAllCustomers();
		
		if(list.size() >0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable int id){
		
		Optional <Customer> cobj = service.getCustomerById(id);
		
		if(cobj != null ) {
			return new ResponseEntity<>(cobj, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(cobj, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}", consumes = "application/json")
	@Operation(summary = "UPDATE Customer")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Customer Updated"),
	    @ApiResponse(responseCode = "404", description = "NO_CONTENT_GIVEN_FOR_GIVEN_REQUEST")
	})
	public ResponseEntity <Customer> updateCustomerById(@PathVariable int id, @RequestBody Customer cmr){
		
		cmr.setId(id);
		
		Customer cobj = service.updateCustomer(cmr);
		
		if(cobj != null ) {
			return new ResponseEntity<>(cobj, HttpStatus.ACCEPTED);
		}
		else {
			throw new CustomerNotFoundException("NO_CONTENT_GIVEN_FOR_GIVEN_REQUEST");
			
			//return new ResponseEntity<>(cobj, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = "application/json")
	public ResponseEntity <List<Customer>> deleteCustomerById(@PathVariable int id){
		
		List<Customer> list = service.deleteCustomerById(id);
 	
		if( list.size()> 0 ) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byname/{name}")
	@Operation(summary="GET Customer BY NAME")
	public ResponseEntity <List<Customer>> getCustomerByName(@PathVariable String name){
		
		List<Customer> cobj = repository.getCustomerByName(name);
		
		if(cobj.size()>0) {
			return new ResponseEntity<>(cobj, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(cobj, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/list/{phone}")
	@Operation(summary="GET Customer BY Phone No.")
	public ResponseEntity<List<Customer>> getCustomerByPhone(@PathVariable String phone){
		
		List<Customer> list = repository.getCustomersByPhone(phone);
		
		if(list.size()>0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/list/{email}")
	@Operation(summary="GET Customer BY Google Mail")
	public ResponseEntity<List<Customer>> getCustomerByMailDomain(@PathVariable String phone){
		
		List<Customer> list = repository. getCustomersByEmailDomain(phone);
		
		if(list.size()>0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/emplist")
	@Operation(summary= "Customers Sorting by Name")
	public ResponseEntity<List<Customer>> getCustomerByNameASC(){
		
		List<Customer> list = repository.getCustomerByAsc();
		
		if(list.size()>0) {
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
}

//CREATE,ASC Methods have BAD_REQUEST

//OTHER METHODS HAVE NOT_FOUND
