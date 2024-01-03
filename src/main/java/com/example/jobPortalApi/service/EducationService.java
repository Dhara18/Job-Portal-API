package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.EducationRequestDTO;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.EducationType;

public interface EducationService {

	ResponseEntity<ResponseStructure<String>> addExperience(EducationRequestDTO educationRequestDTO, int resumeId,EducationType educationType);

}
