package com.example.jobPortalApi.requestDTO;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CompanyRequestDTO 
{
	private String companyName;
	private Date foundedDate;
	private String contactEmail;
	private long contactPhNum;
	private String website;
	
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
	
	
}
