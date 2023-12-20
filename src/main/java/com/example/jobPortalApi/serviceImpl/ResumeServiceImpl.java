package com.example.jobPortalApi.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Resume;
import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.exception.InvalidUserException;
import com.example.jobPortalApi.repository.ResumeRepo;
import com.example.jobPortalApi.repository.UserRepo;
import com.example.jobPortalApi.requestDTO.ResumeRequestDTO;
import com.example.jobPortalApi.responseDTO.ResumeResponseDTO;
import com.example.jobPortalApi.service.ResumeService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.UserRole;

@Service
public class ResumeServiceImpl implements ResumeService
{
	@Autowired
	ResumeRepo resumeRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public Resume resumeRequestDtoToResume(ResumeRequestDTO resumeRequestDTO)
	{
		Resume resume= new Resume();
		resume.setObjective(resumeRequestDTO.getObjective());
		
		return resume;
	}
	
	public ResumeResponseDTO resumeToResumeResponceDTO(Resume resume)
	{
		ResumeResponseDTO resumeResponseDTO= new ResumeResponseDTO();
		resumeResponseDTO.setResumeId(resume.getResumeId());
		resumeResponseDTO.setObjective(resume.getObjective());
		
		return resumeResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addResume(int userId, ResumeRequestDTO resumeRequestDTO) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);
		User user = optionalUser.get();
		
		if(user.getUserRole()==UserRole.APPLICANT)
		{
			Resume resume = resumeRequestDtoToResume(resumeRequestDTO);
			resume.setUserType(user);
			resumeRepo.save(resume);
			
			ResponseStructure<String> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Resume object successfully added");
			responseStructure.setData("Resume object stored in the data base");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
		}
		else
		{
			throw new InvalidUserException("user has to be applicant to add the resume");
		}
	}
}
