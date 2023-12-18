package com.example.jobPortalApi.requestDTO;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JobRequestDTO 
{
	private String jobTitle;
	private long jobPackage;
	private String jobLocation;
	private List<String> jobSkills;
	private String jobExpirienceRequired;
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public long getJobPackage() {
		return jobPackage;
	}
	public void setJobPackage(long jobPackage) {
		this.jobPackage = jobPackage;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public List<String> getJobSkills() {
		return jobSkills;
	}
	public void setJobSkills(List<String> jobSkills) {
		this.jobSkills = jobSkills;
	}
	public String getJobExpirienceRequired() {
		return jobExpirienceRequired;
	}
	public void setJobExpirienceRequired(String jobExpirienceRequired) {
		this.jobExpirienceRequired = jobExpirienceRequired;
	}
	
}
