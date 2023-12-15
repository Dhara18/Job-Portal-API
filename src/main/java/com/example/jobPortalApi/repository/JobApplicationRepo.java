package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.JobApplication;

public interface JobApplicationRepo extends JpaRepository<JobApplication, Integer> 
{

}
