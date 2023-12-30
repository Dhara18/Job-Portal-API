package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.ExperienceRequestDTO;
import com.example.jobPortalApi.responseDTO.ExperienceResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface ExperienceService 
{
	public ResponseEntity<ResponseStructure<String>> addExperience(ExperienceRequestDTO experienceRequestDTO,int resumeId);
	public ResponseEntity<ResponseStructure<List<ExperienceResponseDTO>>> findExperienceByResume(int resumeId);
	public ResponseEntity<ResponseStructure<List<ExperienceResponseDTO>>> deleteExperienceByResume(int resumeId);
}
