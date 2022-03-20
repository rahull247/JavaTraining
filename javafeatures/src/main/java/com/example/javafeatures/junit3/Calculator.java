package com.example.javafeatures.junit3;

public class Calculator {

	MyMethods myMethod = null;

	public Calculator(MyMethods myMethod) {
		this.myMethod = myMethod;
	}

	public int addition(int first, int second) {
		if (first == 0 || second == 0) {
			throw new RuntimeException("Zero for addition is not allowed");
		}

		int third = myMethod.multiplication(first);
		int fourth = myMethod.multiplication(second);
		// return first+second;
		return third + fourth;
	}

	
}
