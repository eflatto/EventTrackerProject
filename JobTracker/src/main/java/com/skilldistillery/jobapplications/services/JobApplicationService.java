package com.skilldistillery.jobapplications.services;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.jobapplications.entities.JobApplication;
import com.skilldistillery.jobapplications.entities.User;

public interface JobApplicationService {
	List<JobApplication> findAll();
	JobApplication getJobById(int jobId);
	JobApplication create(JobApplication job,User user);
	JobApplication update(JobApplication job, int jobId,User user);
	boolean deleteById(int jobId);
	List<JobApplication> findAllByOrderBySalaryDesc();
	long count();
	List<JobApplication> findByDateAppliedRange(LocalDate startDate, LocalDate endDate);

	

	

}
