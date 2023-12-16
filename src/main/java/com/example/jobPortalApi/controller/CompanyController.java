package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.CompanyRequestDTO;
import com.example.jobPortalApi.service.CompanyService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class CompanyController 
{
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping (value = "/companies/users/{userId}" , method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addComapy(@RequestBody CompanyRequestDTO companyRequestDTO,@PathVariable int userId)
	{
		return companyService.addCompany(companyRequestDTO,userId);
	}
}
