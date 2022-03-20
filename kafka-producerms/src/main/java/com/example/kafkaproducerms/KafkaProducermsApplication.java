package com.example.kafkaproducerms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaProducermsApplication {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/message/{message}")
	public String proudcer(@PathVariable String message) {
		System.out.println("Producer recived message:"+message);
		kafkaTemplate.send("myTopics", message);
		System.out.println("Producer sent message:");
		return message;
	}
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducermsApplication.class, args);
	}

}
