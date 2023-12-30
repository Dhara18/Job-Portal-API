package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.Experience;

public interface ExperienceRepo extends JpaRepository<Experience, Integer>
{

}
