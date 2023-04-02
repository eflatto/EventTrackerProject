package com.skilldistillery.jobapplications.services;

import java.util.List;

import com.skilldistillery.jobapplications.entities.User;

public interface UserService {
	List<User> findAll();
	User getUserById(int userId);
	User create(User user);
	User update(User user,int userId);
	boolean deleteById(int userId);
	

}
