package com.example.springbootandpostgres.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootandpostgres.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
