package com.citiustech.javajpahibernate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.javajpahibernate.secondarytable.PersonEmbeddableSecondaryTableService;
import com.citiustech.javajpahibernate.secondarytable.PersonWithSecondaryTable;

@SpringBootTest
public class PersonEmbaddedWithSecondaryTableTest {

	@Autowired
	private PersonEmbeddableSecondaryTableService personSecondaryTableService;
	
	@Test
	void savePersonWithSecondaryTable() {
		PersonWithSecondaryTable personWithSecondTable=new PersonWithSecondaryTable();
		personWithSecondTable.setName("Rajesh");
		personWithSecondTable.setCity("Las Vegas");
		personWithSecondTable.setZipCode("12345");
		personWithSecondTable.setCountryCode("99");
		personWithSecondTable.setPhoneNumber("43242432");
		
		personSecondaryTableService.savePersonWithEmbeddableSecondaryTable(personWithSecondTable);
	}
}
