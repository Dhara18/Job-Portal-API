package com.example.jobPortalApi.exception;

public class InvalidBusinessTypeException extends RuntimeException
{
	private String message;

	public String getMessage() {
		return message;
	}

	public InvalidBusinessTypeException(String message) {
		super();
		this.message = message;
	}

}
