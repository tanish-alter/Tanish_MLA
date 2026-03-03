package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.entity.Role;
import com.test.entity.User;
import com.test.repository.RolesRepository;
import com.test.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	
	public User findById(Integer id) {
		
		return userRepository.findById(id).orElse(null);
	}
	
	public User save(User user) {
		
		if(user.getPassword() != null && !user.getPassword().startsWith("$2a")){
			
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		
		return userRepository.save(user);
	}
	
	public void deleteById(Integer id) {
		
		userRepository.deleteById(id);
	}
	
	public List<Role> findAllRoles(){
		
		return rolesRepository.findAll();
	}
	
	
	
}
