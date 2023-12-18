package com.example.jobPortalApi.exception;

public class JobNotFoundException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public JobNotFoundException(String message) {
		super();
		this.message = message;
	}
	
}
