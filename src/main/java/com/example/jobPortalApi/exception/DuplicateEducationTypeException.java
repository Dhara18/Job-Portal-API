package com.example.jobPortalApi.exception;

public class DuplicateEducationTypeException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public DuplicateEducationTypeException(String message) {
		super();
		this.message = message;
	}
	
	
}
