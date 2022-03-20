package com.example.javafeatures;

public class User {
	int id;
	String name;
	Long idNumber;
	
	
	public User(int id, String name, Long idNumber) {
		this.id = id;
		this.name = name;
		this.idNumber = idNumber;
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
	public Long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", idNumber=" + idNumber + "]";
	}
	
	

}
