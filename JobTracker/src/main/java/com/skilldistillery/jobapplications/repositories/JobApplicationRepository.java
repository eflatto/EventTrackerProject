package com.skilldistillery.jobapplications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapplications.entities.JobApplication;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

}
