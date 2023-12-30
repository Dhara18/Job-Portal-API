package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.jobPortalApi.requestDTO.ExperienceRequestDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface ExperienceService 
{
	public ResponseEntity<ResponseStructure<String>> addExperience(@RequestBody ExperienceRequestDTO experienceRequestDTO,@PathVariable int resumeId);
}
