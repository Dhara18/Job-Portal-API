package com.example.jobPortalApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.JobRequestDTO;
import com.example.jobPortalApi.responseDTO.JobResponceDTO;
import com.example.jobPortalApi.service.JobService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class JobController 
{
	@Autowired
	JobService jobService;
	
	@RequestMapping(value = "/Companies/{comapnyId}/jobs", method = RequestMethod.POST)		//not checking for user because if the company is existing means only employee has added it...no need to check for user
	public ResponseEntity<ResponseStructure<String>> addjob(@PathVariable int comapnyId,@RequestBody JobRequestDTO jobRequestDto)
	{
		return jobService.addjob(comapnyId,jobRequestDto);
	}
	
	@RequestMapping(value = "/jobs/{jobTitle}", method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobTitle(@PathVariable String jobTitle)
	{
		return jobService.findByJobTitle(jobTitle);
	}
	
	@RequestMapping(value = "/companies/{companyId}/jobs", method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findJobByCompanyId(@PathVariable int companyId)
	{
		return jobService.findJobByCompanyId(companyId);
	}
	
	@RequestMapping(value = "/jobsByLocation/{jobLocation}", method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobLocation(@PathVariable String jobLocation)
	{
		return jobService.findByJobLocation(jobLocation);
	}
	
	@RequestMapping(value = "/skills/{skill}/jobs", method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findBySkill(@PathVariable String skill)
	{
		return jobService.findBySkill(skill);
	}
	
	@RequestMapping(value = "/skills/jobs", method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findBySkillList(@RequestBody List<String> skillList)
	{
		return jobService.findBySkillList(skillList);
	}
	
	@RequestMapping(value = "/Companies/{companyId}/jobs/{jobId}", method = RequestMethod.PUT)		
	public ResponseEntity<ResponseStructure<String>> updateJobById(@PathVariable int jobId,@PathVariable int companyId,@RequestBody JobRequestDTO jobRequestDto)
	{
		return jobService.updateJobById(jobId,companyId,jobRequestDto);
	}
	
	@RequestMapping(value = "/companies/{companyId}/jobs/{jobId}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseStructure<JobResponceDTO>> deleteJobByCompanyId(@PathVariable int companyId,@PathVariable int jobId)
	{
		return jobService.deleteJobByCompanyId(companyId,jobId);
	}
}
