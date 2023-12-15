package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.service.UserService;
import com.example.jobPortalApi.utility.ResponseStructure;

@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/users",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addUser(@RequestBody UserRequestDTO userRequestDTO)
	{
		return userService.addUser(userRequestDTO);
	}
}
