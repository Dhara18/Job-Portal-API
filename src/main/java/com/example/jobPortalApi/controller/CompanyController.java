package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.CompanyRequestDTO;
import com.example.jobPortalApi.responseDTO.CompanyResponseDTO;
import com.example.jobPortalApi.service.CompanyService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.BusinessType;

@RestController
public class CompanyController 
{
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping (value = "/users/{userId}/Businesstype/{businessType}/companies" , method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addComapy(@PathVariable int userId,@PathVariable BusinessType businessType,@RequestBody CompanyRequestDTO companyRequestDTO)
	{
		return companyService.addCompany(companyRequestDTO,userId,businessType);
	}
	@RequestMapping (value = "/companies/{id}" , method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<CompanyResponseDTO>>findById(@PathVariable int id)
	{
		return companyService.findById(id);
	}
}
