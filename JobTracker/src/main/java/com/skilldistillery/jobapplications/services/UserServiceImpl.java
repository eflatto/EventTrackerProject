package com.skilldistillery.jobapplications.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobapplications.entities.User;
import com.skilldistillery.jobapplications.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserRepository repo;
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getUserById(int usId) {
		// TODO Auto-generated method stub
		return repo.findById(usId);
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		if(user==null) {
			throw new IllegalArgumentException("user is null");
		}
		return repo.saveAndFlush(user);
	}

	@Override
	public User update(User user, int userId) {
		// TODO Auto-generated method stub
		User existingUser = repo.findById(userId);
		if(existingUser!= null) {
			existingUser.getUsername();
			existingUser.getPassword();
			
			return repo.saveAndFlush(existingUser);
		}
		return null;
	}

	@Override
	public boolean deleteById(int userId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		User userToDelete = repo.findById(userId);
		if (userToDelete != null) {
			repo.delete(userToDelete);
			deleted = true;
		}
		return deleted;
		
	}

}