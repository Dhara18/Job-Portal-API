package com.example.jobPortalApi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.jobPortalApi.requestDTO.ProjectRequestDTO;
import com.example.jobPortalApi.responseDTO.ProjectResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface ProjectService 
{
	public ResponseEntity<ResponseStructure<String>> addProject(@RequestBody ProjectRequestDTO projectRequestDTO,@PathVariable int resumeId);
	public ResponseEntity<ResponseStructure<List<ProjectResponseDTO>>> findProject(@PathVariable int resumeId);
}
