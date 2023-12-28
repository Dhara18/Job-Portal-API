package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer>
{

}
