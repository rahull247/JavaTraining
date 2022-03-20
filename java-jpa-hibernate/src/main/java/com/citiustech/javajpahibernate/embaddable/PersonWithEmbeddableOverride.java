package com.citiustech.javajpahibernate.embaddable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personwithembeddableaddress2")
public class PersonWithEmbeddableOverride {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private AddressEmbeddable address;

	@Embedded
	@AttributeOverrides({
	        @AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
	        @AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE")),
	        @AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY"))
	})
	private AddressEmbeddable billingAddress;
	
	public AddressEmbeddable getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressEmbeddable billingAddress) {
		this.billingAddress = billingAddress;
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

	public AddressEmbeddable getAddress() {
		return address;
	}

	public void setAddress(AddressEmbeddable address) {
		this.address = address;
	}
}
