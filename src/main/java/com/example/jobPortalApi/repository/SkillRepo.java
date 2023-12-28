package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jobPortalApi.entity.Skills;


public interface SkillRepo extends JpaRepository<Skills, Integer>
{
	@Query("select s from Skills s where s.skill LIKE %?1%")
	public Skills findSkillByName(String skills);
}
