package com.example.jobPortalApi.exception;

public class JobApplicationNotFoundException extends RuntimeException		//no setter methods because of constructor
{
	private String message;

	public String getMessage() {
		return message;
	}

	public JobApplicationNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
