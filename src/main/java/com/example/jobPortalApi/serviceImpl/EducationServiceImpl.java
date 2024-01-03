package com.example.jobPortalApi.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Education;
import com.example.jobPortalApi.entity.Resume;
import com.example.jobPortalApi.exception.ResumeNotFoundException;
import com.example.jobPortalApi.repository.EducationRepo;
import com.example.jobPortalApi.repository.ResumeRepo;
import com.example.jobPortalApi.requestDTO.EducationRequestDTO;
import com.example.jobPortalApi.responseDTO.EducationResponseDTO;
import com.example.jobPortalApi.service.EducationService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.EducationType;

@Service
public class EducationServiceImpl implements EducationService
{

	@Autowired
	EducationRepo educationRepo;
	
	@Autowired
	ResumeRepo resumeRepo;
	
	public Education educationRquestDtoToEducation(EducationRequestDTO educationRequestDTO)
	{
		Education education = new Education();
		education.setStartDate(educationRequestDTO.getStartDate());
		education.setEndDate(educationRequestDTO.getEndDate());
		education.setPresentStatus(educationRequestDTO.isPresentStatus());
		education.setPercentage(educationRequestDTO.getPercentage());
		education.setCgpa(educationRequestDTO.getCgpa());
		education.setInstitutename(educationRequestDTO.getInstitutename());
		education.setLocation(educationRequestDTO.getLocation());
		education.setStreamType(educationRequestDTO.getStreamType());
		education.setStreamCombination(educationRequestDTO.getStreamCombination());
		
		return education;
	}
	
	public EducationResponseDTO educationToEducationResponseDTO(Education education)
	{
		EducationResponseDTO educationResponseDTO = new  EducationResponseDTO();
		
		educationResponseDTO.setEducationId(education.getEducationId());
		educationResponseDTO.setStartDate(education.getStartDate());
		educationResponseDTO.setEndDate(education.getEndDate());
		educationResponseDTO.setPresentStatus(education.isPresentStatus());
		educationResponseDTO.setPercentage(education.getPercentage());
		educationResponseDTO.setCgpa(education.getCgpa());
		educationResponseDTO.setInstitutename(education.getInstitutename());
		educationResponseDTO.setLocation(education.getLocation());
		educationResponseDTO.setStreamType(education.getStreamType());
		educationResponseDTO.setStreamCombination(education.getStreamCombination());
		
		return educationResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addExperience(EducationRequestDTO educationRequestDTO,
			int resumeId,EducationType educationType) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);
		if(optionalResume.isPresent())
		{
			Resume resume = optionalResume.get();
			
			if(educationType==EducationType.SSLC)
			{
				Education education = educationRquestDtoToEducation(educationRequestDTO);
				education.setStreamType(null);
				education.setStreamCombination(null);
				educationRepo.save(education);
			}
			return null;
		}
		else
		{
			throw new ResumeNotFoundException("resume with given id does not exist....so cannot add the education");
		}
	}
}
