package com.example.jobPortalApi.entity;

import com.exmple.jobPortalApi.enums.ProfileType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class SocialProfile 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int socialId;
	private ProfileType profileType;
	private String url;
	
	@ManyToOne
	private Resume resumeSocial;
	
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
	public Resume getResumeSocial() {
		return resumeSocial;
	}
	public void setResumeSocial(Resume resumeSocial) {
		this.resumeSocial = resumeSocial;
	}
	
	
}
