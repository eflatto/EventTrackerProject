package com.skilldistillery.jobapplications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapplications.entities.JobApplication;
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
		return null;
	}

	@Override
	public JobApplication create(JobApplication job) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplication update(JobApplication job, int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int jobId) {
		// TODO Auto-generated method stub
		return false;
	}

}
