package com.skilldistillery.jobapplications.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobapplications.entities.JobApplication;
import com.skilldistillery.jobapplications.entities.User;
import com.skilldistillery.jobapplications.services.JobApplicationService;
import com.skilldistillery.jobapplications.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class JobApplicationController {
	@Autowired
	private JobApplicationService appService;
	@Autowired
	private UserService userService;

	@GetMapping("jobapplications")
	public List<JobApplication> getAllApps() {

		List<JobApplication> list = appService.findAll();

		return list;
	}

	@GetMapping("jobapplications/{id}")
	public JobApplication getSingleApp(@PathVariable int id, HttpServletResponse res) {
		JobApplication job = appService.getJobById(id);
		if ( job== null) {
			res.setStatus(404);
		}

		return job;
	}
	 @GetMapping("jobapplications/date/{startDate}/{endDate}")
	    public List<JobApplication> getJobApplicationsByDateRange( @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
	    		@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
	        return appService.findByDateAppliedRange(startDate, endDate);
	    }
	
	@GetMapping("jobapplications/sort/salary")
    public List<JobApplication> findAllSortedBySalary() {
        return appService.findAllByOrderBySalaryDesc();
    }
	@GetMapping("jobapplications/count")
	public long countApps() {
		return appService.count();
	}

	@PostMapping("jobapplications")
	public JobApplication createApp(@RequestBody JobApplication jobApp,HttpServletRequest req,
			HttpServletResponse res) {
		try {
		jobApp = appService.create(jobApp);
		res.setStatus(201);
		StringBuffer url = req.getRequestURL();
		url.append("/").append(jobApp.getId());
		res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			jobApp = null;
		}
		return jobApp;
	}
	


	@PutMapping("jobapplications/{id}")
	public JobApplication updateApp(@PathVariable Integer id, @RequestBody JobApplication jobApp,
			HttpServletResponse res) {

		try {
			jobApp = appService.update(jobApp, id);
			if (jobApp == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			jobApp = null;
		}
		return jobApp;
	}

	@DeleteMapping("jobapplications/{id}")
	public void deleteApp(@PathVariable Integer id, HttpServletResponse res) {
		try {
			if (appService.deleteById(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	
	@PostMapping("users/{userId}/jobapplications")
	public JobApplication UserCreatesJobApp(
			@PathVariable Integer userId,
			@RequestBody JobApplication jobApp,
			HttpServletRequest req,
			HttpServletResponse res
	) {
		try {
			User user = userService.getUserById(userId);
			if (user == null) {
				res.setStatus(404);
				return null;
			}
			jobApp.setUser(user);
			jobApp = appService.create(jobApp);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(jobApp.getId()).toString());
			return jobApp;
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			return null;
		}
	}
	

}
