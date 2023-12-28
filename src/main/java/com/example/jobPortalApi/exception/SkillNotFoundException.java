package com.example.jobPortalApi.exception;

public class SkillNotFoundException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public SkillNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
}
