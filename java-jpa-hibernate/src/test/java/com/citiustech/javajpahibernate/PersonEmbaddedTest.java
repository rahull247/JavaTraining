package com.citiustech.javajpahibernate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.javajpahibernate.embaddable.AddressEmbeddable;
import com.citiustech.javajpahibernate.embaddable.PersonEmbeddableService;
import com.citiustech.javajpahibernate.embaddable.PersonWithEmbeddable;
import com.citiustech.javajpahibernate.embaddable.PersonWithEmbeddableOverride;

@SpringBootTest
public class PersonEmbaddedTest {

	@Autowired
	private PersonEmbeddableService service;
	
	@Test
	void testMethod() {
		AddressEmbeddable addressEmbeddable = new AddressEmbeddable();
		addressEmbeddable.setCity("New York");
		addressEmbeddable.setStreet("123 street");
		addressEmbeddable.setZipcode("12345678");
		PersonWithEmbeddable person = new PersonWithEmbeddable();
		person.setAddress(addressEmbeddable);
		person.setName("Kevin");
		service.savePersonWithEmbeddableAddress(person);
	}
	
	@Test
	void testMethodOverride() {
		AddressEmbeddable addressEmbeddable = new AddressEmbeddable();
		addressEmbeddable.setCity("New York");
		addressEmbeddable.setStreet("123 street");
		addressEmbeddable.setZipcode("12345678");
		
		AddressEmbeddable addressEmbeddableOverride = new AddressEmbeddable();
		addressEmbeddableOverride.setCity("Machettes");
		addressEmbeddableOverride.setStreet("456 street");
		addressEmbeddableOverride.setZipcode("1231232");
		
		PersonWithEmbeddableOverride personOverrides = new PersonWithEmbeddableOverride();
		personOverrides.setBillingAddress(addressEmbeddableOverride);
		personOverrides.setAddress(addressEmbeddable);
		personOverrides.setName("Kevin");
		service.savePersonWithEmbeddableAddressOverride(personOverrides);
	}
}
