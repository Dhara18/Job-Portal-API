package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.JobRequestDTO;
import com.example.jobPortalApi.responseDTO.JobResponceDTO;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.JobStatus;

public interface JobService 
{
	public ResponseEntity<ResponseStructure<String>> addjob(int comapnyId,JobRequestDTO jobRequestDto,JobStatus jobStatus);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobTitle(String jobTitle);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findJobByCompanyId(int companyId);
	
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobLocation(String jobLocation);
	
	public ResponseEntity<ResponseStructure<String>> updateJobById(int jobId,int companyId,JobRequestDTO jobRequestDto,JobStatus jobStatus);
	
	public ResponseEntity<ResponseStructure<JobResponceDTO>> deleteJobByCompanyId(int companyId,int jobId);

	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findBySkill(String skill);

	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findBySkillList(List<String> skillList);
}
