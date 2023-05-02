package com.skilldistillery.jobapplications.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapplications.entities.Status;
import com.skilldistillery.jobapplications.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findById(int id);
	public List<User>findByUsernameLike(String namePatt);
	User findByUsername(String username);
}
