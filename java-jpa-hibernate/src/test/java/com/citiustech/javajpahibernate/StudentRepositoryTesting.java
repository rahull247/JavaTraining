package com.citiustech.javajpahibernate;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.javajpahibernate.model.Student;
import com.citiustech.javajpahibernate.repository.StudentRepository;


@SpringBootTest
public class StudentRepositoryTesting {

	@Autowired
	private StudentRepository studentRepo;
	
	@BeforeAll
	 void insertingData() {
		Student student=new Student();
		student.setId(1L);
		student.setName("John");
		student.setMarks(80);
		Student student2=new Student();
		student2.setId(2L);
		student2.setName("Ganesh");
		student2.setMarks(91);
		studentRepo.save(student);
		studentRepo.save(student2);
	}
	
	@Test
	void Student_minMarks() {
		
		List<Student>studentList=studentRepo.findAll();
		Stream<Student>stream=studentList.stream();
		OptionalInt optional=  stream.mapToInt(Student::getMarks).min();
		System.out.println(optional);
		
	}
	
	@Test
	void Student_maxMarks() {
		
		List<Student>studentList=studentRepo.findAll();
		Stream<Student>stream=studentList.stream();
		OptionalInt optional=  stream.mapToInt(Student::getMarks).max();
		System.out.println(optional);
		
	}
	
	
	@Test
	void Student_AverageMarks() {
		
		List<Student>studentList=studentRepo.findAll();
		Stream<Student>stream=studentList.stream();
		OptionalDouble optional=  stream.mapToDouble(Student::getMarks).average();
		System.out.println(optional);
		
	}
	
	
	@Test
	void Student_HighestStudentMarks() {
		
		List<Student>studentList=studentRepo.findAll();
		Stream<Student>stream=studentList.stream();
		
		System.out.println(stream.max(Comparator.comparing(Student::getMarks)).get().getName());
		
	}
}
