package com.example.jobPortalApi.exception;

public class ExpeienceNotFoundException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public ExpeienceNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
