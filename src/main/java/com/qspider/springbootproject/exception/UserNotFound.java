package com.qspider.springbootproject.exception;

public class UserNotFound extends RuntimeException{
	private String message;

	public UserNotFound(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	
}
