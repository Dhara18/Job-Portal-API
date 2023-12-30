package com.example.jobPortalApi.responseDTO;

import java.time.LocalDate;
import java.util.Map;

public class ExperienceResponseDTO 
{
	private int exprId;
	private String description;
	private String organisation;
	private String jobRole;
	private boolean jobStatus;
	private LocalDate startTime;
	private LocalDate endTime;
	private float yearsOfExperience;
	
	private Map<String,String> resumeOptions;
	
	public int getExprId() {
		return exprId;
	}
	public void setExprId(int exprId) {
		this.exprId = exprId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganisation() {
		return organisation;
	}
	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public boolean isJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(boolean jobStatus) {
		this.jobStatus = jobStatus;
	}
	public LocalDate getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}
	public LocalDate getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}
	public Map<String, String> getResumeOptions() {
		return resumeOptions;
	}
	public void setResumeOptions(Map<String, String> resumeOptions) {
		this.resumeOptions = resumeOptions;
	}
	public float getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	
	
}
