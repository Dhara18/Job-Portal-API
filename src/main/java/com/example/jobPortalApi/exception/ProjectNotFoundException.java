package com.example.jobPortalApi.exception;

public class ProjectNotFoundException extends RuntimeException 
{
	private String message;

	public String getMessage() {
		return message;
	}

	public ProjectNotFoundException(String message) {
		super();
		this.message = message;
	}

	
	
	
}
