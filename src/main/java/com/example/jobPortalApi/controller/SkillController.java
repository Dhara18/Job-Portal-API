package com.example.jobPortalApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.entity.Skills;
import com.example.jobPortalApi.responseDTO.SkillResponseDTO;
import com.example.jobPortalApi.service.SkillService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class SkillController 
{
	@Autowired
	SkillService skillService;
	
	
	@RequestMapping(value = "/users/{userId}/skills",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addSkillByEmployee(@PathVariable int userId,@RequestBody Skills skills)
	{
		return skillService.addSkillByEmployee(userId,skills);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}/skills",method = RequestMethod.POST)		// /users/{userId} not required because if resume exist means then user of type applicant has added that resume
	public ResponseEntity<ResponseStructure<String>> addSkillByApplicant(@PathVariable int resumeId,@RequestBody List<String> skillList)
	{
		return skillService.addSkillByApplicant(resumeId,skillList);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}/skills",method = RequestMethod.PUT)
	public ResponseEntity<ResponseStructure<String>> updateSkillByApplicant(@PathVariable int resumeId,@RequestBody List<String> skillList)
	{
		return skillService.updateSkillByApplicant(resumeId,skillList);
	}
	
	@RequestMapping(value = "/skills/{skill}",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<SkillResponseDTO>> findSkill(@PathVariable String skill)
	{
		return skillService.findSkill(skill);
	}
	
	@RequestMapping(value = "/skills/{skill}",method = RequestMethod.DELETE)
	public ResponseEntity<ResponseStructure<SkillResponseDTO>> deleteSkill(@PathVariable String skill)
	{
		return skillService.deleteSkill(skill);
	}
	
	
}
