package com.example.jobPortalApi.responseDTO;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ResumeResponseDTO 
{
	private int resumeId;
	private String objective;
	
	private Map<String,String> options;
	
	public Map<String, String> getOptions() {
		return options;
	}
	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
	public int getResumeId() {
		return resumeId;
	}
	public void setResumeId(int resumeId) {
		this.resumeId = resumeId;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	
	
}
