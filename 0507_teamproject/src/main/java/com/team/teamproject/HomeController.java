package com.team.teamproject;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.service.userinfoService;
import com.team.vo.UserinfoVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HttpSession session;
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
	public String getLogin(@CookieValue(value="IcApp.userName",required=false) String userId ,Model model) {
		System.out.println("controller - Login-GET");
			model.addAttribute("userid", userId);
			return "Login";
	}
		
	@RequestMapping(value="/Login",method = RequestMethod.POST)
	public String postLogin(UserinfoVO userinfoVO,Model model,HttpServletResponse response) throws Exception {
		System.out.println("controller - Login-POST");
		//id pw 비교
		if((Integer)service.selectMember(userinfoVO)==1) {
		//id pw 가 일치 할경우 , 세션 등록 & 쿠키발급
			
			/*
			session.setAttribute("LOGIN_USER", userinfoVO);
			if(session.isNew())
				System.out.println("Session이 새롭게 생성되었습니다.");
			
			Cookie cookie = new Cookie("key", session.getId());//굳이이렇게 안만들어도  JSESSIONID 를 통해 구분이 되긴함.
			
			System.out.println("session.getId() : "+session.getId() +"입니다");
			
			System.out.println("사용자 아이디는 : "+((UserinfoVO)session.getAttribute("LOGIN_USER")).getId()+" 입니다."  );
			
			cookie.setMaxAge(60*5);
			response.addCookie(cookie);
			*/
			
			//create a cookie for the user name
			Cookie theCookie = new Cookie("IcApp.userName", userinfoVO.getId());
			theCookie.setMaxAge(60*60*24 );
			
			//add the cookie to the response
			response.addCookie(theCookie);
			
			return "main";
			
			//session.getAttribute("LOGIN_USER");
		}
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
