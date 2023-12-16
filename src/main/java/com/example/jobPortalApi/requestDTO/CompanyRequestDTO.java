package com.example.jobPortalApi.requestDTO;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.exmple.jobPortalApi.enums.BusinessType;

@Component
public class CompanyRequestDTO 
{
	private int companyId;
	private String companyName;
	private Date foundedDate;
	private BusinessType businessType;
	private String contactEmail;
	private long contactPhNum;
	private String website;
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
	
	
}
