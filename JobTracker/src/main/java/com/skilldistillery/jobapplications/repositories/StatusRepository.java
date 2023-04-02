package com.skilldistillery.jobapplications.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobapplications.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
	public Status findById(int id);
	public List<Status>findBystatusNameLike(String namePatt);
}
