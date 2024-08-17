package com.qspider.springbootproject.exception;

public class AadharNotFoundException extends RuntimeException {
	
	private String message;

	public AadharNotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
