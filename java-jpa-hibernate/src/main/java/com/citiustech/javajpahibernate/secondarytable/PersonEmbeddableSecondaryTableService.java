package com.citiustech.javajpahibernate.secondarytable;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class PersonEmbeddableSecondaryTableService {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void savePersonWithEmbeddableSecondaryTable(PersonWithSecondaryTable personSecond) {
		System.out.println("savePersonWithEmbeddableSecondaryTable");
		em.persist(personSecond);
	}
	
	
}
