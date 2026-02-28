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

import com.test.entity.Employee;
import com.test.exceptions.EmployeeNotFoundException;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee/v1/api")
@Tag(name="EMPLOYEE CRUD OPERATIONS")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping("/create")
	@Operation(summary="CREATE EMPLOYEE")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
		Employee eobj=service.saveEmployee(emp);
		
		if(eobj != null) {
			return new ResponseEntity<>(eobj,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(eobj,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value="/list", produces="application/json")
	@Operation(summary="LISTING ALL EMPLOYEES")
	public ResponseEntity<List<Employee>> listAllEmployees(){
		
		List<Employee> list=service.getAllEmployees();
		
		if(list.size() >0) {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id){
		
		Optional <Employee> eobj = service.getEmployeeById(id);
		
		if(eobj != null ) {
			return new ResponseEntity<>(eobj, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(eobj, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value="/{id}", consumes = "application/json")
	@Operation(summary = "UPDATE EMPLOYEE")
	@ApiResponses(value = { @ApiResponse(responseCode = "202", description = "Employee Updated"),
	    @ApiResponse(responseCode = "404", description = "NO_CONTENT_GIVEN_FOR_GIVEN_REQUEST")
	})
	public ResponseEntity <Employee> updateEmployeeById(@PathVariable int id, @RequestBody Employee emp){
		
		emp.setId(id);
		
		Employee eobj = service.updateEmployee(emp);
		
		if(eobj != null ) {
			return new ResponseEntity<>(eobj, HttpStatus.ACCEPTED);
		}
		else {
			throw new EmployeeNotFoundException("NO_CONTENT_GIVEN_FOR_GIVEN_REQUEST");
			
			//return new ResponseEntity<>(eobj, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/{id}", produces = "application/json")
	public ResponseEntity <List<Employee>> deleteEmployeeById(@PathVariable int id){
		
		List<Employee> list = service.deleteEmployeeById(id);
 	
		if( list.size()> 0 ) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byname/{name}")
	@Operation(summary="GET EMPLOYEE BY NAME")
	public ResponseEntity <List<Employee>> getEmployeeByName(@PathVariable String name){
		
		List<Employee> eobj = repository.getEmployeeByName(name);
		
		if(eobj.size()>0) {
			return new ResponseEntity<>(eobj, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(eobj, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/list/{company}")
	@Operation(summary="GET EMPLOYEE BY COMPANY")
	public ResponseEntity<List<Employee>> getEmployeeByCompany(@PathVariable String company){
		
		List<Employee> list = repository.getEmployeesByCompany(company);
		
		if(list.size()>0) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/emplist")
	@Operation(summary= "employees Sorting by Name")
	public ResponseEntity<List<Employee>> getEmployeeByNameASC(){
		
		List<Employee> list = repository.getEmployeeByAsc();
		
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
