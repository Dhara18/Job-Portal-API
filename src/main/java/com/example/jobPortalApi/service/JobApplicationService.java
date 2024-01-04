package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.utility.ResponseStructure;

public interface JobApplicationService 
{

	ResponseEntity<ResponseStructure<String>> addResume(int userId, int jobId);

}
