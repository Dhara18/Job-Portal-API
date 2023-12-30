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
	
	@org.springframework.web.bind.annotation.ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> userDataNotFoundException(CompanyNotFoundException companyNotFoundException)
	{
		ErrorStructure<String> errorStructure =new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage("user data not found");
		errorStructure.setErrorData(companyNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(JobNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>>jobNotFoundException(JobNotFoundException jobNotFoundException)
	{
		ErrorStructure<String> errorStructure =new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage("Invalid user role");
		errorStructure.setErrorData(jobNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidUserException.class)
	public ResponseEntity<ErrorStructure<String>>userInvalidException(InvalidUserException invalidUserException)
	{
		ErrorStructure<String> errorStructure =new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage("Invalid user role");
		errorStructure.setErrorData(invalidUserException.getMessage());
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(InvalidBusinessTypeException.class)
	public ResponseEntity<ErrorStructure<String>>businessTypeInvalidException(InvalidBusinessTypeException invalidBusinessTypeException)
	{
		ErrorStructure<String> errorStructure =new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage("Invalid user role");
		errorStructure.setErrorData(invalidBusinessTypeException.getMessage());
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(SkillNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>>skillNotFound(SkillNotFoundException skillNotFoundException)
	{
		ErrorStructure<String> errorStructure =new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage("skill data not found");
		errorStructure.setErrorData(skillNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(ProjectNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>>skillNotFound(ProjectNotFoundException projectNotFoundException)
	{
		ErrorStructure<String> errorStructure =new ErrorStructure<>();
		errorStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorStructure.setMessage("skill data not found");
		errorStructure.setErrorData(projectNotFoundException.getMessage());
		
		return new ResponseEntity<ErrorStructure<String>>(errorStructure, HttpStatus.NOT_FOUND);
	}
}
