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

import com.example.jobPortalApi.entity.Experience;
import com.example.jobPortalApi.entity.Resume;
import com.example.jobPortalApi.exception.ResumeNotFoundException;
import com.example.jobPortalApi.repository.ExperienceRepo;
import com.example.jobPortalApi.repository.ResumeRepo;
import com.example.jobPortalApi.requestDTO.ExperienceRequestDTO;
import com.example.jobPortalApi.responseDTO.ExperienceResponseDTO;
import com.example.jobPortalApi.service.ExperienceService;
import com.example.jobPortalApi.utility.ResponseStructure;

@Service
public class ExperienceServiceImpl implements ExperienceService
{
	@Autowired
	ExperienceRepo experienceRepo;
	
	@Autowired
	ResumeRepo resumerepo;
	
	public Experience experienceRequestDTOToExperience(ExperienceRequestDTO experienceRequestDTO)
	{
		Experience experience= new Experience();
		experience.setDescription(experienceRequestDTO.getDescription());
		experience.setOrganisation(experienceRequestDTO.getOrganisation());
		experience.setJobRole(experienceRequestDTO.getJobRole());
		experience.setJobStatus(experienceRequestDTO.isJobStatus());
		experience.setStartTime(experienceRequestDTO.getStartTime());
		experience.setEndTime(experienceRequestDTO.getEndTime());
		
		return experience;
	}
	
	public ExperienceResponseDTO experienceToExperienceResponseDTO(Experience experience)
	{
		ExperienceResponseDTO experienceResponseDTO= new ExperienceResponseDTO();
		experienceResponseDTO.setExprId(experience.getExprId());
		experienceResponseDTO.setDescription(experience.getDescription());
		experienceResponseDTO.setOrganisation(experience.getOrganisation());
		experienceResponseDTO.setJobRole(experience.getJobRole());
		experienceResponseDTO.setJobStatus(experience.isJobStatus());
		experienceResponseDTO.setStartTime(experience.getStartTime());
		experienceResponseDTO.setEndTime(experience.getEndTime());
		experienceResponseDTO.setYearsOfExperience(experience.getYearsOfExperience());
		return experienceResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addExperience(ExperienceRequestDTO experienceRequestDTO,int resumeId) 
	{
		Optional<Resume> optionalResume = resumerepo.findById(resumeId);
		if(optionalResume.isPresent())
		{
			Experience experience=experienceRequestDTOToExperience(experienceRequestDTO);
			experience.setAssocicatedResume(resumerepo.findById(resumeId).get());
			experienceRepo.save(experience);
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Experience object successfully added");
			responseStructure.setData("Experience object stored in the data base");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
		}
		else
		{
			throw new ResumeNotFoundException("resume with givaen id does not exist");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<ExperienceResponseDTO>>> findExperienceByResume(int resumeId) 
	{
		Optional<Resume> optionalResume = resumerepo.findById(resumeId);
		if(optionalResume.isPresent())
		{
			Resume resume = optionalResume.get();
			List<Experience> experienceList = resume.getExperince();
			
			String url="/resumes"+resumeId;
			Map<String,String> options=new HashMap<>();
			
			List<ExperienceResponseDTO> responseList= new ArrayList<>();
			for(Experience experience:experienceList)
			{
				ExperienceResponseDTO experienceResponseDTO = experienceToExperienceResponseDTO(experience);
				options.put("resume", url);
				experienceResponseDTO.setResumeOptions(options);
				
				responseList.add(experienceResponseDTO);
			}
			
			ResponseStructure<List<ExperienceResponseDTO>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("Experience object successfully added");
			responseStructure.setData(responseList);

			return new ResponseEntity<ResponseStructure<List<ExperienceResponseDTO>>>(responseStructure, HttpStatus.ACCEPTED);
		}
		else
		{
			throw new ResumeNotFoundException("resume with givaen id does not exist");
		}
	}
}
