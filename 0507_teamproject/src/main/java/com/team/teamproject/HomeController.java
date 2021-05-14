package com.team.teamproject;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team.service.userinfoService;
import com.team.vo.UserinfoVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private userinfoService service;
	
	@RequestMapping("/")
	public String home() {
		return "main";
	}
	@RequestMapping(value="/Signin",method = RequestMethod.GET)
	public String getSignin() {
		System.out.println("controller - Signin");
		return "Signin";
	}
	@RequestMapping(value="/Signin",method = RequestMethod.POST)
	public String postSignin(UserinfoVO userinfoVO) throws Exception {//커맨드객체
		System.out.println("controller - Signin");
		System.out.println(userinfoVO);
		service.insertMember(userinfoVO);
		return "redirect:Login";
	}
	@RequestMapping("/Login")
	public String Login() {
		System.out.println("controller - Login");
		return "Login";
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("controller - test");
		return "test";
	}
}
