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
import com.exmple.jobPortalApi.enums.BusinessType;

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
}
