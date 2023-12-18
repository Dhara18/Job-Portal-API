package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.JobRequestDTO;
import com.example.jobPortalApi.responseDTO.JobResponceDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface JobService 
{
	public ResponseEntity<ResponseStructure<String>> addjob(int comapnyId,JobRequestDTO jobRequestDto);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobTitle(String jobTitle);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findJobByCompanyId(int companyId);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobLocation(String jobLocation);
}
