package com.vs.main.repository;

import com.vs.main.entities.User;

public interface DbOperations {

	public User getUserDetails(Long id);
	public void insertUser(User user);
	public void updateUser(Long id,String name);
	public void deleteUser(Long id);

	
}
