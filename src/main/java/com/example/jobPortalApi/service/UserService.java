package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface UserService 
{
	public ResponseEntity<ResponseStructure<String>> addUser(UserRequestDTO userRequestDTO);
}
