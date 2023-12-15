package com.example.jobPortalApi.requestDTO;

import org.springframework.stereotype.Component;

import com.exmple.jobPortalApi.enums.UserRole;

@Component
public class UserRequestDTO 
{
	private String username;
	private String email;
	private String password;
	private UserRole userRole;
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
	
	
}
