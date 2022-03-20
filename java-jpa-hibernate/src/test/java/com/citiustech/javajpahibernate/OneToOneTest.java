package com.citiustech.javajpahibernate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.javajpahibernate.onetoone.DepartmentUni;
import com.citiustech.javajpahibernate.onetoone.ManagerUni;
import com.citiustech.javajpahibernate.onetoone.OneToOneService;

@SpringBootTest
public class OneToOneTest {

	@Autowired
	private OneToOneService service;
	
	@Test
	void oneToOneManager() {
		ManagerUni shrek=new ManagerUni();
		shrek.setName("Shrek");
		
		DepartmentUni finance=new DepartmentUni();
		finance.setName("Finance");
		
		shrek.setDepartmentUni(finance);
		
		service.saveOneToOne(shrek);
	}
}
