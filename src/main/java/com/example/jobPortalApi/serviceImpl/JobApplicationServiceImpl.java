package com.example.jobPortalApi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.jobPortalApi.entity.Job;
import com.example.jobPortalApi.entity.JobApplication;
import com.example.jobPortalApi.entity.User;
import com.example.jobPortalApi.exception.DuplicateJobApplicationException;
import com.example.jobPortalApi.exception.InvalidJobStatusException;
import com.example.jobPortalApi.exception.InvalidUserException;
import com.example.jobPortalApi.exception.JobNotFoundException;
import com.example.jobPortalApi.exception.UserNotFoundException;
import com.example.jobPortalApi.repository.JobApplicationRepo;
import com.example.jobPortalApi.repository.JobRepo;
import com.example.jobPortalApi.repository.UserRepo;
import com.example.jobPortalApi.responseDTO.JobApplicationResponseDTO;
import com.example.jobPortalApi.service.JobApplicationService;
import com.example.jobPortalApi.utility.ResponseStructure;
import com.exmple.jobPortalApi.enums.JobApplicationStatus;
import com.exmple.jobPortalApi.enums.JobStatus;
import com.exmple.jobPortalApi.enums.UserRole;

@Service
public class JobApplicationServiceImpl implements JobApplicationService
{
	@Autowired
	JobApplicationRepo jobApplicationRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	JobRepo jobRepo;
	
	
	public JobApplicationResponseDTO jobApplicationToJobApplicationResponseDTO(JobApplication jobApplication)
	{
		JobApplicationResponseDTO jobApplicationResponseDTO= new JobApplicationResponseDTO();
		jobApplicationResponseDTO.setJobApplicationId(jobApplication.getJobApplicationId());
		jobApplicationResponseDTO.setAppliedDate(jobApplication.getAppliedDate());
		jobApplicationResponseDTO.setStatus(jobApplication.getStatus());
		
		return jobApplicationResponseDTO;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> addResume(int userId, int jobId) 
	{
		Optional<User> optionalUser = userRepo.findById(userId);
		
		if(optionalUser.isPresent())
		{
			User user = optionalUser.get();
			if(user.getUserRole()==UserRole.APPLICANT)
			{
				Optional<Job> optionalJob = jobRepo.findById(jobId);
				
				if(optionalJob.isPresent())
				{
					Job job = optionalJob.get();
					System.out.println(job.getJobId());
					if(job.getJobStatus()==JobStatus.OPEN)
					{
						List<JobApplication> jobApplicationLlist = jobApplicationRepo.findAllByJob(job);
						int count=0;
						for(JobApplication jobApplication:jobApplicationLlist)
						{
							if(jobApplication.getApplicant().getUserId()==userId)
							{
								count++;
							}
						}
						if(count==0)
						{
							JobApplication jobApplication = new JobApplication();
							jobApplication.setStatus(JobApplicationStatus.NOT_VIWED);
							jobApplication.setApplicant(user);
							jobApplication.setJob(job);
							
							jobApplicationRepo.save(jobApplication);
							
							ResponseStructure<String> responseStructure = new ResponseStructure<>();
							responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
							responseStructure.setMessage("job Apllication object successfully added");
							responseStructure.setData("job Apllication successfully submitted");

							return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.ACCEPTED);
						}
						else
						{
							throw new DuplicateJobApplicationException("same applicant cannot add another job application for same job");
						}
					}
					else
					{
						throw new InvalidJobStatusException("job is not not opened to apply....");
					}
				}
				else
				{
					throw new JobNotFoundException("job for given id does not exist");
				}
			}
			else
			{
				throw new InvalidUserException("user type is not valid to add the job application");
			}
		}
		else
		{
			throw new UserNotFoundException("user with id not found");
		}
	}

}
