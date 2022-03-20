package com.example.javafeatures;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



//@SpringBootTest
class JavafeaturesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void AnonymousLambda() throws InterruptedException {
		// Anonymous
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Running the run method using anonymous");

			}
		};

		Thread thread = new Thread(myRunnable);
		thread.start();
		thread.join();

		// Lambda Expression
		Runnable myRunnable2 = () -> {
			System.out.println("Running the run method using lambda");
		};

		Thread thread2 = new Thread(myRunnable2);
		thread2.start();
		thread2.join();

	}

	@Test
	void CustomFunctionalInterface() {

		MyFunctionalInterface myFuctionalInterface = (s1, s2) -> {
			return s1.toUpperCase() + " " + s2.toLowerCase();
		};
		MyFunctionalInterface myFuctionalInterface2 = (s1, s2) -> {
			return s1.concat(s2);
		};

		System.out.println(myFuctionalInterface.myStringMethod("Hello", "World!"));
		System.out.println(myFuctionalInterface2.myStringMethod("Welcome,", "to Java"));

	}

	/**
	 * java.util.Function
	 * 1) Consumer -> accepts an argument but returns nothing(void): void accept(T t); 
	 * 2) Function -> accepts an argument and returns something: R apply(T t); 
	 * 3) Predicate -> accepts an argument and returns boolean : boolean test(T t); 
	 * 4) Supplier -> accepts nothing but returns something: T get(); 
	 * 5) Runnable -> accepts nothing and returns nothing(void): void run();
	 */
	@Test
	void Consumer_String() {
		Consumer<String> myConsumer = s1 -> {
			System.out.println("Consumer:" + s1 + "-->Concated Word");
		};

		myConsumer.accept("Hello");
	}

	@Test
	void Function_Integer_Integer() {
		Function<Integer, Integer> function = s -> {
			return s * 5;
		};

		System.out.println("Function:" + function.apply(2));
	}

	@Test
	void Predicate_String() {
		Predicate<String> predicate = str -> {
			if (str.equals("Hello")) {
				return true;
			} else {
				return false;
			}
		};

		System.out.println("Predicate:" + predicate.test("hello"));
		System.out.println("Predicate:" + predicate.test("Hello"));
	}

	@Test
	void Supplier_String() {
		Supplier supplier = () -> {
			return "Supplier accepts nothing return something.";
		};

		System.out.println("Supplier:" + supplier.get());
	}

	@Test
	void InterfaceDefaultandStatic() {
		MyFunctionalInterface myFun = (String s1, String s2) -> {
			String str1 = MyFunctionalInterface.staticStrings(s1);
			return str1;
		};
		myFun.returnString();

		System.out.println("My Static:" + myFun.myStringMethod("hello", "World"));

	}

	/**
	 * java.util.Function
	 * 1) BiConsumer -> accepts an 2 argument but returns nothing(void): void accept(T t); 
	 * 2) BiFunction -> accepts an 2 argument and returns something: R apply(T t); 
	 * 3) BiPredicate -> accepts an 2 argument and returns boolean : boolean test(T t); 
	 */
	@Test
	void BIpredicate_String() {
		BiPredicate<String, String> predicate = (str, str1) -> str.equalsIgnoreCase(str1);

		System.out.println("Predicate:" + predicate.test("hello", "Hello"));
		System.out.println("Predicate:" + predicate.test("Hello", "java"));
	}

	@Test
	void Biconsumer_String() {
		BiConsumer<String, String> myConsumer = (s1, s2) -> {
			System.out.println("String 1:" + s1 + " String 2:" + s2);
			System.out.println("String 1 Length:" + s1.length() + " String 2 Length:" + s2.length());
			System.out.println("Is Strings same:" + s1.equals(s2));
		};

		myConsumer.accept("Hello", "Java");
		myConsumer.accept("Hello", "Hello");
	}

	@Test
	void BIFunction_Integer_Integer() {
		BiFunction<String, String, Boolean> function = (s1, s2) -> {
			System.out.println("String 1:" + s1 + " String 2:" + s2);

			return s1.equals(s2);
		};

		System.out.println("Function:" + function.apply("Hello", "World"));
		System.out.println("Function:" + function.apply("Hello", "Hello"));
	}
}
