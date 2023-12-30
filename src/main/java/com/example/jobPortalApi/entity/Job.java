package com.example.jobPortalApi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Job 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private String jobTitle;
	private long jobPackage;
	private String jobLocation;
	private List<String> jobSkills;		//@ElementCollection should be added on top of list of strings
	private String jobExpirienceRequired;
	
	@ManyToOne
	private Company company;
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
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
