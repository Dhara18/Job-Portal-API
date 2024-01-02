package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.SocialProfileRequestDTO;
import com.example.jobPortalApi.responseDTO.SocialProfileResponseDTO;
import com.example.jobPortalApi.service.SocialProfileService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.ProfileType;

@RestController
public class SocialProfileController 
{
	@Autowired
	SocialProfileService socialProfileService;
	
	@RequestMapping(value = "/resumes/{resumeId}/profileType/{profileType}/socialProfiles",method = RequestMethod.POST)		
	public ResponseEntity<ResponseStructure<String>> addSocialProfileByApplicant(@PathVariable int resumeId,@RequestBody SocialProfileRequestDTO socialProfileRequestDTO,@PathVariable ProfileType profileType)
	{
		return socialProfileService.addSocialProfileByApplicant(resumeId,socialProfileRequestDTO,profileType);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}/profileType/{profileType}/socialProfiles",method = RequestMethod.PUT)		
	public ResponseEntity<ResponseStructure<String>> updateSocialProfileByApplicant(@PathVariable int resumeId,@RequestBody SocialProfileRequestDTO socialProfileRequestDTO,@PathVariable ProfileType profileType)
	{
		return socialProfileService.updateSocialProfileByApplicant(resumeId,socialProfileRequestDTO,profileType);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}/profileType/{profileType}",method = RequestMethod.GET)		
	public ResponseEntity<ResponseStructure<SocialProfileResponseDTO>> findSocialProfileByType(@PathVariable int resumeId,@PathVariable String profileType)
	{
		return socialProfileService.findSocialProfileByType(resumeId,profileType);
	}
	
}
