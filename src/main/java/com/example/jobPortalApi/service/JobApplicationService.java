package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.responseDTO.JobApplicationResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface JobApplicationService 
{

	ResponseEntity<ResponseStructure<String>> addResume(int userId, int jobId);

	ResponseEntity<ResponseStructure<List<JobApplicationResponseDTO>>> findJobApplicationByUser(int userId);

}
