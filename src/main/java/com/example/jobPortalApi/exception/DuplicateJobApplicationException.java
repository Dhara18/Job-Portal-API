package com.example.jobPortalApi.exception;

public class DuplicateJobApplicationException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public DuplicateJobApplicationException(String message) {
		super();
		this.message = message;
	}
	
}
