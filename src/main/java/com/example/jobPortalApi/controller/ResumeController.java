package com.example.jobPortalApi.controller;

import java.util.List;

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
	
	@RequestMapping(value = "/users/{userId}/resume/{resumeId}",method = RequestMethod.DELETE)
	public ResponseEntity<ResponseStructure<ResumeResponseDTO>> deleteResume(@PathVariable int userId,@PathVariable int resumeId)
	{
		return resumeService.deleteResume(userId,resumeId);
	}
	
	@RequestMapping(value = "/skills",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<ResumeResponseDTO>>> findResumeBySkillName(String skillName)
	{
		return resumeService.findResumeBySkillName(skillName);
	}
}
