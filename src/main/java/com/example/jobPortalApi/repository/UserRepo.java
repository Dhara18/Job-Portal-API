package com.example.jobPortalApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobPortalApi.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>
{

}
