package com.example.jobPortalApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Skills 	//here uni directional mapping done...so resume has skills but skill do not have resume
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	private String skill;
	
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
	
	
}
