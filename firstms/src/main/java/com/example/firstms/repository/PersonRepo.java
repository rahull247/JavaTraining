package com.example.firstms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstms.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
