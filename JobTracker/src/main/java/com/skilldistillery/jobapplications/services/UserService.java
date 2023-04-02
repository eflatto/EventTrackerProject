package com.skilldistillery.jobapplications.services;

import java.util.List;

import com.skilldistillery.jobapplications.entities.JobApplication;
import com.skilldistillery.jobapplications.entities.Status;
import com.skilldistillery.jobapplications.entities.User;

public interface UserService {
	List<User> findAll();
	User getUserById(int userId);
	User create(User user);
	User update(User user,int userId);
	boolean deleteById(int userId);
	public List<User> searchByUserName(String keyword);
	public List<JobApplication> showUserJobApps(int userId);

	

}
