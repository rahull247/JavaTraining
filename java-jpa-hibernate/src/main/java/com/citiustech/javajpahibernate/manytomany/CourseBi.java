package com.citiustech.javajpahibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "coursebi2")
public class CourseBi {

	 @Id
	    @GeneratedValue
	    private int courseId;
	    private String courseName;
	    @ManyToMany
	    @JoinTable(name = "student_course_bi2",
	    joinColumns = @JoinColumn(name = "course_id"),
	            inverseJoinColumns = @JoinColumn(name = "student_id")
	    )
	    private List<StudentBi> studentList = new ArrayList<>();
	    public void addStudent(StudentBi student) {
	        studentList.add(student);
	    }

	    public int getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(int courseId) {
	        this.courseId = courseId;
	    }

	    public String getCourseName() {
	        return courseName;
	    }

	    public void setCourseName(String courseName) {
	        this.courseName = courseName;
	    }

	    public List<StudentBi> getStudentList() {
	        return studentList;
	    }

	    public void setStudentList(List<StudentBi> studentList) {
	        this.studentList = studentList;
	    }

	    @Override
	    public String toString() {
	        return "CourseBi{" +
	                "courseId=" + courseId +
	                ", courseName='" + courseName + '\'' +
	                ", studentList=" +
	                '}';
	    }
	    
}
