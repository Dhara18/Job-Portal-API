package com.example.jobPortalApi.responseDTO;

import java.util.List;
import java.util.Map;

public class SkillResponseDTO 
{
	private int skillId;
	private String skill;
	
	private Map<String,List<String>> userOptions;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Map<String, List<String>> getUserOptions() {
		return userOptions;
	}

	public void setUserOptions(Map<String, List<String>> userOptions) {
		this.userOptions = userOptions;
	}

	
}
