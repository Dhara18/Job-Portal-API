package com.example.jobPortalApi.serviceImpl;

import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	
	public User userRequestDTOToUser(UserRequestDTO userRequestDTO)
	{
		User user= new User();
		
		user.setUsername(userRequestDTO.getUsername());
		user.setEmail(userRequestDTO.getEmail());
		user.setPassword(userRequestDTO.getPassword());
		user.setUserRole(userRequestDTO.getUserRole());
		
		return user;
	}
	
	
}
