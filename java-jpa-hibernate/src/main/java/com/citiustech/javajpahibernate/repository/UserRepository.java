package com.citiustech.javajpahibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.javajpahibernate.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByFirstName(String name);
	List<User> findByLastName(String name);
	List<User> findByFirstNameAndLastName(String firstname,String lastname);
	List<User> findByage(int age);
	List<User> findByAgeLessThan(int age);
	List<User> findByAgeGreaterThan(int age);
	
	
	
	
}
