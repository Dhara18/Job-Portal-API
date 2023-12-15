package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.responseDTO.UserResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;

public interface UserService 
{
	public ResponseEntity<ResponseStructure<String>> addUser(UserRequestDTO userRequestDTO);
	
	public ResponseEntity<ResponseStructure<UserResponseDTO>> findUserById(int id);
	
	public ResponseEntity<ResponseStructure<String>> updateUserById(UserRequestDTO userRequestDTO,int id);
	
	public ResponseEntity<ResponseStructure<UserResponseDTO>> deleteByUserById(int id);
}
