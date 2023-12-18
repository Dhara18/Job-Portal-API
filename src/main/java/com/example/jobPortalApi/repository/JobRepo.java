package com.example.jobPortalApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jobPortalApi.entity.Job;

public interface JobRepo extends JpaRepository<Job, Integer> 
{
	@Query("select r from Job r where r.jobTitle LIKE ?1%")
	public List<Job> findByTitle(String jobTitle);
}
