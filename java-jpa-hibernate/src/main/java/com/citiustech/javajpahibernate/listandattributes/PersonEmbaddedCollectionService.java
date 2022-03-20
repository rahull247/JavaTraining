package com.citiustech.javajpahibernate.listandattributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class PersonEmbaddedCollectionService {

	@PersistenceContext
    private EntityManager em;
    @Transactional
    public void savePersonEmbaddedColection(PersonWithEmbbadedCollection person) {
        System.out.println("savePersonEmbaddedColection");
        em.persist(person);
    }

   
    
}
