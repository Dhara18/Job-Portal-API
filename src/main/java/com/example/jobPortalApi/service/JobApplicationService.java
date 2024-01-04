package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.responseDTO.JobApplicationResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface JobApplicationService 
{

	ResponseEntity<ResponseStructure<String>> addResume(int userId, int jobId);

	ResponseEntity<ResponseStructure<List<JobApplicationResponseDTO>>> findJobApplicationByUser(int userId);

	ResponseEntity<ResponseStructure<List<JobApplicationResponseDTO>>> findJobApplicationByUJob(int jobId);

	ResponseEntity<ResponseStructure<String>> rejectJobApplicationByApplicationId(int jobapplicationId);

	ResponseEntity<ResponseStructure<JobApplicationResponseDTO>> deleteJobApplication(int userId, int jobId);

}
