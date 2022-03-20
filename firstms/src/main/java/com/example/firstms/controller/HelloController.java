package com.example.firstms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstms.service.ProfileService;

@RestController
public class HelloController {

	@Autowired
	private ProfileService profileService;
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${otherms.url}")
	private String othermsUrl;
	
	@GetMapping("/profiles")
	public String getProfileData() {
		return profileService.getData();
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello Rest!";
	}
	
	
	@GetMapping
	public Map returnProperty() {
	HashMap<String, String> map=new HashMap<>();
	map.put("dbUrl", dbUrl);
	map.put("othermsUrl", othermsUrl);
	return map;
	}
}
