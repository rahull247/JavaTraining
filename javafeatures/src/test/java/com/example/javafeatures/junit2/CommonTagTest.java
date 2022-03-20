package com.example.javafeatures.junit2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CommonTagTest {

	@Test
	@Tag("DbTag")
	void pgSql() {
		System.out.println("pgSQL DB");
	}
	
	@Test
	@Tag("systemTag")
	void commonSystem() {
		System.out.println("Common System Check");
	}
}
