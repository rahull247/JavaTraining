package com.citiustech.javajpahibernate.onetomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "learner_uni2")
public class LearnerUni {

	    @Id
	    @GeneratedValue
	    private int id;
	    private String name;
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "learner_id")
	    private List<ScoreUni> scoreList = new ArrayList<>();
	    
	    public void addScore(ScoreUni score) {
	        this.scoreList.add(score);
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<ScoreUni> getScoreList() {
	        return scoreList;
	    }

	    public void setScoreList(List<ScoreUni> scoreList) {
	        this.scoreList = scoreList;
	    }
	    
}
