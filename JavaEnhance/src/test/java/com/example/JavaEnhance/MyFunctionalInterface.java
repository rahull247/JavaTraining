package com.example.JavaEnhance;

@FunctionalInterface
public interface MyFunctionalInterface {
  public String myStringMethod(String s1, String s2);
  
  default void returnString() {
	  System.out.println("Default method interface");
  }
  
  static String staticStrings(String s1) {
	  return s1+"Hello static string";
  }
}
