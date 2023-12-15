package com.example.jobPortalApi.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.exception.UserNotFoundException;
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

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> findUserById(int id) 
	{
		Optional<User> optionalUser = userRepo.findById(id);	

		if(optionalUser.isPresent())
		{
			User user = optionalUser.get();
			UserResponseDTO userResponseDTO=UserToUserResponseDTO(user);
			
			ResponseStructure<UserResponseDTO> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("User object successfully found");
			responseStructure.setData(userResponseDTO);

			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(responseStructure, HttpStatus.FOUND);
		}

		else
		{
			throw new UserNotFoundException("user with given id does not exist"); 
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> updateUserById(UserRequestDTO userRequestDTO, int id) 
	{
		Optional<User> optionalUser = userRepo.findById(id);	

		if(optionalUser.isPresent())
		{
			
			User user = optionalUser.get();
			user.setUsername(userRequestDTO.getUsername());
			user.setEmail(userRequestDTO.getEmail());
			user.setPassword(userRequestDTO.getPassword());
			user.setUserRole(userRequestDTO.getUserRole());
			
			userRepo.save(user);
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("User object with id successfully found");
			responseStructure.setData("user object successfully updated");
			
			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
		}
		
		else
		{
			throw new UserNotFoundException("user wuth id does not exist... so cannot update");
		}


	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponseDTO>> deleteByUserById(int id) 
	{
		Optional<User> optionalUser = userRepo.findById(id);	

		if(optionalUser.isPresent())
		{
			User user = optionalUser.get();
			UserResponseDTO userResponse = UserToUserResponseDTO(user);
			
			userRepo.deleteById(id);
			
			ResponseStructure<UserResponseDTO> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("User object with id successfully deleted...and the object is shown below");
			responseStructure.setData(userResponse);
			
			return new ResponseEntity<ResponseStructure<UserResponseDTO>>(responseStructure, HttpStatus.ACCEPTED);
		}
		
		else
		{
			throw new UserNotFoundException("user with id does not exist... so cannot be deleted");
		}
	}
}
