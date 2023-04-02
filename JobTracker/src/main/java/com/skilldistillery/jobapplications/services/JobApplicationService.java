package com.skilldistillery.jobapplications.services;

import java.util.List;

import com.skilldistillery.jobapplications.entities.JobApplication;

public interface JobApplicationService {
	List<JobApplication> findAll();
	JobApplication getJobById(int jobId);
	JobApplication create(JobApplication job);
	JobApplication update(JobApplication job,int jobId);
	boolean deleteById(int jobId);
	List<JobApplication> findAllByOrderBySalaryDesc();
	long count();

	

}
