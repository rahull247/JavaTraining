package com.citiustech.javajpahibernate.embaddable;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class PersonEmbeddableService {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void savePersonWithEmbeddableAddress(PersonWithEmbeddable person) {
		System.out.println("savePersonWithEmbeddableAddress");
		em.persist(person);
	}
	
	@Transactional
	public void savePersonWithEmbeddableAddressOverride(PersonWithEmbeddableOverride personOverrides) {
		System.out.println("savePersonWithEmbeddableAddressOverride");
		em.persist(personOverrides);
	}
}
