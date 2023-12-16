package com.example.jobPortalApi.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Company;
import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.exception.CompanyNotFoundException;
import com.example.jobPortalApi.exception.InvalidUserException;
import com.example.jobPortalApi.exception.UserNotFoundException;
import com.example.jobPortalApi.repository.CompanyRepo;
import com.example.jobPortalApi.repository.UserRepo;
import com.example.jobPortalApi.requestDTO.CompanyRequestDTO;
import com.example.jobPortalApi.responseDTO.CompanyResponseDTO;
import com.example.jobPortalApi.service.CompanyService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.BusinessType;
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
	public ResponseEntity<ResponseStructure<String>> addCompany(CompanyRequestDTO companyRequestDTO,int userId,BusinessType businessType) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);

		if(optionalUser.isPresent())
		{
			User user=optionalUser.get();
			UserRole userRole = user.getUserRole();

			if(userRole==UserRole.EMPLOYER)							//EMPLOER is a static member....so calssName.memberName
			{
				Company company = CompantRequestDTOToCompany(companyRequestDTO);
				company.setUser(user);
				company.setBusinessType(businessType);

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

	@Override
	public ResponseEntity<ResponseStructure<CompanyResponseDTO>> findById(int id) 
	{
		Optional<Company> optionalCompany = companyRepo.findById(id);

		if(optionalCompany.isPresent())
		{
			Company company = optionalCompany.get();
			CompanyResponseDTO companyResponseDTO = CompanyToCompanyResponseDTO(company);

			ResponseStructure<CompanyResponseDTO> responseStructure=new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Company object saved successfully");
			responseStructure.setData(companyResponseDTO);

			return new ResponseEntity<ResponseStructure<CompanyResponseDTO>>(responseStructure, HttpStatus.FOUND);
		}
		else
		{
			throw new CompanyNotFoundException("company with given id does not exist");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> updateCompany(CompanyRequestDTO companyRequestDTO, int userId,BusinessType businessType,int companyId) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);

		if(optionalUser.isPresent())
		{
			User user = optionalUser.get();

			if(user.getUserRole()==UserRole.EMPLOYER)
			{
				Optional<Company> optionalCompany = companyRepo.findById(companyId);

				if(optionalCompany.isPresent())
				{
					Company company=optionalCompany.get();

					company.setCompanyName(companyRequestDTO.getCompanyName());
					company.setFoundedDate(companyRequestDTO.getFoundedDate());
					company.setContactEmail(companyRequestDTO.getContactEmail());
					company.setContactPhNum(companyRequestDTO.getContactPhNum());

					company.setUser(user);
					company.setBusinessType(businessType);

					companyRepo.save(company);

					ResponseStructure<String> responseStructure=new ResponseStructure<>();
					responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
					responseStructure.setMessage("Company object found successfully");
					responseStructure.setData("Company object successfully updated");

					return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
				}
				else
				{
					throw new CompanyNotFoundException("company with id does not exist...so cannot update");
				}	
			}
			else
			{
				throw new InvalidUserException("invalid user role ...only authorized persons can updated companies");
			}
		}
		else
		{
			throw new UserNotFoundException("given user does not exist in the user database");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<CompanyResponseDTO>> deleteById(int userId, int companyId) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);

		if(optionalUser.isPresent())
		{
			User user = optionalUser.get();

			if(user.getUserRole()==UserRole.EMPLOYER)
			{
				Optional<Company> optionalCompany = companyRepo.findById(companyId);

				if(optionalCompany.isPresent())
				{
					Company company=optionalCompany.get();

					CompanyResponseDTO companyResponseDTO = CompanyToCompanyResponseDTO(company);

					companyRepo.deleteById(companyId);

					ResponseStructure<CompanyResponseDTO> responseStructure=new ResponseStructure<>();
					responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
					responseStructure.setMessage("Company object deleted successfully by user with Id "+userId);
					responseStructure.setData(companyResponseDTO);

					return new ResponseEntity<ResponseStructure<CompanyResponseDTO>>(responseStructure, HttpStatus.ACCEPTED);
				}
				else
				{
					throw new CompanyNotFoundException("company with id does not exist...so cannot delete");
				}	
			}
			else
			{
				throw new InvalidUserException("invalid user role ...only authorized persons can delete companies");
			}
		}
		else
		{
			throw new UserNotFoundException("given user does not exist in the user database");
		}
	}


}
