package com.citiustech.javajpahibernate.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class OneToManyService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(LearnerUni learner) {
		entityManager.persist(learner);
	}
	
}
