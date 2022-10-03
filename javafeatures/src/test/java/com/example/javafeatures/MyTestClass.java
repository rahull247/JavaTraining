package com.example.javafeatures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class MyTestClass {

	@Test
	void lambdaEpression() {
	 MyFunctionalInterface myFun=(String s1, String s2)->{
		return s1;
		};
		
		myFun.returnString();
	}
	
	@Test
	void forEachExample() {
		List<String> list=new ArrayList<String>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("irfan");  
        list.add("jai");  
        
        list.forEach(print->System.out.println(print));
        System.out.println("----------------------");
        list.forEach(System.out::println);
	}
	
	@Test
	void filterExample() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 79, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
		 // List<String> newList= stream.filter(Student-> Student.getMarkScience()> 64).map(Student->Student.getName()).collect(Collectors.toList());
	     // newList.forEach(System.out::println);
	     // int max1=stream.mapToInt(Student::getMarkScience).max().getAsInt();  
	         List <String>newStream=stream.map((s)->s.getName()).sorted().collect(Collectors.toList());
	      //System.out.println(max1);
	         newStream.forEach(System.out::println);
	}
	
	@Test
	void filterOpertion() {
		Stream<String> nameStream = Stream.of("mohan","john","vaibhav","amit");
		Stream<String> nameStartJ = nameStream.map(
		        (s) ->
		        {
		            System.out.println("Map: "+s);
		            return s.toUpperCase();
		 
		        })
		        .filter(
		        (s) ->
		        {
		             System.out.println("Filter: "+s);
		             return s.startsWith("J");
		        } 
		    );
		 
		Optional<String> findAny = nameStartJ.findAny();
		if(findAny.isPresent())
		{
		System.out.println("Final output: "+findAny.get());
		}else {
			System.out.println("No found");
		}
	}
}
