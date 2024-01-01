package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jobPortalApi.entity.SocialProfile;

public interface SocialProfileRepo extends JpaRepository<SocialProfile, Integer>
{
	@Query("select j from SocialProfile j where j.profileType LIKE ?1%")
	public SocialProfile findByProfileType(int profileValue);

}
