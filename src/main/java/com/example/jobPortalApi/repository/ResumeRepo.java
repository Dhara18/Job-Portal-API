package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.Resume;

public interface ResumeRepo extends JpaRepository<Resume, Integer>
{

}
