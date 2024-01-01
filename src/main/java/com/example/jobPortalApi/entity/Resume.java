package com.example.jobPortalApi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Resume 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resumeId;
	private String objective;
	
	@OneToOne
	private User userType;
	
	@ManyToMany
	private List<Skills> listSkill;
	
	@OneToMany(mappedBy = "resume")
	private List<Project> projectList;
	
	@OneToMany(mappedBy = "AssocicatedResume")
	private List<Experience> experince;
	
	@OneToMany(mappedBy = "resumeSocial")
	private List<SocialProfile> socialProfile;
	
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	public List<Skills> getListSkill() {
		return listSkill;
	}
	public void setListSkill(List<Skills> listSkill) {
		this.listSkill = listSkill;
	}
	public User getUserType() {
		return userType;
	}
	public void setUserType(User userType) {
		this.userType = userType;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public List<Experience> getExperince() {
		return experince;
	}
	public void setExperince(List<Experience> experince) {
		this.experince = experince;
	}
	public List<SocialProfile> getSocialProfile() {
		return socialProfile;
	}
	public void setSocialProfile(List<SocialProfile> socialProfile) {
		this.socialProfile = socialProfile;
	}
	
	
	
}
