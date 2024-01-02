package com.example.jobPortalApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Education;
import com.example.jobPortalApi.repository.EducationRepo;
import com.example.jobPortalApi.requestDTO.EducationRequestDTO;
import com.example.jobPortalApi.responseDTO.EducationResponseDTO;
import com.example.jobPortalApi.service.EducationService;

@Service
public class EducationServiceImpl implements EducationService
{

	@Autowired
	EducationRepo educationRepo;
	
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
		education.setDegreeType(educationRequestDTO.getDegreeType());
		education.setDegreeStream(educationRequestDTO.getDegreeStream());
		
		return education;
	}
	
	public EducationResponseDTO ducationToEducationResponseDTO(Education education)
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
		educationResponseDTO.setDegreeType(education.getDegreeType());
		educationResponseDTO.setDegreeStream(education.getDegreeStream());
		return educationResponseDTO;
	}
}
