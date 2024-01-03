package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.EducationRequestDTO;
import com.example.jobPortalApi.service.EducationService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.EducationType;

@RestController
public class EducationController 
{
	@Autowired
	EducationService educationService;
	
	@RequestMapping(value = "/resumes/{resumeId}/educationTypes/{educationType}/educations",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addExperience(@RequestBody EducationRequestDTO educationRequestDTO,@PathVariable int resumeId,@PathVariable EducationType educationType)
	{
		return educationService.addExperience(educationRequestDTO, resumeId,educationType);
	}
}
