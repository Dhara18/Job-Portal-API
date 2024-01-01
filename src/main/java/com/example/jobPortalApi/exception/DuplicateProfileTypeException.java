package com.example.jobPortalApi.exception;

public class DuplicateProfileTypeException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public DuplicateProfileTypeException(String message) {
		super();
		this.message = message;
	}
	
}
