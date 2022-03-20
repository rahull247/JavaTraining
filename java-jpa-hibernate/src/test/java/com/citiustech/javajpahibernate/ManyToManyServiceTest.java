package com.citiustech.javajpahibernate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.javajpahibernate.manytomany.CourseBi;
import com.citiustech.javajpahibernate.manytomany.ManyToManyService;
import com.citiustech.javajpahibernate.manytomany.StudentBi;

@SpringBootTest
class ManyToManyServiceTest {

	@Autowired
	private ManyToManyService service;
	
	@Test
	void testManyToMany() {
		StudentBi jason=new StudentBi();
		jason.setName("Jason");
		   
		 CourseBi al=new CourseBi();
		 al.setCourseName("ArtificialLanguage");
		 al.addStudent(jason);
		 
		 CourseBi ml=new CourseBi();
		 ml.setCourseName("MachineLanguage");
		 ml.addStudent(jason);
		 
		 jason.addCourse(al);
		 jason.addCourse(ml);
		 
		 service.manyToMany(jason);
	}

	@Test
	void testFetchStudent() {
		service.fetchStudent(10, 11);
	}

}
