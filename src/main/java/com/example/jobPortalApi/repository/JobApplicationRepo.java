package com.example.jobPortalApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.Job;
import com.example.jobPortalApi.entity.JobApplication;
import com.example.jobPortalApi.entity.User;

public interface JobApplicationRepo extends JpaRepository<JobApplication, Integer> 
{
	public List<JobApplication> findAllByJob(Job job);
	
	public List<JobApplication> findAllByApplicant(User user);
	
}
