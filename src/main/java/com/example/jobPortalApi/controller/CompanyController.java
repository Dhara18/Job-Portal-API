package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.CompanyRequestDTO;
import com.example.jobPortalApi.service.CompanyService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class CompanyController 
{
	@Autowired
	private CompanyService companyService;
	
	
}
