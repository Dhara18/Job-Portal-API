package com.example.jobPortalApi.responseDTO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.jobPortalApi.entity.Skills;
import com.exmple.jobPortalApi.enums.JobStatus;

@Component
public class JobResponceDTO 
{
	private int jobId;
	private String jobTitle;
	private long jobPackage;
	private String jobLocation;
	private String jobExpirienceRequired;
	private List<Skills> skills;
	private Map<String,String>options;
	private JobStatus jobStatus;
	
	public Map<String, String> getOptions() {
		return options;
	}
	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
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
	
	public List<Skills> getSkills() {
		return skills;
	}
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}
	public String getJobExpirienceRequired() {
		return jobExpirienceRequired;
	}
	public void setJobExpirienceRequired(String jobExpirienceRequired) {
		this.jobExpirienceRequired = jobExpirienceRequired;
	}
	public JobStatus getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}
	
}
