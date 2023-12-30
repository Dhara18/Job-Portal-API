package com.example.jobPortalApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.entity.Project;
import com.example.jobPortalApi.requestDTO.ProjectRequestDTO;
import com.example.jobPortalApi.responseDTO.ProjectResponseDTO;
import com.example.jobPortalApi.service.ProjectService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class ProjectController 
{
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/resumes/{resumeId}/projects",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addProject(@RequestBody ProjectRequestDTO projectRequestDTO,@PathVariable int resumeId)
	{
		return projectService.addProject(projectRequestDTO, resumeId);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}/projects",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<List<ProjectResponseDTO>>> findProjectByResume(@PathVariable int resumeId)
	{
		return projectService.findProject(resumeId);
	}
	
	@RequestMapping(value = "/resumes/{resumeId}/projects/{projectName}",method = RequestMethod.DELETE)
	public ResponseEntity<ResponseStructure<ProjectResponseDTO>> deleteProject(@PathVariable int resumeId,@PathVariable String projectName)
	{
		return projectService.deleteProject(resumeId,projectName);
	}
	
}
