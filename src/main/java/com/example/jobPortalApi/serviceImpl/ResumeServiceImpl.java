package com.example.jobPortalApi.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Resume;
import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.exception.InvalidUserException;
import com.example.jobPortalApi.exception.ResumeNotFoundException;
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

	@Override
	public ResponseEntity<ResponseStructure<ResumeResponseDTO>> findResume(int resumeId) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);

		if(optionalResume.isPresent())
		{
			Resume resume = optionalResume.get();
			Map<String,String> resumeOptions= new HashMap<>();
			String url="/users/";
			resumeOptions.put("users", url+resume.getUserType().getUserId());

			ResumeResponseDTO resumeResponceDTO=resumeToResumeResponceDTO(resume);
			resumeResponceDTO.setOptions(resumeOptions);

			ResponseStructure<ResumeResponseDTO> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Resume object successfully found");
			responseStructure.setData(resumeResponceDTO);
			return new ResponseEntity<ResponseStructure<ResumeResponseDTO>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new ResumeNotFoundException("resume with given id not present");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> updateResume(int userId,int resumeId, ResumeRequestDTO resumeRequestDTO) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);
		User user = optionalUser.get();

		if(user.getUserRole()==UserRole.APPLICANT)
		{
			Optional<Resume> resumeOptional = resumeRepo.findById(resumeId);
			if(resumeOptional.isPresent())
			{
				Resume resume=resumeOptional.get();
				resume.setObjective(resumeRequestDTO.getObjective());
				resumeRepo.save(resume);
				
				ResponseStructure<String> responseStructure=new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("Resume object successfully updated");
				responseStructure.setData("Resume updated object stored in the data base");

				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
			}
			
			else
			{
				throw new ResumeNotFoundException("resume with id not present");
			}
			
		}
		else
		{
			throw new InvalidUserException("user has to be applicant to add the resume");
		}
	}
}
