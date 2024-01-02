package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.Education;

public interface EducationRepo extends JpaRepository<Education, Integer>
{

}
