package com.example.javafeatures.junit;

public class MyMethods {

	String dbConnection = null;
	String otherDBConnection = null;

	public int multiplication(int value) {
		return value * 2;
	}

	public String getDBConnection() {
		if (this.dbConnection == null) {
			throw new RuntimeException("getDBConnection is null");
		}

		return "getDBConnection string return";
	}

	public String getDBConnection(String dbConnection) {
		if (this.dbConnection == null) {
			throw new RuntimeException("getDBConnection with paramter is null");
		}

		return "getDBConnection with paramter string return";
	}

	public String getOtherDBConnection() {
		if (this.otherDBConnection == null) {
			throw new RuntimeException("getOtherDBConnection is null");
		}

		return "getOtherDBConnection string return";
	}

}
