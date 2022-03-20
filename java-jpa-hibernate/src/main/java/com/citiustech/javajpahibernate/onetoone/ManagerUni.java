package com.citiustech.javajpahibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="manager_uni2")
public class ManagerUni {
	
	@Id
	@GeneratedValue
	private int managerId;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="ManagerDepartment_Uni2",
			joinColumns= {
					@JoinColumn(name="mang_id", referencedColumnName = "managerId", nullable = false)
			},
			inverseJoinColumns= {
					@JoinColumn(name="depa_id", referencedColumnName = "departmentId", nullable = false)
			}
			)
	private DepartmentUni departmentUni;

	public int getId() {
		return managerId;
	}

	public void setId(int id) {
		this.managerId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentUni getDepartmentUni() {
		return departmentUni;
	}

	public void setDepartmentUni(DepartmentUni departmentUni) {
		this.departmentUni = departmentUni;
	}
	
	

}
