package com.example.javafeatures.junit2;

public class Marks {
	
	private int scienceMarks;
	private int mathsMarks;
	public int getScienceMarks() {
		return scienceMarks;
	}
	public void setScienceMarks(int scienceMarks) {
		this.scienceMarks = scienceMarks;
	}
	public int getMathsMarks() {
		return mathsMarks;
	}
	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}
	
	@Override
	public String toString() {
		return "Marks [scienceMarks=" + scienceMarks + ", mathsMarks=" + mathsMarks + "]";
	}
	
	

}
