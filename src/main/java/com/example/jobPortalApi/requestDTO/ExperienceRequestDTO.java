package com.example.jobPortalApi.requestDTO;

import java.time.LocalDate;

public class ExperienceRequestDTO 
{
	private String description;
	private String organisation;
	private String jobRole;
	private boolean jobStatus;
	private LocalDate startTime;
	private LocalDate endTime;
	
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
	
	
}
