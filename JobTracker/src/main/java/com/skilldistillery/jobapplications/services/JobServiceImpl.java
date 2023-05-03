package com.skilldistillery.jobapplications.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapplications.entities.JobApplication;
import com.skilldistillery.jobapplications.entities.User;
import com.skilldistillery.jobapplications.repositories.JobApplicationRepository;

@Service
public class JobServiceImpl implements JobApplicationService {

	@Autowired 
	JobApplicationRepository repo;
	@Override
	public List<JobApplication> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public JobApplication getJobById(int jobId) {
		// TODO Auto-generated method stub
		return repo.findById(jobId);
	}

	@Override
	public JobApplication create(JobApplication job,User user) {
		// TODO Auto-generated method stub
		if(job==null) {
			throw new IllegalArgumentException("Job is null");
		}
		job.setUser(user);
		return repo.saveAndFlush(job);
	}

	@Override
	public JobApplication update(JobApplication job, int jobId) {
		// TODO Auto-generated method stub
		JobApplication existingJob = repo.findById(jobId);
		if(existingJob!= null) {
			existingJob.setCompanyName(job.getCompanyName());
			existingJob.setDateApplied(job.getDateApplied());
			existingJob.setJobDescription(job.getJobDescription());
			existingJob.setJobTitle(job.getJobTitle());
			existingJob.setNotes(job.getNotes());
			existingJob.setSalary(job.getSalary());

			return repo.saveAndFlush(existingJob);
		}
		return null;
	}

	@Override
	public boolean deleteById(int jobId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		JobApplication appToDelete = repo.findById(jobId);
		if (appToDelete != null) {
			repo.delete(appToDelete);
			deleted = true;
		}
		return deleted;
		
	}
	@Override
	public List<JobApplication> findAllByOrderBySalaryDesc() {
	    return repo.findAllByOrderBySalaryDesc();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return repo.count();
	}

	@Override
	public List<JobApplication> findByDateAppliedRange(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
	 return repo.findByDateAppliedBetween(startDate, endDate);
	}


}
