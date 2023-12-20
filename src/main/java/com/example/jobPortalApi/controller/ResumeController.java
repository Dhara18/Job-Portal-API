package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.ResumeRequestDTO;
import com.example.jobPortalApi.service.ResumeService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class ResumeController 
{
	@Autowired
	ResumeService resumeService;
	
	@RequestMapping(value = "/users/{userId}/resume")
	public ResponseEntity<ResponseStructure<String>> addResume(@PathVariable int userId,@RequestBody ResumeRequestDTO resumeRequestDTO)
	{
		return resumeService.addResume(userId, resumeRequestDTO);
	}
}
