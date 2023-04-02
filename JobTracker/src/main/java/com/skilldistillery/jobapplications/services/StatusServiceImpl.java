package com.skilldistillery.jobapplications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapplications.entities.Status;
import com.skilldistillery.jobapplications.repositories.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired 
	StatusRepository repo;
	@Override
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Status getStatusById(int usId) {
		// TODO Auto-generated method stub
		return repo.findById(usId);
	}

	@Override
	public Status create(Status status) {
		// TODO Auto-generated method stub
		if(status==null) {
			throw new IllegalArgumentException("status is null");
		}
		return repo.saveAndFlush(status);
	}

	@Override
	public Status update(Status status, int statusId) {
		// TODO Auto-generated method stub
		Status existingStatus = repo.findById(statusId);
		if(existingStatus!= null) {
			existingStatus.setStatusName(status.getStatusName());
			
			return repo.saveAndFlush(existingStatus);
		}
		return null;
	}

	@Override
	public boolean deleteById(int statusId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Status statusToDelete = repo.findById(statusId);
		if (statusToDelete != null) {
			repo.delete(statusToDelete);
			deleted = true;
		}
		return deleted;
		
	}
	@Override
	public List<Status> searchByStatus(String status) {
		status = "%" + status + "%";
		return repo.findBystatusNameLike(status);
	}


}
