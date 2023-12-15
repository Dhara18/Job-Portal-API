package com.example.jobPortalApi.exception;

public class UserNotFoundException extends RuntimeException			//no setter methods because of constructor
{
	private String message;

	public String getMessage() {
		return message;
	}

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
