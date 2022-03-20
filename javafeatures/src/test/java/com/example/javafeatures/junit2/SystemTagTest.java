package com.example.javafeatures.junit2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemTag")
public class SystemTagTest {
	
	@Test
    void fullSystemCheck() {
		System.out.println("Full System Check");
	}
	
	@Test
	void halfSystemCheck() {
		System.out.println("Half System Check");
	}
}
