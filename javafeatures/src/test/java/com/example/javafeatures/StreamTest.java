package com.example.javafeatures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class StreamTest {

	@Test
	void extractDataFromList() {
		ArrayList<String> objArrayList = new ArrayList<String>();
		ArrayList<String> objNewArrayList = new ArrayList<String>();
		objArrayList.add("Rahul");
		objArrayList.add("Kunal");
		objArrayList.add("Akshay");

		for (String str : objArrayList) {

			if (str.charAt(0) == 'A') {
				objNewArrayList.add(str.toUpperCase());
			}

		}

		System.out.println(objNewArrayList);
	}
	
	
	
	
	@Test
	void extractStreamDataFromList() {
		   List<User> list=new ArrayList<User>();
		   list.add(new User(1, "Rahul", 11L));
		   list.add(new User(2, "Akshay",12L));
		   list.add(new User(3, "Akshay",13L));                          
		   
		   List<String> newList=list.stream().filter(u -> u.name.startsWith("A"))
					                 .map(u->u.name.toLowerCase())
					                 .distinct()
					                 .collect(Collectors.toList());
			
			System.out.println(newList);

	}
	
	@Test
	void extractStreamDataFromList1() {
		/* Exercise: 3
		* input: 1, "John", 21 -> output: Map<String, Long> map = <John, 21> 
		* User: id, name, age
		* 1) List of User with dummy values
		* 2) Get a Map<String, Long> : Map<String, Long> map = <John, 21> 
         */
		
		 List<User> list=new ArrayList<User>();
		   list.add(new User(1, "Rahul", 11L));
		   list.add(new User(2, "Akshay",12L));
		   list.add(new User(3, "Ajinkya",13L));                          
		   list.add(new User(4, "Amit",45L));                          
		   
		   Map<String, Integer> newMap=list.stream().filter(u->u.getName().startsWith("R"))
				.distinct()
				.collect(Collectors.toMap(User::getName, User::getId));
					                 
			
			newMap.entrySet().forEach(p -> System.out.println(p.getKey()+ ":"+p.getValue()));

		
		
	}
	
	
	/* Exercise 4:
		* limit(int) : limit(3): Three elements will be selected
		* skip(int) : skip(3): Three elements will be skipped
		* flatMap: flattens each generated stream into a single stream
		* findAny(): returns single element(generally the first element but not guaranteed)
		* findFirst():  returns single element(guaranteed to return the first element)
		* anyMatch(Predicate): Any element that matches the Predicate
		* allMatch(Predicate): All elements that match the Predicate
		* noneMatch(Predicate): No elements in the stream match the Predicate
        */
	
	@Test
	void limitTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		List<String> stream=stringList.stream().limit(2).collect(Collectors.toList());
		System.out.println(stream);
		
	}
	
	@Test
	void skipTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		List<String> stream=stringList.stream().skip(2).collect(Collectors.toList());
		System.out.println(stream);
		
	}
	
	@Test
	void flatMapTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		List<String> stream=stringList.stream()
				.map(s-> s.split(""))
				.flatMap(Arrays::stream)
				.collect(Collectors.toList());
		System.out.println(stream);
		
	}
	
	@Test
	void findFirstTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		Optional<String> stream=stringList.stream()
				.findFirst();
				
		if(stream.isPresent()) {
			System.out.println(stream.get());
		}
		System.out.println(stream);
		
	}
	
	@Test
	void findAnyTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		Optional<String> stream=stringList.stream()
				.findAny();
				
		if(stream.isPresent()) {
			System.out.println(stream.get());
		}
		System.out.println(stream);
		
	}
	
	@Test
	void anyMatchTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		boolean stream=stringList.stream()
				.anyMatch(s->s.length()>3);
				
		System.out.println("Any match:"+stream);
		
	}
	
	@Test
	void allMatchTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		boolean stream=stringList.stream()
				.allMatch(s->s.length()>3);
				
		System.out.println("All match:"+stream);
		
	}
	
	@Test
	void noneMatchTest() {
		List<String> stringList=Arrays.asList("Feature", "Of", "List");
		boolean stream=stringList.stream()
				.noneMatch(s->s.length()>3);
				
		System.out.println("none match:"+stream);
		
	}
	
	/* Exercise: 5
	* 1) Sorting: Natural Order Sorting, Complex Objects
	* 2) Aggregation: sum, min, max
    */
	
	@Test
	void NatrualSort() {
		Stream<String>stream=Stream.of("abc","xyz", "pqr");
		Stream<String> sortedStream=stream.sorted();
		
		sortedStream.forEach(System.out::println);
		
	}
	
	@Test
	void ComplexSort() {
		Stream<User>stream=Stream.of(new User(1, "Rahul", 11L),
				  new User(2, "Ganesh", 15L),
				  new User(3, "Rahul", 12L));
		Stream<User> list=stream.sorted(Comparator.comparing(User::getIdNumber));
		
		list.forEach(System.out::println);
		
	}

	@Test
	void AggregationMin() {
		Stream<User>stream=Stream.of(new User(1, "Rahul", 11L),
				  					 new User(2, "Ganesh", 15L),
				  					 new User(3, "Rahul", 12L));
		    LongStream longStream=stream.mapToLong(User::getIdNumber);
		     //long sumOfAge=longStream.sum();
		     //System.out.println(sumOfAge);
		     //OptionalLong minAge=longStream.min();
		     //System.out.println(minAge);
		     OptionalLong maxAge=longStream.max();
		     System.out.println(maxAge);
		
	}
	
	/* Exercise: 6
	* A new class(Student) with name, age, marksMaths, marksScience
	*
	* Generate following reports:
	* 1) Display name of all Students in Alphabetical order
	* 2) Display name of Student who got highest in Maths (use Comparator inside max)
	* 3) Display name of Student who got highest in Science (use Comparator inside max)
	* 4) Display name of Student who got highest overall (use Comparator inside max)
	* 5) Display the name of youngest student
	* 6) Display the name of eldest student
	* 7) Display highest marks in Maths
	* 8) Display highest marks in Science
	*/
	
	
	@Test
	void studentAlphbeticalOrder() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 78, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
		Stream<String> list=stream.map(Student->Student.getName())
				.sorted();
		
		list.forEach(System.out::println);
	}
	
	@Test
	void displayStudentNameMaxInMath() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 79, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
	   System.out.print(stream.max(Comparator.comparing(Student::getMarkMath)).get().getName());
	}
	
	@Test
	void displayStudentNameMaxInScience() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 79, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
	   System.out.print(stream.max(Comparator.comparing(Student::getMarkScience)).get().getName());
	}
	
	@Test
	void displayStudentNameMaxInOverall() {
		List<Student>student=new ArrayList<Student>();
		student.add(new Student("Rahul", 21, 79, 89));
		student.add(new Student("Ganesh", 22, 78, 65));
		student.add(new Student("Akshay", 26, 74, 89));
		Optional<Student> highestInScience=student.stream().max(Comparator.comparing(
				Student->Student.getMarkScience() + Student.getMarkMath()));
		System.out.println("Higest Overall: "+highestInScience.get().getName());
	}
	
	@Test
	void studentYoung() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 79, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
		IntStream list=stream.mapToInt(Student::getAge);
		OptionalInt minAge=list.min();
				
		
		System.out.println("Hight Science Marks:"+minAge.getAsInt());
	}
	
	@Test
	void studentOlder() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 79, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
		IntStream list=stream.mapToInt(Student::getAge);
		OptionalInt maxAge=list.max();
				
		
		System.out.println("Hight Science Marks:"+maxAge.getAsInt());
	}
	
	@Test
	void studentMaxInMath() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 79, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
		IntStream list=stream.mapToInt(Student::getMarkMath);
		OptionalInt max1=list.max();
				
		
		System.out.println("Hight Math Marks:"+max1.getAsInt());
	}
	
	@Test
	void studentMaxInScience() {
		Stream<Student>stream=Stream.of(new Student("Rahul", 21, 79, 65),
				  new Student("Ganesh", 22, 78, 65),
				  new Student("Akshay", 26, 74, 89));
		IntStream list=stream.mapToInt(Student::getMarkScience);
		OptionalInt max1=list.max();
				
		
		System.out.println("Hight Science Marks:"+max1.getAsInt());
	}
	
}
