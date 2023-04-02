package com.skilldistillery.jobapplications.services;

import java.util.List;

import com.skilldistillery.jobapplications.entities.Status;

public interface StatusService {
	List<Status> findAll();

	Status getStatusById(int statusId);

	Status create(Status status);

	Status update(Status status, int statusId);

	boolean deleteById(int statusId);

}
