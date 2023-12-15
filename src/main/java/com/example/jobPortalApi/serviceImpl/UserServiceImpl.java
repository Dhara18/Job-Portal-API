package com.example.jobPortalApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.repository.UserRepo;
import com.example.jobPortalApi.requestDTO.UserRequestDTO;
import com.example.jobPortalApi.responseDTO.UserResponseDTO;
import com.example.jobPortalApi.service.UserService;
import com.example.jobPortalApi.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepo userRepo;
	
	public User userRequestDTOToUser(UserRequestDTO userRequestDTO)
	{
		User user= new User();
		
		user.setUsername(userRequestDTO.getUsername());
		user.setEmail(userRequestDTO.getEmail());
		user.setPassword(userRequestDTO.getPassword());
		user.setUserRole(userRequestDTO.getUserRole());
		
		return user;
	}
	
	public UserResponseDTO UserToUserResponseDTO(User user)
	{
		UserResponseDTO userResponseDTO=new UserResponseDTO();
		userResponseDTO.setUserId(user.getUserId());
		userResponseDTO.setUsername(user.getUsername());
		userResponseDTO.setEmail(user.getEmail());
		userResponseDTO.setUserRole(user.getUserRole());
		
		return userResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addUser(UserRequestDTO userRequestDTO) 
	{
		User user = userRequestDTOToUser(userRequestDTO);
		userRepo.save(user);
		
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("User object successfully added");
		responseStructure.setData("user object stored in the data base");
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
	}


}
