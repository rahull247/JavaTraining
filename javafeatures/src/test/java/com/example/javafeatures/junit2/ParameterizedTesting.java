package com.example.javafeatures.junit2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.javafeatures.junit3.Animals;
import com.example.javafeatures.junit3.Calculator;
import com.example.javafeatures.junit3.MyMethods;
import com.example.javafeatures.junit3.Student;

public class ParameterizedTesting {

	@org.junit.jupiter.params.ParameterizedTest(name="{index} of test integer")
	@ValueSource(ints = {1,2,3})
	void intTest(int values) {
		System.out.println("Printing values:"+values);
	}
	
	@org.junit.jupiter.params.ParameterizedTest(name="{index} of test string")
	@ValueSource(strings = {"alpha","beta","gamma"})
	void stringTest(String values) {
		System.out.println("Printing values:"+values);
	}
	
	@org.junit.jupiter.params.ParameterizedTest(name="{index} of test Enum")
	@EnumSource(value=Animals.class)
	void enumTest(Animals animal) {
		System.out.println("Printing values:"+animal);
	}
	
	@org.junit.jupiter.params.ParameterizedTest
	@EnumSource(value=Animals.class,  names = {"TIGER","LION"})
	void enumIncludeTest(Animals animals) {
		System.out.println("Printing values:"+animals);
	}
	
	@org.junit.jupiter.params.ParameterizedTest
	@EnumSource(value=Animals.class, names = {"TIGER","CAT"}, mode = EnumSource.Mode.EXCLUDE)
	void enumExcludeTest(Animals animal) {
		System.out.println("Printing values:"+animal);
	}
	
	@org.junit.jupiter.params.ParameterizedTest
	@CsvSource(value= {"2,4","3,3"})
	void mulitplyCsvTest(int a, int b) {
		System.out.println("a:"+a+"---"+"b:"+b);
		Calculator cal=new Calculator(new MyMethods());
		int actual=cal.addition(a, b);
		System.out.println("Actual Result:"+actual);
		int expected=(a*2)+(b*2);
		System.out.println("Expected Result:"+expected);
		assertEquals(actual, expected);
	}
	
	@org.junit.jupiter.params.ParameterizedTest
	@CsvSource(value= {"One,Two","Hello,World"})
	void mulitplyCsvTest(String a, String b) {
		System.out.println("a:"+a+"---"+"b:"+b);
		
	}
	
	@org.junit.jupiter.params.ParameterizedTest
	@MethodSource("stringProvider")
	void stringMethodTest(String string) {
		System.out.println("String"+string);
		
	}
	
	 static List<String> stringProvider(){
		return Arrays.asList("Black", "Yellow");
	}
	
	@org.junit.jupiter.params.ParameterizedTest
	@MethodSource("streamProvider")
	void streamMethodTest(String string) {
		System.out.println("Stream:"+string);
		
	}
	
	 static Stream<String> streamProvider(){
		return Stream.of("Black", "Yellow");
	}
	
	@org.junit.jupiter.params.ParameterizedTest
	@MethodSource("studentProvider")
	void studentMethodTest(Student student) {
		System.out.println("Student:"+student);
		
	}
	
	 static List<Student> studentProvider(){
		Student alice=new Student();
		alice.setId(1L);
		alice.setFirstName("Alice");
		alice.setLastName("Doe");
		alice.setDob(LocalDate.now());
		alice.setAge(25L);
		
		Student light=new Student();
		light.setId(2L);
		light.setFirstName("Light");
		light.setLastName("Yagami");
		light.setDob(LocalDate.now());
		light.setAge(23L);
		return Arrays.asList(alice,light);
	}
	 
	 
	 
}

