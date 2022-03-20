package com.citiustech.javajpahibernate.listandattributes;

import javax.persistence.Embeddable;

@Embeddable
public class TicketEmbaddedList {

	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
