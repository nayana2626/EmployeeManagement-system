package com.employee.exceptioncase;


@SuppressWarnings("serial")
public class EmployeeNotFound extends RuntimeException{

	public EmployeeNotFound(String message) {
		super(message);
		
	}
}
