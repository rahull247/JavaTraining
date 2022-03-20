package com.example.javafeatures.junit2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.Alphanumeric.class)
//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExecutionOrderTesting {

	
	@Test
	@DisplayName("3")
	@Order(2)
	void method_1() {
		System.out.println("method:1");
	}
	
	@Test
	@DisplayName("1")
	@Order(3)
	void method_2() {
		System.out.println("method:2");
	}
	
	@Test
	@DisplayName("2")
	@Order(1)
	void method_3() {
		System.out.println("method:3");
	}
}
