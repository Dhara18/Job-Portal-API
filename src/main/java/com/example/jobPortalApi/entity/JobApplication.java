package com.example.jobPortalApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class JobApplication 
{
	@Id
	private int jobApplicationId;
}
