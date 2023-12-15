package com.example.jobPortalApi.exception;

public class CompanyNotFoundException extends RuntimeException		//no setter methods because of constructor
{
	private String message;

	public String getMessage() {
		return message;
	}

	public CompanyNotFoundException(String message) {
		super();
		this.message = message;
	}

}
