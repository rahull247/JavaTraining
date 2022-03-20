package com.example.javafeatures.junit2;

import java.util.List;

public class StudentDao {

	
	public List<Student> getAllStudents(){
		System.out.println("getAllStudent() is called");
		return null;
	}
	
	public Student saveStudent(Student student) {
		System.out.println("saveStudent() is called");
		return null;
	}
	
	public Student getStudentById(long id) {
		System.out.println("getStudentById() is called");
		return null;
	}
	
	public Student getStudentByName(String name) {
		System.out.println("getStudentById is called");
		return null;
	}
	
}
