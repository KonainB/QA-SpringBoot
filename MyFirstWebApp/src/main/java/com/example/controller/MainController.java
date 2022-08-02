package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value="/welcome")
	public String welcome()
	{
		return "welcome";
	}
	@RequestMapping(value="/home")
	public String home()
	{
		return "home";
	}
}
