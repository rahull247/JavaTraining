package com.example.javafeatures.junit2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentAnnotationTesting {

	@Mock
	private StudentDao studentDaoMock;

	@InjectMocks
	private StudentService studentServiceMock;

	@Captor
	private ArgumentCaptor<Student> studentArgumentCaptor;

	@Test
	void saveStudent_MockException() {
		Student student = new Student();
		Mockito.when(studentDaoMock.saveStudent(ArgumentMatchers.anyObject())).thenReturn(student);
		Exception exception = assertThrows(RuntimeException.class, () -> studentServiceMock.saveStudent(student));
		assertEquals("Not able to save student", exception.getMessage());

	}

	@Test
	void getStudent_saveStudent_Mock() {
		// MockitoAnnotations.openMocks(this);
		Student student = new Student();
		student.setId(1L);
		student.setFirstName("Rahul");
		student.setLastName("Lokhande");
		Mockito.when(studentDaoMock.getStudentById(ArgumentMatchers.anyLong())).thenReturn(student);
		studentServiceMock.getStudent(student.getId());
		Mockito.when(studentDaoMock.saveStudent(ArgumentMatchers.any())).thenReturn(student);
		studentServiceMock.saveStudent(student);
	}

	@Test
	void newStudent_If_Captor() {
		studentServiceMock.addNewStudent("Rahul");
		Mockito.verify(studentDaoMock).saveStudent(studentArgumentCaptor.capture());
		Student student = studentArgumentCaptor.getValue();
		assertEquals(1L, student.getId());
		assertEquals("RAHUL", student.getFirstName());
		assertEquals("LOKHANDE", student.getLastName());
		assertEquals(25L, student.getAge());
		assertEquals(LocalDate.now(), student.getDob());
	}

	@Test
	void newStudent_Else_Captor() {
		studentServiceMock.addNewStudent("Kunal");
		Mockito.verify(studentDaoMock).saveStudent(studentArgumentCaptor.capture());
		Student student = studentArgumentCaptor.getValue();
		assertEquals(11L, student.getId());
		assertEquals("Default", student.getFirstName());
		assertEquals("Default", student.getLastName());
		assertEquals(30L, student.getAge());
		assertEquals(LocalDate.of(2022, 1, 31), student.getDob());
	}

	@DisplayName("Checking static counter multiplication value")
	@RepeatedTest(value = 3, name = "{currentRepetition} / {totalRepetitions}")
	void testCounter(RepetitionInfo repetitionInfo) {
		System.out.println("repetitionInfo: " + repetitionInfo.getCurrentRepetition() + "/"
				+ repetitionInfo.getTotalRepetitions());
		studentServiceMock.getCounterValue();
	}
}
