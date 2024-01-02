package com.example.jobPortalApi.exception;

public class InvalidEducationTypeException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public InvalidEducationTypeException(String message) {
		super();
		this.message = message;
	}
	
	
}
