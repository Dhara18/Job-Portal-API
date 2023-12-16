package com.example.jobPortalApi.entity;

import java.sql.Date;

import com.exmple.jobPortalApi.enums.BusinessType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Company 
{
	@Id
	private int companyId;
	private String companyName;
	private Date foundedDate;
	private BusinessType businessType;
	private String contactEmail;
	private long contactPhNum;
	private String website;
	
	@ManyToOne
	private User user;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getFoundedDate() {
		return foundedDate;
	}

	public void setFoundedDate(Date foundedDate) {
		this.foundedDate = foundedDate;
	}

	public BusinessType getBusinessType() {
		return businessType;
	}

	public void setBusinessType(BusinessType businessType) {
		this.businessType = businessType;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public long getContactPhNum() {
		return contactPhNum;
	}

	public void setContactPhNum(long contactPhNum) {
		this.contactPhNum = contactPhNum;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
