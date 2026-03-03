package com.test.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import com.test.entity.User;
 
 
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.username=:username")
	public User getUserByUsername(@Param("username") String username);
	
}