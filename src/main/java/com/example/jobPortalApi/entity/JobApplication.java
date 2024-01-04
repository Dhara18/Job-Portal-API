package com.example.jobPortalApi.entity;

import java.time.LocalDate;

import com.exmple.jobPortalApi.enums.JobApplicationStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JobApplication 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobApplicationId;
	private LocalDate appliedDate=java.time.LocalDate.now();
	private JobApplicationStatus status;
	
	@ManyToOne
	private User applicant;
	@ManyToOne
	private Job job;
	
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
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	
}
