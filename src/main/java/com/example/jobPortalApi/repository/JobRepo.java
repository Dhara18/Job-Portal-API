package com.example.jobPortalApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jobPortalApi.entity.Job;

public interface JobRepo extends JpaRepository<Job, Integer> 
{
	@Query("select j from Job j where j.jobTitle LIKE ?1%")
	public List<Job> findByTitle(String jobTitle);
	
	@Query("select j from Job j where j.company.companyId=?1")		//because like cannot take string
	public List<Job> findByCompanyId(int id);
	
	@Query("select j from Job j where j.jobLocation LIKE ?1%")
	public List<Job> findByLocation(String location);
}
