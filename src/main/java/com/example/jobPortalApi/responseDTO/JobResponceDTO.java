package com.example.jobPortalApi.responseDTO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class JobResponceDTO 
{
	private int jobId;
	private String jobTitle;
	private long jobPackage;
	private String jobLocation;
	private List<String> jobSkills;
	private String jobExpirienceRequired;
	
	private Map<String,String>options;
	
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
