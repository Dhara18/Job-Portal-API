package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.ResumeRequestDTO;
import com.example.jobPortalApi.responseDTO.ResumeResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface ResumeService 
{
	public ResponseEntity<ResponseStructure<String>> addResume(int userId,ResumeRequestDTO resumeRequestDTO);
	
	public ResponseEntity<ResponseStructure<ResumeResponseDTO>> findResume(int resumeId);
	
	public ResponseEntity<ResponseStructure<String>> updateResume(int userId,int resumeId,ResumeRequestDTO resumeRequestDTO);
}
