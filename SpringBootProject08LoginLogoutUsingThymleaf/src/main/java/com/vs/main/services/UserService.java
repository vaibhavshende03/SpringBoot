package com.vs.main.services;

import com.vs.main.entities.User;

public interface UserService {

	public boolean registerUser(User user);
	
	public User loginUser(String email,String password);
}
