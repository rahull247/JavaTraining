package com.example.kafkaconsumerms1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumerms1Application {

	@KafkaListener(topics = "myTopics", groupId = "a")
	public void consumer(String message) {
		System.out.println("Consumer 1: recived message:"+message);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerms1Application.class, args);
	}

}
