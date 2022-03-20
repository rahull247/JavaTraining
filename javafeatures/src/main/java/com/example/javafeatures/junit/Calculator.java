package com.example.javafeatures.junit;

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

	public String getConnection() {
		String str = myMethod.getDBConnection();
		if (str == null) {
			return "NO Data Found";
		}

		if (str.length() > 2) {
			return "Data length is greater than 2";
		}

		return str;
	}

	public void print() {
		String otherString = myMethod.getOtherDBConnection();
		
		if (otherString.length() > 2) {
			String fromGetDB = myMethod.getDBConnection();
			System.out.println("From getDBConnection(): " + fromGetDB);
		} else {
			int multiply = myMethod.multiplication(2);
			System.out.println("Multiplication 1: " + multiply);
		}
		
		int multiply2 = myMethod.multiplication(2);
		System.out.println("Multiplication 2:" + multiply2);
		System.out.println("Print method completes");
	}
}
