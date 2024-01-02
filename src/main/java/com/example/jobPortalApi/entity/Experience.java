package com.example.jobPortalApi.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Experience 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exprId;
	private String description;
	private String organisation;
	private String jobRole;
	private boolean jobStatus;
	private LocalDate startTime;
	private LocalDate endTime;
	private float yearsOfExperience;
	
	@ManyToOne
	private Resume AssocicatedResume;

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

	public LocalDate getStartTime() 
	{
		return startTime;
	}

	public void setStartTime(LocalDate startTime) 
	{
		this.startTime = startTime;
		if(endTime!=null)
		{
			setYearsOfExperience();
		}
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) 
	{
		if(jobStatus==true)
		{
			this.endTime =null;
			
			if(getStartTime()!=null)
			{
				setYearsOfExperience();
			}
		}
		else
		{
			this.endTime = endTime;
			
			if(getStartTime()!=null)
			{
				setYearsOfExperience();
			}
		}
	}

	public float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience() 
	{
		if(endTime==null)
		{
			float year=java.time.LocalDate.now().getYear()-startTime.getYear();
			System.out.println(year);
			float month=java.time.LocalDate.now().getMonthValue()-startTime.getMonthValue();
			System.out.println(month);
			this.yearsOfExperience=year+month/12;
			System.out.println(this.yearsOfExperience);
		}
		
		else
		{
			float year=endTime.getYear()-startTime.getYear();
			System.out.println(year);
			float month=endTime.getMonthValue()-startTime.getMonthValue();
			System.out.println(month);
			this.yearsOfExperience=year+month/12;
			System.out.println(this.yearsOfExperience);
		}
	}

	public Resume getAssocicatedResume() {
		return AssocicatedResume;
	}

	public void setAssocicatedResume(Resume associcatedResume) {
		AssocicatedResume = associcatedResume;
	}

	
}
