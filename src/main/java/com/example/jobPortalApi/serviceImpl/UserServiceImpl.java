package com.example.jobPortalApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.repository.UserRepo;
import com.example.jobPortalApi.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepo userRepo;
}
