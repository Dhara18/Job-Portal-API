package com.example.jobPortalApi.service;

import org.springframework.http.ResponseEntity;

import com.example.jobPortalApi.requestDTO.SocialProfileRequestDTO;
import com.example.jobPortalApi.responseDTO.SocialProfileResponseDTO;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.ProfileType;

public interface SocialProfileService 
{
	public ResponseEntity<ResponseStructure<String>> addSocialProfileByApplicant(int resumeId,SocialProfileRequestDTO socialProfileRequestDTO,ProfileType profileType);

	public ResponseEntity<ResponseStructure<String>> updateSocialProfileByApplicant(int resumeId,SocialProfileRequestDTO socialProfileRequestDTO, ProfileType profileType);

	public ResponseEntity<ResponseStructure<SocialProfileResponseDTO>> findSocialProfileByType(int resumeId,String profileType);

}
