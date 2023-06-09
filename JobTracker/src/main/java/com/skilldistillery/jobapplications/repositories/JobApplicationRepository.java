package com.skilldistillery.jobapplications.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapplications.entities.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {
	public JobApplication findById(int id);
	
	List<JobApplication> findAllByOrderBySalaryDesc();
	List<JobApplication> findByDateAppliedBetween(LocalDate startDate, LocalDate endDate);

}
