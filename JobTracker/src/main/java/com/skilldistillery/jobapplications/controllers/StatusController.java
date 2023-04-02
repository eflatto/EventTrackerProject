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

import com.skilldistillery.jobapplications.entities.Status;
import com.skilldistillery.jobapplications.services.StatusService;

@RestController
@RequestMapping("api")
public class StatusController {
	@Autowired
	private StatusService statusService;

	@GetMapping("status")
	public List<Status> getAllStatus() {

		List<Status> list = statusService.findAll();

		return list;
	}

	@GetMapping("status/{id}")
	public Status getSingleStatus(@PathVariable int id) {

		Status status = statusService.getStatusById(id);

		return status;
	}

	@PostMapping("status")
	public Status createStatus(@RequestBody Status status) {

		status = statusService.create(status);

		return status;
	}

	@PutMapping("status/{id}")
	public Status updateStatus(@PathVariable Integer id, @RequestBody Status status,
			HttpServletResponse res) {

		try {
			status = statusService.update(status, id);
			if (status == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			status = null;
		}
		return status;
	}

	@DeleteMapping("status/{id}")
	public void deleteStatus(@PathVariable Integer id, HttpServletResponse res) {
		try {
			if (statusService.deleteById(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	@GetMapping("status/{name}/keyword")
	public List<Status>  findByStatusName(@PathVariable String name) {
		 List<Status> status = statusService.searchByStatus(name);
		 return status;
	}
}
