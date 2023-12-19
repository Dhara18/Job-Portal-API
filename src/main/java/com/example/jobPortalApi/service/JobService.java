package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.jobPortalApi.requestDTO.JobRequestDTO;
import com.example.jobPortalApi.responseDTO.JobResponceDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface JobService 
{
	public ResponseEntity<ResponseStructure<String>> addjob(int comapnyId,JobRequestDTO jobRequestDto);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobTitle(String jobTitle);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findJobByCompanyId(int companyId);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobLocation(String jobLocation);
	
	public ResponseEntity<ResponseStructure<String>> updateJobById(int jobId,int companyId,JobRequestDTO jobRequestDto);
	
	public ResponseEntity<ResponseStructure<JobResponceDTO>> deleteJobByCompanyId(int companyId,int jobId);
}
