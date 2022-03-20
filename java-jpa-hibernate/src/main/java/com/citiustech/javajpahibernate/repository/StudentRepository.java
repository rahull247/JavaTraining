package com.citiustech.javajpahibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.javajpahibernate.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
