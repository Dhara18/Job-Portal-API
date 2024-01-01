package com.example.jobPortalApi.exception;

public class SocialProfileNotFoundException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public SocialProfileNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
