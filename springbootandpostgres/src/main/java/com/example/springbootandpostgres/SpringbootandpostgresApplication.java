package com.example.springbootandpostgres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootandpostgres.entity.Customer;
import com.example.springbootandpostgres.repo.CustomerRepo;

@SpringBootApplication
@RestController
public class SpringbootandpostgresApplication {

	@Autowired
	CustomerRepo customerRepo;
	
	@GetMapping("/hello")
	public List<Customer> getAllList(){
	  	return customerRepo.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootandpostgresApplication.class, args);
	}

}
