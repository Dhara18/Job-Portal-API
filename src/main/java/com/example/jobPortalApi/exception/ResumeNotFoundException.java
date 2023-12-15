package com.example.jobPortalApi.exception;

public class ResumeNotFoundException extends RuntimeException		//no setter methods because of constructor
{
	private String message;

	public String getMessage() {
		return message;
	}

	public ResumeNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
