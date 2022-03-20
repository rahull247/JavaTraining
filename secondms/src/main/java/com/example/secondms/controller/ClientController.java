package com.example.secondms.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;




@RestController
@EnableHystrix
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@HystrixCommand(fallbackMethod = "getPersonsFromCache",
			   commandProperties = {
			      @HystrixProperty(
			            name = "execution.isolation.thread.timeoutInMilliseconds",
			            value = "5000"
			      ),
			         @HystrixProperty(
			               name = "execution.isolation.strategy",
			               value = "THREAD"
			         )
			   },
			   threadPoolKey = "firstmsThreadPoolKey",
			      threadPoolProperties = {
			         @HystrixProperty(name = "coreSize", value = "4"),
			         @HystrixProperty(name = "maxQueueSize", value = "5")
			      }
			)
	@GetMapping(path="/client-persons", produces = MediaType.APPLICATION_JSON_VALUE)
	public List getPersonList() {
		 LOGGER.info("*****client person**********");
		List<ClientPersonDto> personDto=restTemplate.getForObject("http://firstms/persons", List.class); 
		return personDto;
	}
	
	private List getPersonsFromCache() {
         LOGGER.info("*****getPersonsFomCache**********");
        return Arrays.asList("One", "Two", "Three");
    }
	
	@PostMapping(path="/client-person", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object addPerson() {
        HttpHeaders httpHeader=new HttpHeaders();
        httpHeader.set("accept", MediaType.APPLICATION_JSON_VALUE);
        httpHeader.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        ClientPersonDto dto=new ClientPersonDto();
        dto.setAge(19);
        dto.setName("John Wick");
        HttpEntity<ClientPersonDto> httpEntity=new HttpEntity<>(dto,httpHeader);
		Object personDto=restTemplate.postForObject("http://localhost:8080/persons",httpEntity,  Object.class); 
		return personDto;
	}
	
	@PostMapping(path="/client-person-xml", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String xmlAddPerson() {
        HttpHeaders httpHeader=new HttpHeaders();
        httpHeader.set("accept", MediaType.APPLICATION_XML_VALUE);
        httpHeader.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        ClientPersonDto dto=new ClientPersonDto();
        dto.setAge(46);
        dto.setName("TOmmy");
        HttpEntity<ClientPersonDto> httpEntity=new HttpEntity<>(dto,httpHeader);
		String personDto=restTemplate.postForObject("http://localhost:8080/persons",httpEntity,  String.class); 
		return personDto;
	}
	
	
}
