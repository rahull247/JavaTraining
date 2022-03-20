package com.citiustech.javajpahibernate.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class ManyToManyService {

	@PersistenceContext
    private EntityManager em;
    @Transactional
    public void manyToMany(StudentBi student) {
        System.out.println("manyToMany");
        em.persist(student);
    }

    @Transactional
    public void fetchStudent(int studentId, int courseId) {
        StudentBi studentBi = em.find(StudentBi.class, studentId);
        System.out.println(studentBi.getCourseList());
        CourseBi courseBi = em.find(CourseBi.class, courseId);
        System.out.println(courseBi.getStudentList());
    }
    
}
