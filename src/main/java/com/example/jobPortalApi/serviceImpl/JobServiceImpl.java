package com.example.jobPortalApi.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Company;
import com.example.jobPortalApi.entity.Job;
import com.example.jobPortalApi.exception.CompanyNotFoundException;
import com.example.jobPortalApi.exception.JobNotFoundException;
import com.example.jobPortalApi.repository.CompanyRepo;
import com.example.jobPortalApi.repository.JobRepo;
import com.example.jobPortalApi.requestDTO.JobRequestDTO;
import com.example.jobPortalApi.responseDTO.JobResponceDTO;
import com.example.jobPortalApi.service.JobService;
import com.example.jobPortalApi.utility.ResponseStructure;

@Service
public class JobServiceImpl implements JobService
{
	@Autowired
	JobRepo jobRepo;

	@Autowired
	CompanyRepo companyRepo;

	public Job JobRequestDTOToJob(JobRequestDTO jobRequestDTO)
	{

		Job job = new Job();
		job.setJobTitle(jobRequestDTO.getJobTitle());
		job.setJobPackage(jobRequestDTO.getJobPackage());
		job.setJobLocation(jobRequestDTO.getJobLocation());
		job.setJobExpirienceRequired(jobRequestDTO.getJobExpirienceRequired());

		return job;

	}

	public JobResponceDTO jobToJobResponceDTO(Job job)
	{
		JobResponceDTO jobResponceDTO =new JobResponceDTO();
		jobResponceDTO.setJobId(job.getJobId());
		jobResponceDTO.setJobTitle(job.getJobTitle());
		jobResponceDTO.setJobPackage(job.getJobPackage());
		jobResponceDTO.setJobLocation(job.getJobLocation());
		jobResponceDTO.setJobExpirienceRequired(job.getJobExpirienceRequired());

		return jobResponceDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addjob(int comapnyId,JobRequestDTO jobRequestDto) 
	{
		Optional<Company> optionalCompany = companyRepo.findById(comapnyId);

		if(optionalCompany.isPresent())
		{
			Company company=optionalCompany.get();

			Job job = JobRequestDTOToJob(jobRequestDto);
			job.setCompany(company);

			jobRepo.save(job);

			ResponseStructure<String> responseStructure= new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("job entity is added successfully");
			responseStructure.setData("job entity is added to data base");

			return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);

		}

		else
		{
			throw new CompanyNotFoundException("company does not exist..to add the job");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobTitle(String jobTitle) 
	{
		List<Job> jobList = jobRepo.findByTitle(jobTitle);

		List<JobResponceDTO> jobResponceDTOList= new ArrayList<>();

		if(!jobList.isEmpty())
		{
			Map<String,String> companyOptions= new HashMap<>();
			String url=null;

			for(Job job:jobList)
			{
				JobResponceDTO jobResponceDTO = jobToJobResponceDTO(job);

				url="/companies/"+job.getCompany().getCompanyId();

				System.out.println(url);
				companyOptions.put("companies", url);

				jobResponceDTO.setOptions(companyOptions);

				jobResponceDTOList.add(jobResponceDTO);

				url=null;
			}

			ResponseStructure<List<JobResponceDTO>> responseStructure= new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("job entity is found successfully");
			responseStructure.setData(jobResponceDTOList);

			return new ResponseEntity<ResponseStructure<List<JobResponceDTO>>>(responseStructure, HttpStatus.FOUND);

		}

		else
		{
			throw new JobNotFoundException("job with given job title not found");
		}


	}

	@Override
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findJobByCompanyId(int companyId) 
	{
		Optional<Company> optionalCompany = companyRepo.findById(companyId);

		if(optionalCompany.isPresent())
		{
			List<Job> jobList = jobRepo.findByCompanyId(companyId);

			List<JobResponceDTO> jobResponceDTOList=new ArrayList<>();
			Map<String,String> optionalJob=new HashMap<>();

			String url=null;
			for(Job job:jobList)
			{
				JobResponceDTO jobResponceDTO=jobToJobResponceDTO(job);

				url="/companies/"+companyId;
				optionalJob.put("companies", url);

				jobResponceDTO.setOptions(optionalJob);

				jobResponceDTOList.add(jobResponceDTO);

				url=null;
			}

			ResponseStructure<List<JobResponceDTO>> responseStructure= new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("job entities with company id found successfully");
			responseStructure.setData(jobResponceDTOList);

			return new ResponseEntity<ResponseStructure<List<JobResponceDTO>>>(responseStructure, HttpStatus.FOUND);
		}

		else
		{
			throw new JobNotFoundException("job with given company id not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<JobResponceDTO>>> findByJobLocation(String jobLocation) 
	{
		List<Job> jobList = jobRepo.findByLocation(jobLocation);

		List<JobResponceDTO> jobResponceDTOList= new ArrayList<>();

		if(!jobList.isEmpty())
		{
			Map<String,String> companyOptions= new HashMap<>();
			String url=null;

			for(Job job:jobList)
			{
				JobResponceDTO jobResponceDTO = jobToJobResponceDTO(job);

				url="/companies/"+job.getCompany().getCompanyId();

				System.out.println(url);
				companyOptions.put("companies", url);

				jobResponceDTO.setOptions(companyOptions);

				jobResponceDTOList.add(jobResponceDTO);

				url=null;
			}

			ResponseStructure<List<JobResponceDTO>> responseStructure= new ResponseStructure<>();
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("job entities with given location found successfully");
			responseStructure.setData(jobResponceDTOList);

			return new ResponseEntity<ResponseStructure<List<JobResponceDTO>>>(responseStructure, HttpStatus.FOUND);

		}

		else
		{
			throw new JobNotFoundException("job with given job location not found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> updateJobById(int jobId, int companyId,JobRequestDTO jobRequestDto) 
	{
		Optional<Company> opytionalCompany = companyRepo.findById(companyId);

		if(opytionalCompany.isPresent())
		{

			Optional<Job> optionalJob = jobRepo.findById(jobId);

			if(optionalJob.isPresent())
			{
				Job job = optionalJob.get();
				job.setJobTitle(jobRequestDto.getJobTitle());
				job.setJobPackage(jobRequestDto.getJobPackage());
				job.setJobLocation(jobRequestDto.getJobLocation());
				job.setJobExpirienceRequired(jobRequestDto.getJobExpirienceRequired());

				jobRepo.save(job);

				ResponseStructure<String> responseStructure= new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("job entity is updated successfully");
				responseStructure.setData("job entity is updated to data base");

				return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);

			}

			else
			{
				throw new JobNotFoundException("job does not exist with given id to update");
			}
		}
		else
		{
			throw new CompanyNotFoundException("there is no company to update the job");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<JobResponceDTO>> deleteJobByCompanyId(int companyId, int jobId) 
	{
		Optional<Company> opytionalCompany = companyRepo.findById(companyId);

		if(opytionalCompany.isPresent())
		{

			Optional<Job> optionalJob = jobRepo.findById(jobId);
			String url=null;
			if(optionalJob.isPresent())
			{
				Map<String,String> options= new HashMap<>();
				url="/companies/"+companyId;
				options.put("companies", url);

				Job job = optionalJob.get();
				JobResponceDTO jobResponceDTO=jobToJobResponceDTO(job);
				jobResponceDTO.setOptions(options);

				jobRepo.deleteById(jobId);

				ResponseStructure<JobResponceDTO> responseStructure= new ResponseStructure<>();
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMessage("job entity is deleted successfully");
				responseStructure.setData(jobResponceDTO);

				return new ResponseEntity<ResponseStructure<JobResponceDTO>>(responseStructure, HttpStatus.ACCEPTED);

			}

			else
			{
				throw new JobNotFoundException("job does not exist with given id to delete");
			}
		}
		else
		{
			throw new CompanyNotFoundException("there is no company to delete the job");
		}
	}


}
