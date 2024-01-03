package com.example.jobPortalApi.responseDTO;

import java.time.LocalDate;
import java.util.Map;

import com.exmple.jobPortalApi.enums.EducationType;

public class EducationResponseDTO 
{
	private int educationId;
	private EducationType educationType;
	private LocalDate StartDate;
	private LocalDate endDate; 
	private boolean presentStatus;
	private float percentage;
	private float cgpa;
	private String institutename;
	private String location;
	private String streamType;
	private String streamCombination;
	
	private Map<String,String> resumeOptions;
	
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
	public String getStreamType() {
		return streamType;
	}
	public void setStreamType(String streamType) {
		this.streamType = streamType;
	}
	
	public String getStreamCombination() {
		return streamCombination;
	}
	public void setStreamCombination(String streamCombination) {
		this.streamCombination = streamCombination;
	}
	public Map<String, String> getResumeOptions() {
		return resumeOptions;
	}
	public void setResumeOptions(Map<String, String> resumeOptions) {
		this.resumeOptions = resumeOptions;
	}
	
	
}
