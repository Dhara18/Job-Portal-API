package com.example.jobPortalApi.exception;

public class InvalidJobStatusException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public InvalidJobStatusException(String message) {
		super();
		this.message = message;
	}
	
}
