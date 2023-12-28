package com.example.jobPortalApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.repository.ProjectRepo;
import com.example.jobPortalApi.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	ProjectRepo projectRepo;
}
