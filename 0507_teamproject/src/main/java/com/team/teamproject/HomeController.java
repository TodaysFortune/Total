package com.team.teamproject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String home() {
		return "main";
	}
	
	@RequestMapping("/Signin")
	public String Signin() {
		System.out.println("controller - Signin");
		return "Signin";
	}
	@RequestMapping("/Login")
	public String Login() {
		System.out.println("controller - Login");
		return "Login";
	}
}
