package com.poc.RestWithJersey.exception;

public class EmployeeNotFoundChkedWebAppException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundChkedWebAppException() {}
	
	public EmployeeNotFoundChkedWebAppException(String message) {
		super(message);
	}

	public EmployeeNotFoundChkedWebAppException(String message, Throwable cause) {
		super(message, cause);
	}
}
