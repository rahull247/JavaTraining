package com.example.javafeatures.junit3;

import java.util.List;

public class AggregationMethods {

	public String minMax(List<Integer> value) {
		  Integer longStream=value.stream().max((i,j)->i.compareTo(j)).get();
		  System.out.println(longStream);
        if(longStream > 10)
        {
        	return "Max Number";
        }
        
        return "Small Number";
	}
}
