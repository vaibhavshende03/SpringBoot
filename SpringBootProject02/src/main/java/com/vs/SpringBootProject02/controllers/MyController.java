package com.vs.SpringBootProject02.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
@GetMapping("/")
@ResponseBody
	public String getMessage() {
		
		return "Hello Guy's";
	}
}
