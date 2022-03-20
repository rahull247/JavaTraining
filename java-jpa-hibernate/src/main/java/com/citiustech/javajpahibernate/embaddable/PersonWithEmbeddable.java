package com.citiustech.javajpahibernate.embaddable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personwithembeddableaddress2")
public class PersonWithEmbeddable {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private AddressEmbeddable address;

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

	public AddressEmbeddable getAddress() {
		return address;
	}

	public void setAddress(AddressEmbeddable address) {
		this.address = address;
	}
}
