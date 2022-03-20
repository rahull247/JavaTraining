package com.example.javafeatures.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class CalculatorJunit {

    MyMethods mymethod=new MyMethods();
	
	@Test
	void add_expected() {
		Calculator calc=new Calculator(mymethod);
		int actual=calc.addition(5, 4);
		int expected=18;
		assertEquals(expected, actual);
	}
	
	@Test
	void add_fail() {
		Calculator calc=new Calculator(mymethod);
		int actual=calc.addition(5, 4);
		int expected=10;
		assertNotEquals(expected, actual);
	}
	

	@Test
	void add_firstZero()  {
		Calculator calc=new Calculator(mymethod);
		Exception exception = assertThrows(RuntimeException.class, () -> calc.addition(0, 4));
	    assertEquals("Zero for addition is not allowed", exception.getMessage());
	}
	
	@Test
	void add_secondZero() {
		Calculator calc=new Calculator(mymethod);
		Exception exception = assertThrows(RuntimeException.class, () -> calc.addition(0, 4));
		assertEquals("Zero for addition is not allowed", exception.getMessage());
	}
	
	@Test
	void add_bothParameterZero() {
		Calculator calc=new Calculator(mymethod);
		Exception exception = assertThrows(RuntimeException.class, () -> calc.addition(0, 4));
		assertEquals("Zero for addition is not allowed", exception.getMessage());
	}
	
	
	  @Test 
	  void getDBTest_BeforeMock() { 
	  Calculator calculator = new Calculator(mymethod); 
	  Exception exception = assertThrows(Exception.class, () -> calculator.getConnection());
	  assertEquals("getDBConnection is null", exception.getMessage()); 
	  }
	 
	
	@Test
	void getDBTest_AfterMock() {
		MyMethods mock = Mockito.mock(MyMethods.class);
		Calculator calculator = new Calculator(mock);
		String actual=calculator.getConnection();
		assertEquals("NO Data Found", actual);
	}
	
	@Test
	void getDBTest_AfterMock_when() {
		MyMethods mock = Mockito.mock(MyMethods.class);
		Mockito.when(mock.getDBConnection()).thenReturn("Hy");
		Calculator calculator = new Calculator(mock);
		String actual=calculator.getConnection();
		assertEquals("Hy", actual);
	}
	
	
	@Test
	void getDBTest_AfterMock_whenGreaterThan2() {
		MyMethods mock = Mockito.mock(MyMethods.class);
		Mockito.when(mock.getDBConnection()).thenReturn("Hey");
		Calculator calculator = new Calculator(mock);
		String actual=calculator.getConnection();
		assertEquals("Data length is greater than 2", actual);
	}
	
	@Test
	void getDBTest_AfterMock_AnyString() {
		MyMethods mock = Mockito.mock(MyMethods.class);
		Mockito.when(mock.getDBConnection(Mockito.anyString())).thenReturn("Hey");
		Calculator calculator = new Calculator(mock);
		String actual=calculator.getConnection();
		assertEquals("NO Data Found", actual);
	}
	
	@Disabled
	@Test
	void print_moreThan2Word_success() {
		MyMethods mock = Mockito.mock(MyMethods.class);
	    Calculator calculator = new Calculator(mock);
	    Mockito.when(mock.getOtherDBConnection()).thenReturn("Hi World!");
	    calculator.print();
	    Mockito.verify(mock, Mockito.times(1)).getOtherDBConnection();
	    Mockito.verify(mock, Mockito.times(1)).multiplication(ArgumentMatchers.anyInt());
	}

	@Disabled("This is temporary disabled to test @Disabled anootation")
	@Test
	void print_2Word_success() {
		MyMethods mock = Mockito.mock(MyMethods.class);
	    Calculator calculator = new Calculator(mock);
	    Mockito.when(mock.getOtherDBConnection()).thenReturn("Hi");
	    calculator.print();
	    Mockito.verify(mock, Mockito.times(1)).getOtherDBConnection();
	    Mockito.verify(mock, Mockito.times(2)).multiplication(ArgumentMatchers.anyInt());
	}
}
