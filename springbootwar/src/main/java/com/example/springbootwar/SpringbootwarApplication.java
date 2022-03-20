package com.example.springbootwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootwarApplication {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot War";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootwarApplication.class, args);
	}

}
