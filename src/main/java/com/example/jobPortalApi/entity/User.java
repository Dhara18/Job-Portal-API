package com.example.jobPortalApi.entity;

import java.util.List;

import com.exmple.jobPortalApi.enums.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User 
{
	@Id
	private int userId;
	private String username;
	private String email;
	private String password;
	private UserRole userRole;				//can take Enum<UserRole> ?
	
	@OneToMany(mappedBy = "user")
	private List<Company> companyList;		//only employee can add companies
	
	@OneToOne(mappedBy = "userType")		//only applicant can have the resume
	private Resume resume;
	
	@OneToMany
	private List<JobApplication> jobApplicationList;		//only applicant can have the resume
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	public List<Company> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}
	
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public List<JobApplication> getJobApplicationList() {
		return jobApplicationList;
	}
	public void setJobApplicationList(List<JobApplication> jobApplicationList) {
		this.jobApplicationList = jobApplicationList;
	}
	
	
}
