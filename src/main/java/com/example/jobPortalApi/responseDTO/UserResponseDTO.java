package com.example.jobPortalApi.responseDTO;

import org.springframework.stereotype.Component;

import com.exmple.jobPortalApi.enums.UserRole;

@Component
public class UserResponseDTO 
{
	private int userId;
	private String username;
	private String email;
	private UserRole userRole;
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
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	
}
