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
	
	@OneToMany
	private List<Company> companyList;
	@OneToOne
	private List<Resume> resumeList;
	@OneToMany
	private List<JobApplication> jobApplicationList;
	
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
	public List<Resume> getResumeList() {
		return resumeList;
	}
	public void setResumeList(List<Resume> resumeList) {
		this.resumeList = resumeList;
	}
	public List<JobApplication> getJobApplicationList() {
		return jobApplicationList;
	}
	public void setJobApplicationList(List<JobApplication> jobApplicationList) {
		this.jobApplicationList = jobApplicationList;
	}
	
	
}
