package com.example.singlesignms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SinglesignmsApplication extends WebSecurityConfigurerAdapter{

	@GetMapping("/home")
	   public String getHome() {
	      System.out.println("Inside getHome method.");
	      return "index.html";
	   }
	
	public static void main(String[] args) {
		SpringApplication.run(SinglesignmsApplication.class, args);
	}

	
	 @Override
	   protected void configure(HttpSecurity http) throws Exception {
	      http.oauth2Login();
	      http.authorizeRequests().anyRequest().authenticated();
	   }

	   @Bean
	   public ClientRegistrationRepository clientRegistrationRepository() {
	      ClientRegistration clientRegistration = clientRegistration();
	      return new InMemoryClientRegistrationRepository(clientRegistration);
	   }

	   public ClientRegistration clientRegistration() {
	      return CommonOAuth2Provider.GITHUB
	            .getBuilder("github")
	            .clientId("e808380b43588b420a6b")
	            .clientSecret("b8a3cde109c03e35691aad2bb6a1fa962a5242ca")
	            .build()
	         ;
	   }
}
