package com.citiustech.javajpahibernate.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.citiustech.javajpahibernate.onetomany.LearnerUni;

@Service
public class OneToOneService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void saveOneToOne(ManagerUni manager) {
		entityManager.persist(manager);
	}

}
