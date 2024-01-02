package com.example.jobPortalApi.entity;

import java.time.LocalDate;

import com.exmple.jobPortalApi.enums.EducationType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Education 
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	private EducationType educationType;
	private LocalDate StartDate;
	private LocalDate endDate; 
	private boolean presentStatus;
	private float percentage;
	private float cgpa;
	private String institutename;
	private String location;
	private String degreeType;
	private String degreeStream;
	
	@ManyToOne
	private Resume eduResume;

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

	public LocalDate getStartDate() {
		return StartDate;
	}

	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public boolean isPresentStatus() {
		return presentStatus;
	}

	public void setPresentStatus(boolean presentStatus) {
		this.presentStatus = presentStatus;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}

	public String getInstitutename() {
		return institutename;
	}

	public void setInstitutename(String institutename) {
		this.institutename = institutename;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDegreeType() {
		return degreeType;
	}

	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}

	public String getDegreeStream() {
		return degreeStream;
	}

	public void setDegreeStream(String degreeStream) {
		this.degreeStream = degreeStream;
	}

	public Resume getEduResume() {
		return eduResume;
	}

	public void setEduResume(Resume eduResume) {
		this.eduResume = eduResume;
	}
	
	
}
