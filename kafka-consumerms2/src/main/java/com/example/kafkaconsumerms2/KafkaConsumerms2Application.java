package com.example.kafkaconsumerms2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumerms2Application {

	@KafkaListener(topics = "myTopics", groupId = "b")
	public void consumer(String message) {
		System.out.println("Consumer 2: recived message:"+message);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerms2Application.class, args);
	}

}
