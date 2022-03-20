package com.example.javafeatures.junit2;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("DbTag")
public class DBTagTest {

	@Test
	void mySql() {
		System.out.println("mySql DB");
	}
	
	@Test
	void oracleDbTag() {
		System.out.println("Oracle DB");
	}
}
