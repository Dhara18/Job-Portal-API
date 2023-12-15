package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> 
{

}
