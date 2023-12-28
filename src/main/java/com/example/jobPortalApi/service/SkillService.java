package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.jobPortalApi.entity.Skills;
import com.example.jobPortalApi.responseDTO.SkillResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface SkillService 
{
	public ResponseEntity<ResponseStructure<String>> addSkillByEmployee(int userId,Skills skills);
	
	public ResponseEntity<ResponseStructure<String>> addSkillByApplicant(int resumeId,List<String> skillList);
	
	public ResponseEntity<ResponseStructure<String>> updateSkillByApplicant(int resumeId,List<String> skillList);
	
	public ResponseEntity<ResponseStructure<SkillResponseDTO>> findSkill(@PathVariable String skill);
	
	public ResponseEntity<ResponseStructure<SkillResponseDTO>> deleteSkill(@PathVariable String skill);
}
