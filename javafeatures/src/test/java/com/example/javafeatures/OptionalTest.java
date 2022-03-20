package com.example.javafeatures;

import static org.assertj.core.api.Assertions.in;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class OptionalTest {

	   /* Optional:
		* 1) of
		* 2) ofNullable
		* 3) empty
		* 4) isPresent -> Predicate
		* 5) ifPresent -> Consumer
		* 6) get or orElse: optional.get
		* 7) Optional with filter and map
        */
	
	@Test
	void ofTest() {
		  Car car=new Car();
		  Person person=new Person();
		  person.setCar(Optional.of(car));
		  System.out.println(person);
	}
	
	@Test
	void ofNullableTest() {
		  Car car=new Car();
		  Person person=new Person();
		  person.setCar(Optional.ofNullable(car));
		  System.out.println(person);
	}
	
	@Test
	void emptyTest() {
		  Optional<Person> emptyPerson=Optional.empty();
		  System.out.println(emptyPerson);
		  
		  Optional<Car> emptyCar=Optional.empty();
		  System.out.println(emptyCar);
	}
	
	
	@Test
	void isPresentTest() {
		  Optional<Person> emptyPerson=Optional.empty();
		 
		      if(emptyPerson.isPresent()) {
		    	  System.out.println(emptyPerson.get());
		      }
		      System.out.println("Person is empty");
	}
	
	@Test
	void ifPresentTest() {
		  Optional<Person> emptyPerson=Optional.empty();
		      emptyPerson.ifPresent(s->System.out.println(s));
		    	
	}
	
	
	@Test
	void orElseTest() {
		Optional<Person> emptyPerson=Optional.empty();
		 
	      if(emptyPerson.isPresent()) {
	    	  System.out.println(emptyPerson.get());
	      }else {
	    	  System.out.println(emptyPerson.orElse(null));
	      }
	      
		    	
	}
	
	@Test
	void optionalWithFilterAndMap() {
		processData(Optional.ofNullable(getString(1)));
		processData(Optional.ofNullable(getString(2)));
		processData(Optional.ofNullable(getString(3)));
	}
	
	private String getString(int number) {
		if(number==1) {
			return "one";
		}
		if(number==2) {
			return "two";
		}
		return null;
	}
	
	private void processData(Optional<String> optionalString) {
		String returnString=optionalString
				.filter(s -> s.equals("one"))
				.map(s-> s.toUpperCase())
				.orElse("Not a null string");
		System.out.println(returnString);
	}
	
	//flatMap
	@Test
	void flatMapTest() {
		Person person=new Person();
		Insurance insurance=new Insurance();
		Car car=new Car();
		insurance.setName("New 2022 Insurance");
		car.setInsurance(Optional.of(insurance));
		person.setCar(Optional.of(car));
		System.out.println(getInsuranceName(person));
	}
	
	public Optional<String> getInsuranceName(Person person){
		Optional<Insurance> insurance=Optional.of(person).flatMap(Person->Person.getCar()).flatMap(Car->Car.getInsurance());         
	     
		System.out.println(insurance.get().getName());
		
		return Optional.of(insurance.get().getName());
	}
}
