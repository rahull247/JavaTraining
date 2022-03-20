package com.example.javafeatures.junit2;

import java.time.LocalDate;

public class StudentService {
   
	private final StudentDao studentDao;
    static int counterValue=0;
    
	public StudentService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public Student getStudent(Long id) {
		Student byIdStudent=studentDao.getStudentById(id);
		System.out.println("StudentService:getStudent: "+byIdStudent);
		return byIdStudent;
	}
	
	public Student saveStudent(Student student) {
		Student newStudent=studentDao.saveStudent(student);
		if(newStudent == null || newStudent.getId() == null) {
			throw new RuntimeException("Not able to save student");
		}
		System.out.println("StudentService:saveStudent: "+newStudent);
		return newStudent;
	}
	
	
	public void addNewStudent(String name) {
		Student student=new Student();
		if(name.equalsIgnoreCase("RAHUL")) {
			student.setId(1L);
			student.setFirstName("RAHUL");
			student.setLastName("LOKHANDE");
			student.setDob(LocalDate.now());
			student.setAge(25L);
		}else {
			student.setId(11L);
			student.setFirstName("Default");
			student.setLastName("Default");
			student.setDob(LocalDate.of(2022,1, 31));
			student.setAge(30L);
		}
		studentDao.saveStudent(student);
	}
	
	public void getCounterValue() {
		counterValue=counterValue+2;
		if(counterValue > 4) {
			System.out.println("Counter value greater than 4:"+counterValue);
		}else {
			System.out.println("Counter value less than 4:"+counterValue);	
		}
		
	}
}
