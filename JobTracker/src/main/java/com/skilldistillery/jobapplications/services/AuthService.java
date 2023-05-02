package com.skilldistillery.jobapplications.services;

import com.skilldistillery.jobapplications.entities.User;
public interface AuthService {
	public User register(User user);
	public User getUserByUsername(String username);
}
