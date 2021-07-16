package com.bt.demo.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bt.demo.app.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	User findByUsername(String username);

}
