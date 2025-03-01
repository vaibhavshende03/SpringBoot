package com.vs.main.services;

import java.util.List;
import java.util.Optional;

import com.vs.main.entities.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUserDetails(int id) ;
	public User updateUserDetails(int id,User newUser);
	public User deleteUser(int id);

}
