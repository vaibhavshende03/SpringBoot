package com.vs.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MyController {

	@GetMapping("/openProfile")
	public String openProflePage(Model model) {
		model.addAttribute("modelname", "Vaibhav");
		
		return "profile";
	}
	@GetMapping("/openConditionalPage")
	public String openConditionalPage(Model model) {
		int n1=10;
		int n2=20;
		
		model.addAttribute("num1",n1);
		model.addAttribute("num2",n2);
		
		return "conditional";
		
	}
	@GetMapping("/openLoopPage")
	public String openLoopPage(Model model) {
		List<Integer> numbersIntegers=List.of(1,2,3,4,5,6,7,8,9,10);
		model.addAttribute("ModelNumbers", numbersIntegers);
		return "looping";
	}
}
