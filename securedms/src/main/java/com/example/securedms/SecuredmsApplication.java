package com.example.securedms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecuredmsApplication {

	@GetMapping("hello")
	public String getHello() {
		return "GET: Hello security!!!";
	}
	
	@PostMapping("hello")
	public String postHello() {
		return "POST: Hello security!!!";
	}
	
	@GetMapping("welcome")
	public String getWelcome() {
		return "GET: Welcome security!!!";
	}
	
	@PostMapping("welcome")
	public String postWelcome() {
		return "POST: Welcome security!!!";
	}
	
	@PreAuthorize("hasRole('ROLE_read')")
	@GetMapping("secured")
	public String getSecured() {
		return "GET: Secured!!!";
	}
	
	@PostMapping("secured")
	public String postSecured() {
		return "POST: Secured!!!";
	}
	
	@DeleteMapping("secured")
	public String deleteSecured() {
		return "DELETE: Secured!!!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecuredmsApplication.class, args);
	}

}
