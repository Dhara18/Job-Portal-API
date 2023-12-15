package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface UserService 
{
	public ResponseEntity<ResponseStructure<String>> addUser(UserRequestDTO userRequestDTO);
	
	public ResponseEntity<ResponseStructure<User>> findUserById(int id);
}
