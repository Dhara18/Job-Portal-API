package com.example.jobPortalApi.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import com.example.jobPortalApi.responseDTO.ResumeResponseDTO;
import com.example.jobPortalApi.responseDTO.SkillResponseDTO;
import com.example.jobPortalApi.service.ResumeService;
import com.example.jobPortalApi.service.SkillService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.UserRole;

@Service
public class SkillServiceImpl implements SkillService 
{
	@Autowired
	SkillRepo skillRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	ResumeRepo resumeRepo;

	@Autowired
	ResumeService resumeService;


	public SkillResponseDTO skillToSkillResponse(Skills skill)
	{
		SkillResponseDTO skillResponseDTO= new SkillResponseDTO();
		skillResponseDTO.setSkillId(skill.getSkillId());
		skillResponseDTO.setSkill(skill.getSkill());

		return skillResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addSkillByEmployee(int userid,Skills skills) 
	{
		User user = userRepo.findById(userid).get();
		if(user.getUserRole()==UserRole.EMPLOYER)
		{
			List<Skills> skillList = skillRepo.findAll();

			if (skillList.isEmpty()) 
			{
				Skills skill = new Skills();
				skill.setSkill(skills.getSkill().toLowerCase()); // case conversion

				skillRepo.save(skill);

				ResponseStructure<String> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("skill object successfully added");
				responseStructure.setData("skill object stored in the data base");

				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);

			}

			else 
			{
				int count = 0;

				for (Skills skill : skillList) 
				{
					if (skill.getSkill().toLowerCase().equals(skills.getSkill().toLowerCase())) //to compare string method required
					{
						count++;
					}
				}

				if (count == 0) 
				{
					Skills skill = new Skills();
					skill.setSkill(skills.getSkill().toLowerCase()); // case conversion

					skillRepo.save(skill);

					ResponseStructure<String> responseStructure = new ResponseStructure<>();
					responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
					responseStructure.setMessage("skill object successfully added");
					responseStructure.setData("skill object stored in the data base");

					return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);

				}

				ResponseStructure<String> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("skill already present in data base");
				responseStructure.setData("skill object did not added to data base");

				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
			}

		}
		else
		{
			throw new InvalidUserException("applicant must add skills in the resume");
		}
	}

	private Skills skillIdentifier(String skill)		//query taking string to compare,cannot pass skill type it means it will be object type
	{
		Skills oldSkill = skillRepo.findSkillByName(skill.toLowerCase());
		if(oldSkill==null)
		{
			Skills NewSkill= new Skills();
			NewSkill.setSkill(skill.toLowerCase());
			skillRepo.save(NewSkill);
			return NewSkill;
		}
		else
		{
			return oldSkill;		//here string got converted to Skill type
		}
	}
	@Override
	public ResponseEntity<ResponseStructure<String>> addSkillByApplicant(int resumeId, List<String> skillList) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);

		List<Skills> list= new ArrayList<>();
		if(optionalResume.isPresent())
		{
			Resume resume = optionalResume.get();
			System.out.println("44444444444");
			for(String skills:skillList)	//here taking skills as list of string and converting to skill based on the string exist in the data base
			{
				Skills returnSkill = skillIdentifier(skills);
				System.out.println("333333333333");

				list.add(returnSkill);
			}
			System.out.println("000000000000000000000000");
			resume.setListSkill(list);		//here assigning the values to the resume....
			System.out.println("11111111111111111111111111");
			resumeRepo.save(resume);
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("skill object successfully added");
			responseStructure.setData("skill object stored in the data base");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
		}
		else
		{
			throw new ResumeNotFoundException("resume with givan id not present..... so cannot add skills");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> updateSkillByApplicant(int resumeId, List<String> skillList) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);

		List<Skills> newList= new ArrayList<>();
		if(optionalResume.isPresent())
		{

			for(String skills:skillList)	
			{
				Skills newSkill = skillIdentifier(skills);

				newList.add(newSkill);	
			}

			optionalResume.get().setListSkill(newList);
			resumeRepo.save(optionalResume.get());

			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("skill object successfully added");
			responseStructure.setData("skill object stored in the data base");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
		}

		else
		{
			throw new ResumeNotFoundException("resume with given id not present please enter valid id");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<SkillResponseDTO>> findSkill(String skill) 
	{
		Skills skillObj = skillRepo.findSkillByName(skill);

		if(skillObj!=null)
		{
			ResponseEntity<ResponseStructure<List<ResumeResponseDTO>>> resumeDTOListResponse = resumeService.findResumeBySkillName(skill);
			List<ResumeResponseDTO> resumeDTOList = resumeDTOListResponse.getBody().getData();

			Map<String,List<String>> options =new HashMap<>();

			List<String> urlList=new ArrayList<>();
			for(ResumeResponseDTO resumeResponseDTO:resumeDTOList)
			{
				int resumeId = resumeResponseDTO.getResumeId();
				Resume resume = resumeRepo.findById(resumeId).get();
				urlList.add("/users/"+resume.getUserType().getUserId());
			}

			options.put("users", urlList);

			SkillResponseDTO skillResponseDTO = skillToSkillResponse(skillObj);
			skillResponseDTO.setUserOptions(options);

			ResponseStructure<SkillResponseDTO> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("skill object successfully added");
			responseStructure.setData(skillResponseDTO);

			return new ResponseEntity<ResponseStructure<SkillResponseDTO>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new SkillNotFoundException("given skill does not exist in the data base");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<SkillResponseDTO>> deleteSkill(String skill) 
	{
		Skills skillObj = skillRepo.findSkillByName(skill);

		if(skillObj!=null)
		{
			ResponseEntity<ResponseStructure<List<ResumeResponseDTO>>> resumeDTOListResponse = resumeService.findResumeBySkillName(skill);
			List<ResumeResponseDTO> resumeDTOList = resumeDTOListResponse.getBody().getData();

			List<String> urlList= new ArrayList<>();
			for(ResumeResponseDTO resumeResponseDTO:resumeDTOList)		//to remove skill from skill list of resume
			{
				int resumeId = resumeResponseDTO.getResumeId();
				Resume resume = resumeRepo.findById(resumeId).get();
				String url="/resume"+resume.getUserType().getUserId();
				urlList.add(url);

				resumeRepo.save(resume);
				
				List<Skills> skillList = resume.getListSkill();

//				for(Skills skills : skillList)
//				{
//					if(skills.getSkill().equals(skill))
//					{
//						skillList.remove(skills);
//					}
//				}														//throws concurrent modification exception
//				Iterator<Skills> iterator = skillList.iterator();
//				while(iterator.hasNext())
//				{
//					Skills skills = iterator.next();
//
//					if(skills.getSkill().equals(skill))
//					{
//						skillList.remove(skills);
//					}
//				}

				// both iterator and for each loop does not work....gives concurrent modification exception
				
				System.out.println(skillList.contains(skillObj));
				
				if(skillList.contains(skillObj))
				{
					skillList.remove(skillObj);
				}
			}

			skillRepo.delete(skillObj);

			SkillResponseDTO skillResponseDTO = skillToSkillResponse(skillObj);

			Map<String,List<String>> options= new HashMap<>();
			options.put("users", urlList);


			skillResponseDTO.setUserOptions(options);

			ResponseStructure<SkillResponseDTO> responseStructure = new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("skill object successfully added");
			responseStructure.setData(skillResponseDTO);

			return new ResponseEntity<ResponseStructure<SkillResponseDTO>>(responseStructure, HttpStatus.ACCEPTED);

		}
		else
		{
			throw new SkillNotFoundException("there is no skill to delete");
		}
	}

}
