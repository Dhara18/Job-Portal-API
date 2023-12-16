package com.example.jobPortalApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Resume 
{
	@Id
	private int resumeId;
	private String resumename;
	private String jobRole;
	
	@OneToOne
	private User userType;
	
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getResumename() {
		return resumename;
	}
	public void setResumename(String resumename) {
		this.resumename = resumename;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public User getUserType() {
		return userType;
	}
	public void setUserType(User userType) {
		this.userType = userType;
	}
	
	
}
