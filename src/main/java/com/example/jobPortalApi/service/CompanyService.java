package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.CompanyRequestDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface CompanyService 
{
	public ResponseEntity<ResponseStructure<String>> addCompany(CompanyRequestDTO companyRequestDTO,int userId);
}
