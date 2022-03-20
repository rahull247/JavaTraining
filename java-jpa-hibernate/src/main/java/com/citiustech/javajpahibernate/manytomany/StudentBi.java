package com.citiustech.javajpahibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "studentbi2")
public class StudentBi {

	@Id
    @GeneratedValue
    private int studentId;
    private String name;
    @ManyToMany(mappedBy = "studentList", cascade = CascadeType.ALL)
    private List<CourseBi> courseList = new ArrayList<>();
    public void addCourse(CourseBi course) {
        courseList.add(course);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseBi> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseBi> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "StudentBi{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", courseList=" +
                '}';
    }
}
