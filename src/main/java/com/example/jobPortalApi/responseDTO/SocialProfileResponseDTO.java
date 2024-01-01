package com.example.jobPortalApi.responseDTO;

import java.util.Map;

import com.exmple.jobPortalApi.enums.ProfileType;

public class SocialProfileResponseDTO 
{
	private int socialId;
	private ProfileType profileType;
	private String url;
	
	private Map<String,String> resumeOptions;

	public int getSocialId() {
		return socialId;
	}

	public void setSocialId(int socialId) {
		this.socialId = socialId;
	}

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

	public Map<String, String> getResumeOptions() {
		return resumeOptions;
	}

	public void setResumeOptions(Map<String, String> resumeOptions) {
		this.resumeOptions = resumeOptions;
	}
	
	
}
