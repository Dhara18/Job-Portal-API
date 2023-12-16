package com.example.jobPortalApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.responseDTO.UserResponseDTO;
import com.example.jobPortalApi.service.UserService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.UserRole;

@RestController
public class UserController 
{
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/userRole/{userRole}/users",method = RequestMethod.POST)
	public ResponseEntity<ResponseStructure<String>> addUser(@RequestBody UserRequestDTO userRequestDTO,@PathVariable UserRole userRole)
	{
		return userService.addUser(userRequestDTO,userRole);
	}
	
	@RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
	public ResponseEntity<ResponseStructure<UserResponseDTO>> findUserById(@PathVariable int id)
	{
		return userService.findUserById(id);
	}
	
	@RequestMapping(value = "/userRole/{userRole}/users/{id}",method = RequestMethod.PUT)
	public ResponseEntity<ResponseStructure<String>> updateUserById(@RequestBody UserRequestDTO userRequestDTO,@PathVariable UserRole userRole,@PathVariable int id)
	{
		return userService.updateUserById(userRequestDTO,userRole,id);
	}
	
	@RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ResponseStructure<UserResponseDTO>> deleteByUserById(@PathVariable int id)
	{
		return userService.deleteByUserById(id);
	}
}
