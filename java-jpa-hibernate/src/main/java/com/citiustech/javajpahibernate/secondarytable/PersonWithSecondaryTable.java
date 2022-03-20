package com.citiustech.javajpahibernate.secondarytable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "personwithsecondarytable")
@SecondaryTables({
		@SecondaryTable(name = "address_secondary", pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "id")),
		@SecondaryTable(name = "phone_secondary", pkJoinColumns = @PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "id")) 
		})
public class PersonWithSecondaryTable {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@Column(name = "city", table = "address_secondary", columnDefinition = "varchar(50) not null")
	private String city;
	
	@Column(name = "zip_code", table = "address_secondary", columnDefinition = "varchar(50) not null")
	private String zipCode;
	
	@Column(name = "country_code", table = "phone_secondary", columnDefinition = "varchar(50) not null")
	private String countryCode;
	
	@Column(name = "phone_number", table = "phone_secondary", columnDefinition = "varchar(50) not null")
	private String phoneNumber;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
