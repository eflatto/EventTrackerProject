package com.skilldistillery.jobapplications.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JobApplicationService jobService;

	@GetMapping("users")
	public List<User> getAllUsers() {

		List<User> list = userService.findAll();

		return list;
	}
	
	@GetMapping
	public String Welcome() {
		return "Welome to OAuth!";
	}
	
	@GetMapping("/user")
	public Principal user(Principal principal) {
		System.out.println("username : " + principal.getName());
		return principal;
	}
	

	@GetMapping("users/{id}")
	public User getSingleUser(@PathVariable int id) {

		User user = userService.getUserById(id);

		return user;
	}
	@GetMapping("users/{id}/apps")
	public List<JobApplication> getUserJobs(@PathVariable int id) {
		
		User user = userService.getUserById(id);
		List<JobApplication> jobs = user.getJobApplications();
		return jobs;
	} 

	@PostMapping("users")
	public User createUser(@RequestBody User user) {

		user = userService.create(user);

		return user;
	}

	@PutMapping("users/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user,
			HttpServletResponse res) {

		try {
			user = userService.update(user, id);
			if (user == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			user = null;
		}
		return user;
	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable Integer id, HttpServletResponse res) {
		try {
			if (userService.deleteById(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	@GetMapping("users/{name}/keyword")
	public List<User>  findByUserName(@PathVariable String name) {
		 List<User> users = userService.searchByUserName(name);
		 return users;
	}
}
