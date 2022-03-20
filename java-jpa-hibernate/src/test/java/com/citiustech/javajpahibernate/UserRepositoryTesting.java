package com.citiustech.javajpahibernate;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.citiustech.javajpahibernate.model.User;
import com.citiustech.javajpahibernate.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTesting {
    
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void getUserByName() {
	List<User> user =userRepository.findByFirstName("Rahul");
	user.forEach(u-> System.out.println(u));

	}

	@Test
	public void getUserBylastName() {
	List<User> user =userRepository.findByLastName("Lokhande");
	user.forEach(u-> System.out.println(u));

	}
	@Test
	public void getUserByFirstAndlastName() {
	List<User> user =userRepository.findByFirstNameAndLastName("John","Wick");
	user.forEach(u-> System.out.println(u));

	}
	@Test
	public void getUserByage() {
	List<User> user =userRepository.findByage(25);
	user.forEach(u-> System.out.println(u));

	}
	@Test
	public void getUserlessthane() {
	List<User> user =userRepository.findByAgeLessThan(29);
	user.forEach(u-> System.out.println(u));

	}
	@Test
	public void getUsergreaterthane() {
	List<User> user =userRepository.findByAgeGreaterThan(25);
	user.forEach(u-> System.out.println(u));

	}
	
	@Test
	public void getUserSortByNameAndAge() {
	Sort sortByName=Sort.by("firstName");
	Sort sortByAge=Sort.by("age");
	List<User> user =userRepository.findAll(sortByName);
	user.forEach(u-> System.out.println(u));

	}

	@Test
	public void getUserPagination() {
	PageRequest page=PageRequest.of(0, 2);
	Page<User> userPage =userRepository.findAll(page);
	if(userPage.hasContent()) {
		List<User> user=userPage.getContent();
		user.forEach(u->System.err.println(u.getFirstName()+" / "+ u.getLastName()));
	}

	}

	@Test
	public void getUserPaginationAndSorting() {
		Sort sortByName=Sort.by("firstName");
	PageRequest page=PageRequest.of(0, 2, sortByName);
	Page<User> userPage =userRepository.findAll(page);
	if(userPage.hasContent()) {
		List<User> user=userPage.getContent();
		user.forEach(u->System.err.println(u.getFirstName()+" / "+ u.getLastName()));
	}

	}
	
	
	
}
