package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.service.ExperienceService;

@RestController
public class ExperienceController 
{
	@Autowired
	ExperienceService experienceService;
}
