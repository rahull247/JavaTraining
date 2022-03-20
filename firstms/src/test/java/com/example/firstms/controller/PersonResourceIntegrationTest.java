package com.example.firstms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.example.firstms.model.Person;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonResourceIntegrationTest {

	 @LocalServerPort
	    private int port;
	    @Autowired
	    private TestRestTemplate restTemplate; 
	    
	    @Test
	    void getPersons() {
	        String url = "http://localhost:" + port + "/persons";
	        ResponseEntity<List<Person>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
	        });
	        assertEquals(200, response.getStatusCode().value());
	        List<Person> personList = response.getBody();
	        assertNotNull(personList);
	        assertTrue(personList.size() == 2);
	        Person john = personList.get(0);
	        assertEquals("James Bond", john.getName());
	        assertEquals(50, john.getAge());
	        assertEquals(1, john.getId());
	        assertEquals("Bond", john.getNickName());
	        Person jane = personList.get(1);
	        assertEquals("Jacky Chan", jane.getName());
	        assertEquals(62, jane.getAge());
	        assertEquals(2, jane.getId());
	        assertEquals("Jacky", jane.getNickName());
	    }
}
