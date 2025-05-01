package com.vs.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.vs.springsecurity.model.Users;
import com.vs.springsecurity.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private JWTService jwtService;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private UserRepo userRepo;
public Users register(Users user) {
	return userRepo.save(user); 
}
public String verify(Users user) {
	Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	if(authentication.isAuthenticated()) {
		return jwtService.generateToken(user.getUsername());
		
	}
	return "fail";
}
}
