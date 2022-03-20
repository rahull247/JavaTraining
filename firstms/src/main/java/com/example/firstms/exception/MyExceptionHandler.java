package com.example.firstms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	 @ExceptionHandler(PersonNotFoundException.class)
	    private ResponseEntity<ErrorResponse> handlePersonNotFoundException() {
	        System.out.println("*******PersonNotFoundException********");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404,"Person Not Found"));
	    }
	 
	 @ExceptionHandler(MyCustomException.class)
	    private ResponseEntity<ErrorResponse> handlePersonNotFoundException(MyCustomException ex) {
	        System.out.println("*******MyCustomException********");
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(ex.getCode(),ex.getMessage()));
	    }
}
