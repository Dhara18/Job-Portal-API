package com.example.jobPortalApi.requestDTO;

import com.exmple.jobPortalApi.enums.ProfileType;

public class SocialProfileRequestDTO 
{
	private ProfileType profileType;
	private String url;
	public ProfileType getProfileType() {
		return profileType;
	}
	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
