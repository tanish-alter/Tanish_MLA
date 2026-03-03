package com.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Product;
import com.test.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public void save(Product product) {
		
		repository.save(product);
	}
	
	public List<Product> listAll(){
		return repository.findAll(); 
	}
	
	public Product get(int id) {
		return repository.findById(id).get();
	}
	
	public void delete(int id) {
		
		repository.deleteById(id);
	}
}
