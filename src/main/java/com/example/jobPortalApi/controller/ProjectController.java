package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.entity.Project;
import com.example.jobPortalApi.service.ProjectService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class ProjectController 
{
	@Autowired
	ProjectService projectService;
	
	public ResponseEntity<ResponseStructure<String>> addProject(@RequestBody Project project)
	{
		return null;
	}
	
}
