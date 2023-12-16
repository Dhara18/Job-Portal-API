package com.example.jobPortalApi.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Company;
import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.exception.InvalidUserException;
import com.example.jobPortalApi.exception.UserNotFoundException;
import com.example.jobPortalApi.repository.CompanyRepo;
import com.example.jobPortalApi.repository.UserRepo;
import com.example.jobPortalApi.requestDTO.CompanyRequestDTO;
import com.example.jobPortalApi.responseDTO.CompanyResponseDTO;
import com.example.jobPortalApi.service.CompanyService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.UserRole;

@Service
public class CompanyServiceImpl implements CompanyService
{
	@Autowired
	CompanyRepo companyRepo;
	
	@Autowired
	UserRepo userRepo;
	
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
	
	public CompanyResponseDTO CompanyToCompanyResponseDTO(Company company)
	{
		CompanyResponseDTO companyResponseDTO= new CompanyResponseDTO();
		companyResponseDTO.setCompanyId(company.getCompanyId());
		companyResponseDTO.setCompanyName(company.getCompanyName());
		companyResponseDTO.setFoundedDate(company.getFoundedDate());
		companyResponseDTO.setBusinessType(company.getBusinessType());
		companyResponseDTO.setContactEmail(company.getContactEmail());
		companyResponseDTO.setContactPhNum(company.getContactPhNum());
		companyResponseDTO.setWebsite(company.getWebsite());
		return companyResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addCompany(CompanyRequestDTO companyRequestDTO,int userId) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);
		
		if(optionalUser.isPresent())
		{
			User user=optionalUser.get();
			UserRole userRole = user.getUserRole();
			
			if(userRole==UserRole.EMPLOYER)
			{
				Company company = CompantRequestDTOToCompany(companyRequestDTO);
				company.setUser(user);
				
				companyRepo.save(company);
				
				ResponseStructure<String> responseStructure=new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("Company object saved successfully");
				responseStructure.setData("Company object successfully added");
				
				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
			}
			else
			{
				throw new InvalidUserException("invalid user role ...only authorized persons can add companies");
			}
		}
		else
		{
			throw new UserNotFoundException("given user does not exist in the user database");
		}
	}
}
