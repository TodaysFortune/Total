package com.team.teamproject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.service.userinfoService;
import com.team.vo.UserinfoVO;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private userinfoService service;
	
	@RequestMapping(value= {"/","/main"})
	public String main() {
		return "main";
	}
	@RequestMapping(value="/main/signin",method = RequestMethod.GET)
	public String getSignin() {
		System.out.println("controller - Signin-GET");
		return "Signin";
	}
	@RequestMapping(value="/main/signin",method = RequestMethod.POST)
	public String postSignin(UserinfoVO userinfoVO) throws Exception {//커맨드객체
		System.out.println("controller - Signin-POST");
		//System.out.println(userinfoVO);
		service.insertMember(userinfoVO);
		return "redirect:login";//get방식으로 들어감.
	}

	@RequestMapping(value="/main/login",method = RequestMethod.GET)
	public String getLogin(@CookieValue(value="Cookie_userID",required=false) String userId ,Model model) {
		System.out.println("controller - Login-GET");
			model.addAttribute("userid", userId);
			return "Login";
	}
		
	@RequestMapping(value="/main/login",method = RequestMethod.POST)
	public String postLogin(@RequestParam(value="checkbox",required=false) String checked,UserinfoVO userinfoVO,Model model,HttpServletResponse response,HttpServletRequest request) throws Exception {
		System.out.println("controller - Login-POST");
		//id pw 비교
		if((Integer)service.selectMember(userinfoVO)==1) {
		//id pw 가 일치 할경우 , 세션 등록 & 쿠키발급
			
			HttpSession session=request.getSession(); 
			session.setAttribute("Session_userID", userinfoVO.getId());
			
			if(checked!=null) 
				session.setMaxInactiveInterval(-1); //web.xml 에서 먼저 적용되었지만 후에 다시 설정이 가능하다!
			else 
				session.setMaxInactiveInterval(60*30);
			
			Cookie theCookie = new Cookie("Cookie_userID", userinfoVO.getId());
			theCookie.setMaxAge(60*60*24 );
			
			response.addCookie(theCookie);
			
			return "redirect:..";
		}
		else {
		//id pw 가 불일치 할경우 , model에 불일치라는 표현 데이터담아서 전송                   뷰단에서도 model로부터 데이터받아서 처리해야함
			model.addAttribute("success", "no");
			return "Login";
		}
	}
	@RequestMapping(value="/main/logout",method = RequestMethod.POST)
	public String logOut(HttpSession session) {
		System.out.println("controller - logOut");
			session.invalidate();
			return "redirect:..";
	}
	
	//test mapping
	@RequestMapping(value="/test",method = RequestMethod.GET)
	public String test() {
		System.out.println("controller - test");
			return "test";
	}
	//test ajax1
	 @RequestMapping(value="/requestObject", method=RequestMethod.POST)
	    @ResponseBody
	    public String simpleWithObject(HttpServletRequest request) {
	        //필요한 로직 처리
		 	String name=request.getParameter("name");
		 	String age=request.getParameter("age");
		 	
		 	System.out.println("name");
		 	System.out.println("age");
		 	
		 	
		 	
	        return name + age;
	 }
	//test ajax2
	 @RequestMapping(value = "/stringify", 
	    		produces = { MediaType.APPLICATION_JSON_VALUE} , method=RequestMethod.POST)	 
		public @ResponseBody Map<String,Object> getTodayChart(@RequestBody Map<String,Object> map) {     	
	    	System.out.println(map);
	    	return map;
		}
}
