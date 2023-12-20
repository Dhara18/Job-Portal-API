package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.ResumeRequestDTO;
import com.example.jobPortalApi.responseDTO.ResumeResponseDTO;
import com.example.jobPortalApi.service.ResumeService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class ResumeController 
{
	@Autowired
	ResumeService resumeService;
	
	@RequestMapping(value = "/users/{userId}/resume",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addResume(@PathVariable int userId,@RequestBody ResumeRequestDTO resumeRequestDTO)
	{
		return resumeService.addResume(userId, resumeRequestDTO);
	}
	
	@RequestMapping(value = "/resume/{resumeId}",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<ResumeResponseDTO>> findResume(@PathVariable int resumeId)
	{
		return resumeService.findResume(resumeId);
	}
	
	@RequestMapping(value = "/users/{userId}/resume/{resumeId}",method = RequestMethod.PUT)
	public ResponseEntity<ResponseStructure<String>> updateResume(@PathVariable int userId,@PathVariable int resumeId,@RequestBody ResumeRequestDTO resumeRequestDTO)
	{
		return resumeService.updateResume(userId,resumeId, resumeRequestDTO);
	}
}
