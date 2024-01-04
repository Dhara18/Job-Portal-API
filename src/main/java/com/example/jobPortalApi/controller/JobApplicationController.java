package com.example.jobPortalApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.responseDTO.JobApplicationResponseDTO;
import com.example.jobPortalApi.service.JobApplicationService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class JobApplicationController 
{
	
	@Autowired
	JobApplicationService jobApplicationService;
	
	@RequestMapping(value = "/users/{userId}/jobs/{jobId}/jobapplications",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addJobApplication(@PathVariable int userId,@PathVariable int jobId)
	{
		return jobApplicationService.addResume(userId,jobId);
	}
	
	@RequestMapping(value = "/users/{userId}/jobapplications",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<JobApplicationResponseDTO>>> findJobApplicationByUser(@PathVariable int userId)
	{
		return jobApplicationService.findJobApplicationByUser(userId);
	}
	
	@RequestMapping(value = "/jobs/{jobId}/jobapplications",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<JobApplicationResponseDTO>>> findJobApplicationByJob(@PathVariable int jobId)
	{
		return jobApplicationService.findJobApplicationByUJob(jobId);
	}
}
