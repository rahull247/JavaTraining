package com.example.javafeatures.junit2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.example.javafeatures.junit3.AggregationMethods;

public class Excercised {
	
	@Test
	void testMinMax_Small() {
		AggregationMethods agg = new AggregationMethods();
		assertEquals(agg.minMax(Arrays.asList(1,2,3)),"Small Number");	
	}
	
	@Test
	void testMinMax_Max() {
		AggregationMethods agg = new AggregationMethods();
		assertEquals(agg.minMax(Arrays.asList(12,11,14)),"Max Number");	
	}
}
