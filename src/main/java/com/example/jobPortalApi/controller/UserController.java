package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.serviceImpl.UserServiceImpl;

@RestController
public class UserController 
{
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
}