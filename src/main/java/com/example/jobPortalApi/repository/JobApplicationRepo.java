package com.example.jobPortalApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jobPortalApi.entity.Job;
import com.example.jobPortalApi.entity.JobApplication;
import com.example.jobPortalApi.entity.User;

public interface JobApplicationRepo extends JpaRepository<JobApplication, Integer> 
{
	public List<JobApplication> findAllByJob(Job job);
	
	public List<JobApplication> findAllByApplicant(User user);
	
	@Query("select j from JobApplication j where j.job.jobId=?2 and j.applicant.userId=?1")
	public JobApplication deleteJobApplication(int userId,int jobId);
}
