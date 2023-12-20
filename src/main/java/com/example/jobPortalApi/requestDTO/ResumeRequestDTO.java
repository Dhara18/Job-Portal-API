package com.example.jobPortalApi.requestDTO;

import org.springframework.stereotype.Component;

@Component
public class ResumeRequestDTO 
{
	private int resumeId;
	private String objective;
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
