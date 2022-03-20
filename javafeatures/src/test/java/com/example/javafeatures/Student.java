package com.example.javafeatures;

public class Student {
	
	private String name;
	private int age;
	private int markMath;
	private int markScience;

	public Student(String name, int age, int markMath, int markScience) {
		this.name = name;
		this.age = age;
		this.markMath = markMath;
		this.markScience = markScience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarkMath() {
		return markMath;
	}

	public void setMarkMath(int markMath) {
		this.markMath = markMath;
	}

	public int getMarkScience() {
		return markScience;
	}

	public void setMarkScience(int markScience) {
		this.markScience = markScience;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", markMath=" + markMath + ", markScience=" + markScience
				+ "]";
	}
	
	
	
	

}
