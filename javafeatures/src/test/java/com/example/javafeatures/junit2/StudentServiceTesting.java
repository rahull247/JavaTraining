package com.example.javafeatures.junit2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class StudentServiceTesting {
	
	@Test
	void saveStudent_MockException() {
		StudentDao mock=Mockito.mock(StudentDao.class);
		StudentService studentServices=new StudentService(mock);
		Student student=new Student();
		Mockito.when(mock.saveStudent(ArgumentMatchers.anyObject())).thenReturn(student);
		Exception exception=assertThrows(RuntimeException.class, ()->studentServices.saveStudent(student));
		assertEquals("Not able to save student", exception.getMessage());
		
	}
	
	@Test
	void getStudent_saveStudent_Mock() {
		StudentDao mock=Mockito.mock(StudentDao.class);
		StudentService studentServices=new StudentService(mock);
		Student student=new Student();
		student.setId(1L);
		student.setFirstName("Rahul");
		student.setLastName("Lokhande");
		Mockito.when(mock.getStudentById(ArgumentMatchers.anyLong())).thenReturn(student);
		studentServices.getStudent(student.getId());
    	Mockito.when(mock.saveStudent(ArgumentMatchers.any())).thenReturn(student);
		studentServices.saveStudent(student);
		
		
	}
	
	@Test
	void getStudent_saveStudent_Spy() {
		StudentDao spy=Mockito.spy(StudentDao.class);
		StudentService studentServices=new StudentService(spy);
		Student student=new Student();
		student.setId(1L);
		student.setFirstName("Rahul");
		student.setLastName("Lokhande");
		Mockito.when(spy.getStudentById(ArgumentMatchers.anyLong())).thenReturn(student);
		studentServices.getStudent(student.getId());
		Mockito.when(spy.saveStudent(ArgumentMatchers.any())).thenReturn(student);
		studentServices.saveStudent(student);
		
	}
	
	
	@Test
	void student_AssertionAllGroups() {
		StudentDao mock=Mockito.mock(StudentDao.class);
		StudentService studentServices=new StudentService(mock);
		Student student=new Student();
		student.setId(1L);
		student.setFirstName("Rahul");
		student.setLastName("Lokhande");
        student.setAge(25L);
        student.setDob(LocalDate.now());
        Mockito.when(mock.saveStudent(ArgumentMatchers.any())).thenReturn(student);
        studentServices.saveStudent(student);
        assertAll("student",
                () ->   assertEquals("Rahul", student.getFirstName()),
                () ->   assertEquals("Lokhande", student.getLastName()),
                () ->   assertEquals(25L, student.getAge()),
                () ->   assertEquals(1L, student.getId()),
                () ->   assertEquals(LocalDate.now(), student.getDob())
        );
}
	
}
