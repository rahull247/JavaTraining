package com.example.keycloakserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KeycloakServerApplication {

	@GetMapping("/customers/hello")
	public String getCustomerHello() {
	   return "Hello Customer!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KeycloakServerApplication.class, args);
	}

}
