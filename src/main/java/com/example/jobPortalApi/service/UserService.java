package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.responseDTO.UserResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.UserRole;

public interface UserService 
{
	public ResponseEntity<ResponseStructure<String>> addUser(UserRequestDTO userRequestDTO,UserRole userRole);
	
	public ResponseEntity<ResponseStructure<UserResponseDTO>> findUserById(int id);
	
	public ResponseEntity<ResponseStructure<String>> updateUserById(UserRequestDTO userRequestDTO,UserRole userRole,int id);
	
	public ResponseEntity<ResponseStructure<UserResponseDTO>> deleteByUserById(int id);
}
