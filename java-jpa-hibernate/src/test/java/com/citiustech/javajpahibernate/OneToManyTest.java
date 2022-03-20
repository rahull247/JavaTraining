package com.citiustech.javajpahibernate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.javajpahibernate.onetomany.LearnerUni;
import com.citiustech.javajpahibernate.onetomany.OneToManyService;
import com.citiustech.javajpahibernate.onetomany.ScoreUni;

@SpringBootTest
public class OneToManyTest {

	@Autowired
	private OneToManyService service;
	
	@Test
	void oneToManyLearner() {
		LearnerUni john=new LearnerUni();
		john.setName("John");
		
		ScoreUni math=new ScoreUni();
		math.setSubject("Math");
		
		ScoreUni Science=new ScoreUni();
		Science.setSubject("Science");
		
		john.addScore(math);
		john.addScore(Science);
		
		service.save(john);
		
	}
}
