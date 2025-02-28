package com.vs.main.controllers;

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
	UserServiceImpl userServiceImpl;

	@GetMapping("/registerPage")
	public String openRegPage(Model model) {
		model.addAttribute("user",new User());
		return "registration";
	}

	
	@PostMapping("/RegisterForm")
	public String RegisterForm(@ModelAttribute("user") User user,Model model) {
		
		
			
			boolean status=	userServiceImpl.registerUser(user);
			
			if (status) {
			model.addAttribute("SuccessMsg","User Registerd Successfully.");
			}
			else {
				model.addAttribute("ErrorMsg", "User Not Registered Due to some Error");
			}
				
			
		return "registration";
	}

	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@PostMapping("/LoginForm")
	public String LoginForm(@ModelAttribute("user") User user,Model model) {
		
	User validUser=	userServiceImpl.loginUser(user.getEmail(), user.getPassword());
	
	if (validUser!=null) {
		model.addAttribute("ModelName",validUser.getName());
		return "profile";
	}
		
	else {
		model.addAttribute("ErrorMsg","Email and Password Not Match");
		return "login";
	}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session=request.getSession(false);
		
		if (session!=null) {
			session.invalidate();
		}
		return "redirect:/loginPage";
	}
}
