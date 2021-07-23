package com.bt.demo.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bt.demo.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.username = :username and u.password = :password")
	User findUser(String username, String password);

}
