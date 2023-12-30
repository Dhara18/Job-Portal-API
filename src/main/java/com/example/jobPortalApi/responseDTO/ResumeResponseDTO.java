package com.example.jobPortalApi.responseDTO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.jobPortalApi.entity.Skills;

@Component
public class ResumeResponseDTO 
{
	private int resumeId;
	private String objective;
	
	private List<Skills> listSkill;
	
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
	public List<Skills> getListSkill() {
		return listSkill;
	}
	public void setListSkill(List<Skills> listSkill) {
		this.listSkill = listSkill;
	}
	
}
