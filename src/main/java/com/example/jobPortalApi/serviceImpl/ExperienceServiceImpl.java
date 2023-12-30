package com.example.jobPortalApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.repository.ExperienceRepo;
import com.example.jobPortalApi.service.ExperienceService;

@Service
public class ExperienceServiceImpl implements ExperienceService
{
	@Autowired
	ExperienceRepo experienceRepo;
}
