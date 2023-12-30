package com.example.jobPortalApi.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Resume;
import com.example.jobPortalApi.entity.Skills;
import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.exception.InvalidUserException;
import com.example.jobPortalApi.exception.ResumeNotFoundException;
import com.example.jobPortalApi.exception.SkillNotFoundException;
import com.example.jobPortalApi.repository.ResumeRepo;
import com.example.jobPortalApi.repository.SkillRepo;
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
	
	@Autowired
	SkillRepo skillRepo;
	

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
		resumeResponseDTO.setListSkill(resume.getListSkill());
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
		
		System.out.println("11111111");

		if(user.getUserRole()==UserRole.APPLICANT)
		{
			Optional<Resume> resumeOptional = resumeRepo.findById(resumeId);
			
			System.out.println("2222222");
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

	@Override
	public ResponseEntity<ResponseStructure<ResumeResponseDTO>> deleteResume(int userId, int resumeId) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);
		User user = optionalUser.get();

		if(user.getUserRole()==UserRole.APPLICANT)
		{
			Optional<Resume> resumeOptional = resumeRepo.findById(resumeId);
			if(resumeOptional.isPresent())
			{
				Resume resume=resumeOptional.get();
				ResumeResponseDTO resumeResponseDTO = resumeToResumeResponceDTO(resume);
				
				Map<String,String> resumeOptions= new HashMap<>();
				String url="/users/";
				resumeOptions.put("users", url+resume.getUserType().getUserId());
				
				resumeResponseDTO.setOptions(resumeOptions);
				
				resumeRepo.deleteById(resumeId);
				
				ResponseStructure<ResumeResponseDTO> responseStructure=new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("Resume object successfully deleted by"+userId);
				responseStructure.setData(resumeResponseDTO);
				return new ResponseEntity<ResponseStructure<ResumeResponseDTO>>(responseStructure, HttpStatus.ACCEPTED);
			}
			
			else
			{
				throw new ResumeNotFoundException("resume with id not present");
			}
			
		}
		else
		{
			throw new InvalidUserException("user has to be applicant to delete the resume");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<ResumeResponseDTO>>> findResumeBySkillName(String skillName) 
	{
		Skills skill=skillRepo.findSkillByName(skillName);
		List<Resume> resumeList = resumeRepo.findAll();					//because in the extends JPA repository specified <Resume> in the argument
		
		List<ResumeResponseDTO> resumeListBySkill= new ArrayList<>();
		
		if(skill!=null)
		{
			for(Resume resume:resumeList)
			{
				List<Skills> skillList = resume.getListSkill();
				
				for(Skills skillObj:skillList)
				{
					if(skillObj.getSkill().equals(skill.getSkill()))
					{
						resumeListBySkill.add(resumeToResumeResponceDTO(resume));
					}			//can write method in the repository..each skill has to be passed to the method so that it can return resume...
				}
				
			}
			
			ResponseStructure<List<ResumeResponseDTO>> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Resume objects successfully found");
			responseStructure.setData(resumeListBySkill);
			return new ResponseEntity<ResponseStructure<List<ResumeResponseDTO>>>(responseStructure, HttpStatus.FOUND);
			
		}
		else
		{
			throw new SkillNotFoundException("entered skill doesnot exist in  the database..please enter the valid skill");
		}
	}
}
