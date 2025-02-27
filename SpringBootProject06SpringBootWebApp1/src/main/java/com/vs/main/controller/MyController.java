package com.vs.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vs.main.entities.User;
import com.vs.main.services.UserServiceImpl;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private  UserServiceImpl userServiceImpl;

	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/registerForm")
	public String registerForm(@ModelAttribute("user") User user,Model model) {
		
		boolean status= userServiceImpl.regiteruser(user);
		
		if (status) {
			model.addAttribute("successMsg", "User Registered Successfully.");
		}
		else {
			model.addAttribute("errorMsg", "User Not Registered Due To Some Error.");
		}
		
		
		return "register";
	}
	
	@GetMapping("loginpage")
	public String openloginpage(Model model) {
		model.addAttribute("user",new User());
		return "login";
	}
	@PostMapping("LoginForm")
	public String loginForm(@ModelAttribute("user") User user,Model model) {
		
		User validUser=userServiceImpl.loginuser(user.getEmail(), user.getPassword());
		
		if (validUser!=null) {
			model.addAttribute("UserName", validUser.getName());
			return "profile";
		} else {
			model.addAttribute("errorMsg", "Email Id And Password didn't matched");
			return "login"; 
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session= request.getSession();
		if (session!=null) {
			session.invalidate();
		}
		return "login";
	}
}
