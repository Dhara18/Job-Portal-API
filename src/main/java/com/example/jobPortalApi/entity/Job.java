package com.example.jobPortalApi.entity;

import java.util.List;

import com.exmple.jobPortalApi.enums.JobStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Job 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobId;
	private String jobTitle;//designation
	private long jobPackage;//ctc
	private String jobLocation;
	private String jobExpirienceRequired;
	private JobStatus jobStatus;
	
	@ManyToOne
	private Company company;
	
	@ManyToMany
	private List<Skills> skills;
	
	@OneToMany(mappedBy = "job")
	private List<JobApplication> jobApplicationlist;
	
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
	public List<JobApplication> getJobApplicationlist() {
		return jobApplicationlist;
	}
	public void setJobApplicationlist(List<JobApplication> jobApplicationlist) {
		this.jobApplicationlist = jobApplicationlist;
	}
	
}
