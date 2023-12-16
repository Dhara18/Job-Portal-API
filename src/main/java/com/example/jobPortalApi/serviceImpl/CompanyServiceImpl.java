package com.example.jobPortalApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Company;
import com.example.jobPortalApi.repository.CompanyRepo;
import com.example.jobPortalApi.requestDTO.CompanyRequestDTO;
import com.example.jobPortalApi.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService
{
	@Autowired
	CompanyRepo companyRepo;
	
	public Company CompantRequestDTOToCompany(CompanyRequestDTO companyRequestDTO)
	{
		Company company = new Company();
		company.setCompanyName(companyRequestDTO.getCompanyName());
		company.setFoundedDate(companyRequestDTO.getFoundedDate());
		company.setBusinessType(companyRequestDTO.getBusinessType());
		company.setContactEmail(companyRequestDTO.getContactEmail());
		company.setContactPhNum(companyRequestDTO.getContactPhNum());
		company.setWebsite(companyRequestDTO.getWebsite());
		
		return company;
	}

	
}
