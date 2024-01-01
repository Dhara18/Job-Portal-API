package com.example.jobPortalApi.exception;

public class InvalidProfileTypeException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public InvalidProfileTypeException(String message) {
		super();
		this.message = message;
	}
	
	
}
