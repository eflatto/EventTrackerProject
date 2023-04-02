package com.skilldistillery.jobapplications.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapplications.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findById(int id);
}
