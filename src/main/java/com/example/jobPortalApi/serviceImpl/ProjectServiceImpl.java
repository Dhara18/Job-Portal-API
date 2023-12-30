package com.example.jobPortalApi.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Project;
import com.example.jobPortalApi.entity.Resume;
import com.example.jobPortalApi.exception.ProjectNotFoundException;
import com.example.jobPortalApi.exception.ResumeNotFoundException;
import com.example.jobPortalApi.repository.ProjectRepo;
import com.example.jobPortalApi.repository.ResumeRepo;
import com.example.jobPortalApi.requestDTO.ProjectRequestDTO;
import com.example.jobPortalApi.responseDTO.ProjectResponseDTO;
import com.example.jobPortalApi.service.ProjectService;
import com.example.jobPortalApi.utility.ResponseStructure;

@Service
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	ResumeRepo resumerepo;
	
	public ProjectResponseDTO ProjectToProjectResponseDTO(Project project)
	{
		ProjectResponseDTO projectResponseDTO= new ProjectResponseDTO();
		
		projectResponseDTO.setProjectId(project.getProjectId());
		projectResponseDTO.setProjectName(project.getProjectName());
		projectResponseDTO.setTechStack(project.getTechStack());
		projectResponseDTO.setDescribtion(project.getDescribtion());
		projectResponseDTO.setWebsite(project.getWebsite());
		projectResponseDTO.setSourceCode(project.getSourceCode());
		
		return projectResponseDTO;
	}
	
	public Project ProjectRequestDTOToProject(ProjectRequestDTO projectRequestDTO)
	{
		Project project = new Project();
		project.setProjectName(projectRequestDTO.getProjectName());
		project.setTechStack(removeDuplicates(projectRequestDTO.getTechStack()));		//duplicates are removed first and then converted to project type
		project.setDescribtion(projectRequestDTO.getDescribtion());
		project.setWebsite(projectRequestDTO.getWebsite());
		project.setSourceCode(projectRequestDTO.getSourceCode());
		return project;
	}
	
	public Set<String> removeDuplicates(Set<String> techStackSet)
	{
		Set<String> techSet=new TreeSet<>();
		
		for(String tech:techStackSet)
		{
			techSet.add(tech);
		}
		return techSet;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addProject(ProjectRequestDTO projectRequestDTO, int resumeId) 
	{
		Optional<Resume> optionalResume = resumerepo.findById(resumeId);
		if(optionalResume.isPresent())
		{
			Project project = ProjectRequestDTOToProject(projectRequestDTO);
			project.setResume(resumerepo.findById(resumeId).get());
			projectRepo.save(project);
			
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("project object successfully added");
			responseStructure.setData("project object stored in the data base");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
			
		}
		else
		{
			throw new ResumeNotFoundException("resume is not present for given id");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<ProjectResponseDTO>>> findProject(int resumeId) 
	{
		Optional<Resume> optionalresume = resumerepo.findById(resumeId);
		
		if(optionalresume.isPresent())
		{     Resume resume = optionalresume.get();
			      List<Project> projectList = resume.getProjectList();
			
			String url="/resumes"+resumeId;
			Map<String,String> options= new HashMap<>();
			
		//	List<Project> projectList = projectRepo.findByresumeId(id);
			
			
			if(!projectList.isEmpty())
			{
				List<ProjectResponseDTO> responseList= new ArrayList<>();
				for(Project project : projectList)
				{
					ProjectResponseDTO projectResponseDTO = ProjectToProjectResponseDTO(project);
					options.put("resumes", url);
					projectResponseDTO.setResumeOptions(options);
					
					responseList.add(projectResponseDTO);
				}
				
				
				ResponseStructure<List<ProjectResponseDTO>> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.FOUND.value());
				responseStructure.setMessage("project object successfully added");
				responseStructure.setData(responseList);

				return new ResponseEntity<ResponseStructure<List<ProjectResponseDTO>>>(responseStructure, HttpStatus.FOUND);
			}
			
			else
			{
				throw new ProjectNotFoundException("there are no projects for this resume");
			}
		}
		else
		{
			throw new ResumeNotFoundException("resume is not present for given id");
		}
	}
}
