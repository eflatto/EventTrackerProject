package com.skilldistillery.jobapplications.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobapplications.entities.JobApplication;
import com.skilldistillery.jobapplications.services.JobApplicationService;

@RestController
@RequestMapping("api")
public class JobApplicationController {
	@Autowired
	private JobApplicationService appService;
	
	@GetMapping("jobapplications")
	public List<JobApplication> getAllApps (){
		
		List<JobApplication> list= appService.findAll();
		
	
		
		return list;
	}

}
