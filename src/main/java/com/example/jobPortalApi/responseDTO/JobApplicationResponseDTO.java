package com.example.jobPortalApi.responseDTO;

import java.time.LocalDate;
import java.util.Map;

import com.exmple.jobPortalApi.enums.JobApplicationStatus;

public class JobApplicationResponseDTO 
{
	private int jobApplicationId;
	private LocalDate appliedDate;
	private JobApplicationStatus status;
	
	private Map<String,String> userOptions;
	
	private Map<String,String> jobOptions;
	
	public int getJobApplicationId() {
		return jobApplicationId;
	}
	public void setJobApplicationId(int jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}
	public LocalDate getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}
	public JobApplicationStatus getStatus() {
		return status;
	}
	public void setStatus(JobApplicationStatus status) {
		this.status = status;
	}
	public Map<String, String> getUserOptions() {
		return userOptions;
	}
	public void setUserOptions(Map<String, String> userOptions) {
		this.userOptions = userOptions;
	}
	public Map<String, String> getJobOptions() {
		return jobOptions;
	}
	public void setJobOptions(Map<String, String> jobOptions) {
		this.jobOptions = jobOptions;
	}
	
	
}
