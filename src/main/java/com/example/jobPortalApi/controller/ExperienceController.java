package com.example.jobPortalApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.ExperienceRequestDTO;
import com.example.jobPortalApi.responseDTO.ExperienceResponseDTO;
import com.example.jobPortalApi.service.ExperienceService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class ExperienceController 
{
	@Autowired
	ExperienceService experienceService;
	
	@RequestMapping(value = "/resumes/{resumeId}/experiences",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addExperience(@RequestBody ExperienceRequestDTO experienceRequestDTO,@PathVariable int resumeId)
	{
		return experienceService.addExperience(experienceRequestDTO, resumeId);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<ExperienceResponseDTO>>> findExperienceByResume(@PathVariable int resumeId)
	{
		return experienceService.findExperienceByResume(resumeId);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}",method = RequestMethod.DELETE)
	public ResponseEntity<ResponseStructure<List<ExperienceResponseDTO>>> deleteExperienceByResume(@PathVariable int resumeId)
	{
		return experienceService.deleteExperienceByResume(resumeId);
	}
}
