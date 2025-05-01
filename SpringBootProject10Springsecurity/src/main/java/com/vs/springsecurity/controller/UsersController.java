package com.vs.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vs.springsecurity.model.Users;
import com.vs.springsecurity.service.UserService;

@RestController
public class UsersController {
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

@Autowired
	private UserService userService;
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		System.out.println(user);
		return userService.verify(user);
	}
}
