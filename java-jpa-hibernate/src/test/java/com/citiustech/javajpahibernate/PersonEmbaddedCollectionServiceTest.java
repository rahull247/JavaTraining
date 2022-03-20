package com.citiustech.javajpahibernate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.javajpahibernate.listandattributes.PersonEmbaddedCollectionService;
import com.citiustech.javajpahibernate.listandattributes.PersonWithEmbbadedCollection;
import com.citiustech.javajpahibernate.listandattributes.TicketEmbaddedList;

@SpringBootTest
class PersonEmbaddedCollectionServiceTest {

	@Autowired
	private PersonEmbaddedCollectionService service;
	@Test
	void testSavePersonEmbaddedColection() {
		PersonWithEmbbadedCollection janet=new PersonWithEmbbadedCollection();
		janet.setName("Janet");
		
		TicketEmbaddedList ticket1=new TicketEmbaddedList();
		ticket1.setNumber("12345");
		
		TicketEmbaddedList ticket2=new TicketEmbaddedList();
		ticket2.setNumber("67890");
		
	    janet.addTicket(ticket1);
	    janet.addTicket(ticket2);
	    
	    janet.addAttribute("Attribute1", "Yes");
	    janet.addAttribute("Attribute2", "No");
	    
	    service.savePersonEmbaddedColection(janet);
	}

}
