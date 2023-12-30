package com.example.jobPortalApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jobPortalApi.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer>
{
	@Query("select j from Project j where j.resume.resumeId=?1")
	public List<Project> findByresumeId(int id);
}
