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

	@Inject
	private userinfoService service;

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value= "/signin",method = RequestMethod.GET)
	public String getSignin() {
		LOG.debug("getSignin");
		return "Signin";
	}
	@RequestMapping(value="/signin",method = RequestMethod.POST)
	public String postSignin(UserinfoVO userinfoVO) throws Exception {//커맨드객체
		LOG.debug("postSignin");
		service.insertMember(userinfoVO);
		return "redirect:/login";//절대경로 get 방식으로 들어감
	}

	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String getLogin(@CookieValue(value="Cookie_userID",required=false) String userId ,Model model) {
		LOG.debug("getLogin");
		service.getLogin(model,userId);
		return "Login";
	}

	/*
	 로그아웃은 핸들러처리
	 */
	
	@RequestMapping(value = "/data_confirm", 
			produces = { MediaType.APPLICATION_JSON_VALUE} , method=RequestMethod.POST)     
	public @ResponseBody Map<String,Integer> IsUnique(@RequestBody Map<String,String> map,HttpSession session) {  
		LOG.debug("IsUnique");
		return service.IsUnique(map,session);
	}

	@RequestMapping(value="/signin/createEmailKey",
			produces = { MediaType.APPLICATION_JSON_VALUE},method=RequestMethod.POST)
	public @ResponseBody Map<String,Integer> emailAuthentication(@RequestBody Map<String,String> map,HttpSession session){
		LOG.debug("emailAuthentication");
		return service.emailAuthentication(map,session);
	}
}
