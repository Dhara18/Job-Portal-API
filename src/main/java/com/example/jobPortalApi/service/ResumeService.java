package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.jobPortalApi.requestDTO.ResumeRequestDTO;
import com.example.jobPortalApi.responseDTO.ResumeResponseDTO;
import com.example.jobPortalApi.responseDTO.UserResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface ResumeService 
{
	public ResponseEntity<ResponseStructure<String>> addResume(int userId,ResumeRequestDTO resumeRequestDTO);
	
	public ResponseEntity<ResponseStructure<ResumeResponseDTO>> findResume(int resumeId);
}
