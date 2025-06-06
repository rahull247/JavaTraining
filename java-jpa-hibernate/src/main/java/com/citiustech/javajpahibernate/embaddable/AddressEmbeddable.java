package com.citiustech.javajpahibernate.embaddable;

import javax.persistence.Embeddable;

@Embeddable
public class AddressEmbeddable {
	private String street;
	private String zipcode;
	private String city;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
