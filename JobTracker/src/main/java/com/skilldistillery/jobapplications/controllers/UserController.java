package com.skilldistillery.jobapplications.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobapplications.entities.User;
import com.skilldistillery.jobapplications.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("users")
	public List<User> getAllUsers() {

		List<User> list = userService.findAll();

		return list;
	}

	@GetMapping("users/{id}")
	public User getSingleUser(@PathVariable int id) {

		User user = userService.getUserById(id);

		return user;
	}

	@PostMapping("users")
	public User createUser(@RequestBody User user) {

		user = userService.create(user);

		return user;
	}

	@PutMapping("users/{id}")
	public User updateApp(@PathVariable Integer id, @RequestBody User user,
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
	public void deleteApp(@PathVariable Integer id, HttpServletResponse res) {
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
}
