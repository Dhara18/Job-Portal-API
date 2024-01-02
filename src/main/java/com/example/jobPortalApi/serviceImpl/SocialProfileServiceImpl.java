package com.example.jobPortalApi.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Resume;
import com.example.jobPortalApi.entity.SocialProfile;
import com.example.jobPortalApi.exception.DuplicateProfileTypeException;
import com.example.jobPortalApi.exception.ResumeNotFoundException;
import com.example.jobPortalApi.exception.SocialProfileNotFoundException;
import com.example.jobPortalApi.repository.ResumeRepo;
import com.example.jobPortalApi.repository.SocialProfileRepo;
import com.example.jobPortalApi.requestDTO.SocialProfileRequestDTO;
import com.example.jobPortalApi.responseDTO.SocialProfileResponseDTO;
import com.example.jobPortalApi.service.SocialProfileService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.ProfileType;

@Service
public class SocialProfileServiceImpl implements SocialProfileService
{
	@Autowired
	SocialProfileRepo socialProfileRepo;
	
	@Autowired
	ResumeRepo resumeRepo;
	
	public ProfileType profileIdentifier(String profileType)
	{
		ProfileType[] typeList = ProfileType.values();
		for(ProfileType profile:typeList)
		{
			if(profile.name().equals(profileType))
			{
				return profile;
			}
		}
		return null;
	}
	
	public SocialProfile socialProfileRequestDtoToSocial(SocialProfileRequestDTO socialProfileRequestDTO)
	{
		SocialProfile socialProfile= new SocialProfile();
		
		socialProfile.setProfileType(socialProfileRequestDTO.getProfileType());
		socialProfile.setUrl(socialProfileRequestDTO.getUrl());
		return socialProfile;
	}
	
	public SocialProfileResponseDTO socialToSocialProfileResponseDTO(SocialProfile socialProfile)
	{
		SocialProfileResponseDTO socialProfileResponseDTO= new SocialProfileResponseDTO();
		socialProfileResponseDTO.setSocialId(socialProfile.getSocialId());
		socialProfileResponseDTO.setProfileType(socialProfile.getProfileType());
		socialProfileResponseDTO.setUrl(socialProfile.getUrl());
		
		return socialProfileResponseDTO;
	}
	
	@Override
	public ResponseEntity<ResponseStructure<String>> addSocialProfileByApplicant(int resumeId,SocialProfileRequestDTO socialProfileRequestDTO,ProfileType profileType) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);
		
		if(optionalResume.isPresent())
		{
			List<SocialProfile> socialProfileList = optionalResume.get().getSocialProfile();
			
			if(socialProfileList.isEmpty())
			{
				SocialProfile socialProfile = socialProfileRequestDtoToSocial(socialProfileRequestDTO);
				socialProfile.setProfileType(profileType);
				socialProfile.setResumeSocial(optionalResume.get());
				
				socialProfileRepo.save(socialProfile);
				
				ResponseStructure<String> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("social Profile object successfully added");
				responseStructure.setData("social Profile object stored in the data base");

				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
			}
			
			else
			{
				int count=0;
				for(SocialProfile socialProfile:socialProfileList)
				{
					if(socialProfile.getProfileType()==profileType)
					{
						count++;
					}
				}
				
				if(count==0)
				{
					SocialProfile socialProfile = socialProfileRequestDtoToSocial(socialProfileRequestDTO);
					socialProfile.setProfileType(profileType);
					socialProfile.setResumeSocial(optionalResume.get());
					
					socialProfileRepo.save(socialProfile);
					
					ResponseStructure<String> responseStructure = new ResponseStructure<>();
					responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
					responseStructure.setMessage("social Profile object successfully added");
					responseStructure.setData("social Profile object stored in the data base");

					return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
				}
				
				else
				{
					throw new DuplicateProfileTypeException("social Progile already exist...cannot add");
				}
			}
			
		}
		
		else
		{
			throw new ResumeNotFoundException("resume with given id does not exists...so cannot add socail profile");
		}
		
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> updateSocialProfileByApplicant(int resumeId,
			SocialProfileRequestDTO socialProfileRequestDTO, ProfileType profileType) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);
		if(optionalResume.isPresent())
		{
			List<SocialProfile> socialProfileList = optionalResume.get().getSocialProfile();
			if(socialProfileList.isEmpty())
			{
				SocialProfile socialProfile = socialProfileRequestDtoToSocial(socialProfileRequestDTO);
				socialProfile.setProfileType(profileType);
				socialProfile.setResumeSocial(optionalResume.get());
				socialProfile.setResumeSocial(optionalResume.get());
				socialProfileRepo.save(socialProfile);
				
				ResponseStructure<String> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("social Profile object successfully added");
				responseStructure.setData("social Profile object stored in the data base");

				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
			}
			else
			{
				for(SocialProfile socialProfileObj:socialProfileList)
				{
					if(socialProfileObj.getProfileType()==profileType)
					{
						socialProfileObj.setUrl(socialProfileRequestDTO.getUrl());
						socialProfileRepo.save(socialProfileObj);
						
						ResponseStructure<String> responseStructure = new ResponseStructure<>();
						responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
						responseStructure.setMessage("social Profile object successfully updated");
						responseStructure.setData("social Profile object stored in the data base");

						return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
					}
					
				}
				//after all iteration no such social profile exist so adding new one
				SocialProfile socialProfile = socialProfileRequestDtoToSocial(socialProfileRequestDTO);
				socialProfile.setProfileType(profileType);
				socialProfile.setResumeSocial(optionalResume.get());
				
				socialProfileRepo.save(socialProfile);
				
				ResponseStructure<String> responseStructure = new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("social Profile object successfully added");
				responseStructure.setData("social Profile object stored in the data base");

				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
			}
		}
		
		else
		{
			throw new ResumeNotFoundException("resume with given id does not exist");
		}
		

	}

	@Override
	public ResponseEntity<ResponseStructure<SocialProfileResponseDTO>> findSocialProfileByType(int resumeId,
			String profileType) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);
		if(optionalResume.isPresent())
		{
			List<SocialProfile> socialProfileList = optionalResume.get().getSocialProfile();
			
			if(!socialProfileList.isEmpty())
			{
				Map<String,String> options= new HashMap<>();
				for(SocialProfile socialProfileObj:socialProfileList)
				{
					if(socialProfileObj.getProfileType()==profileIdentifier(profileType.toUpperCase()))//converting String to profileType
					{
						SocialProfileResponseDTO socialProfileResponseDTO = socialToSocialProfileResponseDTO(socialProfileObj);
						options.put("resume", "/resumes/"+resumeId);
						socialProfileResponseDTO.setResumeOptions(options);
						
						ResponseStructure<SocialProfileResponseDTO> responseStructure = new ResponseStructure<>();
						responseStructure.setStatusCode(HttpStatus.FOUND.value());
						responseStructure.setMessage("social Profile object successfully found");
						responseStructure.setData(socialProfileResponseDTO);

						return new ResponseEntity<ResponseStructure<SocialProfileResponseDTO>>(responseStructure, HttpStatus.FOUND);
					}
				}
				throw new SocialProfileNotFoundException("social peofile of given type does not exist");
			}
			else
			{
				throw new SocialProfileNotFoundException("social peofile of given type does not exist");
			}
			
		}
		else
		{
			throw new ResumeNotFoundException("resume with given id does not exist");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<SocialProfileResponseDTO>> deleteSocialProfileByType(int resumeId,
			String profileType) 
	{
		Optional<Resume> optionalResume = resumeRepo.findById(resumeId);
		if(optionalResume.isPresent())
		{
			List<SocialProfile> socialProfileList = optionalResume.get().getSocialProfile();
			
			if(!socialProfileList.isEmpty())
			{
				Map<String,String> options= new HashMap<>();
				for(SocialProfile socialProfileObj:socialProfileList)
				{
					if(socialProfileObj.getProfileType()==profileIdentifier(profileType.toUpperCase()))//converting String to profileType
					{
						SocialProfileResponseDTO socialProfileResponseDTO = socialToSocialProfileResponseDTO(socialProfileObj);
						options.put("resume", "/resumes/"+resumeId);
						socialProfileResponseDTO.setResumeOptions(options);
						
						socialProfileRepo.deleteById(socialProfileObj.getSocialId());
						
						ResponseStructure<SocialProfileResponseDTO> responseStructure = new ResponseStructure<>();
						responseStructure.setStatusCode(HttpStatus.FOUND.value());
						responseStructure.setMessage("social Profile object successfully deleted");
						responseStructure.setData(socialProfileResponseDTO);

						return new ResponseEntity<ResponseStructure<SocialProfileResponseDTO>>(responseStructure, HttpStatus.FOUND);
					}
				}
				throw new SocialProfileNotFoundException("social peofile of given type does not exist..cannot delete");
			}
			else
			{
				throw new SocialProfileNotFoundException("social peofile of given type does not exist..cannot delete");
			}
			
		}
		else
		{
			throw new ResumeNotFoundException("resume with given id does not exist");
		}
	}
}