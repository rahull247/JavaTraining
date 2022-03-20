package com.citiustech.javajpahibernate.onetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department_uni2")
public class DepartmentUni {
	
	@Id
	@GeneratedValue
	private int departmentId;
    
	private String name;

	public int getId() {
		return departmentId;
	}

	public void setId(int id) {
		this.departmentId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
