package com.example.jobPortalApi.exception;

public class EducationNotFoundException extends RuntimeException 
{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public EducationNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
