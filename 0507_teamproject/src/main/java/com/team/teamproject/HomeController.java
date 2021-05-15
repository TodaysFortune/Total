package com.team.teamproject;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	@RequestMapping(value="/Signin",method = RequestMethod.GET)
	public String getSignin() {
		System.out.println("controller - Signin-GET");
		return "Signin";
	}
	@RequestMapping(value="/Signin",method = RequestMethod.POST)
	public String postSignin(UserinfoVO userinfoVO) throws Exception {//커맨드객체
		System.out.println("controller - Signin-POST");
		//System.out.println(userinfoVO);
		service.insertMember(userinfoVO);
		return "redirect:Login";
	}
	@RequestMapping(value="/Login",method = RequestMethod.GET)
	public String getLogin() {
		System.out.println("controller - Login-GET");
		return "Login";
	}
	@RequestMapping(value="/Login",method = RequestMethod.POST)
	public String postLogin(UserinfoVO userinfoVO,Model model) throws Exception {
		System.out.println("controller - Login-POST");
		//id pw 비교
		if((Integer)service.selectMember(userinfoVO)==1)
		//id pw 가 일치 할경우 , 세션 등록 & 쿠키발급
			return "redirect:main";
		else {
		//id pw 가 불일치 할경우 , model에 불일치라는 표현 데이터담아서 전송                   뷰단에서도 model로부터 데이터받아서 처리해야함
			model.addAttribute("success", "no");
			return "Login";
		}
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("controller - test");
		return "test";
	}
}
