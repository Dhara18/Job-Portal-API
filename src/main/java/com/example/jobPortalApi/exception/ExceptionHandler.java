package com.example.jobPortalApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.jobPortalApi.utility.ErrorStructure;

@RestControllerAdvice
public class ExceptionHandler 
{
	
	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> userDataNotFoundException(UserNotFoundException userNotFoundException)
	{
		ErrorStructure<String> errorStructure =new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage("user data not found");
		errorStructure.setErrorData(userNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
}
