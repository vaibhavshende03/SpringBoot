package com.vs.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vs.main.entities.User;
import com.vs.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean registerUser(User user) {
		boolean status=false;
		
		try {
			if (user!=null) {
				userRepository.save(user);
				status=true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return status;
			
		}
		
		return status;
	}

	@Override
	public User loginUser(String email, String password) {
		 User validUser=userRepository.findByEmail(email);
		 
		 if (validUser!=null && validUser.getPassword().equals(password)) {
			return validUser;
		}
		
		
		return null;
	}

}
