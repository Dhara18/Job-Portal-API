package com.example.jobPortalApi.requestDTO;

import java.time.LocalDate;

import com.exmple.jobPortalApi.enums.EducationType;

public class EducationRequestDTO 
{
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
	
	
}
