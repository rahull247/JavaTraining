package com.example.securedms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	 @Bean
	    @Override
	    protected UserDetailsService userDetailsService() {

	        UserDetails rahul = User.withUsername("rahul")
	                .password("qwerty")
	                .roles("read", "hello")
	                .build();
	        
	        UserDetails james = User.withUsername("james")
	                .password("qwerty")
	                .roles("write", "welcome")
	                .build();
	        
	        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
	        userDetailsManager.createUser(rahul);
	        userDetailsManager.createUser(james);
	        return userDetailsManager;
	    }

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
//	        http.authorizeRequests().anyRequest().authenticated();
//	        http.authorizeRequests().anyRequest().permitAll();
		 
		/*
		 * http.httpBasic(); http.csrf().disable() 
		 * .authorizeRequests()
		 * .mvcMatchers("/hello").hasRole("read")
		 * .mvcMatchers("/welcome").hasRole("write");
		 */
		 
		/*
		 * http.httpBasic(); 
		 *  http.csrf().disable() 
		 * .authorizeRequests()
		 * .mvcMatchers(HttpMethod.GET, "/hello").hasRole("read")
		 * .mvcMatchers(HttpMethod.POST, "/welcome").hasRole("write")
		 * //.anyRequest().authenticated(); 
		 * .anyRequest().denyAll();
		 */
		/*
		 * http.httpBasic(); http.csrf().disable() 
		 * .authorizeRequests()
		 * .mvcMatchers(HttpMethod.GET, "/hello").hasAnyRole("read", "hello")
		 * .mvcMatchers(HttpMethod.POST, "/welcome").hasAnyRole("write", "welcome")
		 * .anyRequest().denyAll();
		 */
		   
		 http.httpBasic(); 
		 http.csrf().disable() 
		  .authorizeRequests()
		  .mvcMatchers(HttpMethod.GET, "/hello").access("hasRole('read') and hasRole('hello')")
		  .mvcMatchers(HttpMethod.POST, "/hello").access("hasRole('write') and hasRole('hello')")
		  .mvcMatchers(HttpMethod.GET, "/welcome").access("hasRole('read') and hasRole('welcome')")
		  .mvcMatchers(HttpMethod.POST, "/welcome").access("hasRole('write') and hasRole('welcome')")
		  .anyRequest().denyAll();
		 
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }
	
}
