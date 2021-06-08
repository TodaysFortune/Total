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
	@RequestMapping(value= "/main/signin",method = RequestMethod.GET)
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
	@RequestMapping(value = "/main/data_confirm", 
	        produces = { MediaType.APPLICATION_JSON_VALUE} , method=RequestMethod.POST)     
	    public @ResponseBody Map<String,Integer> IsUnique(@RequestBody Map<String,String> map,HttpSession session) {         
	        System.out.println("UserController-IsUnique");
	        String dataType=map.get("dataType");
	        String data4Check=map.get("data4Check");
	        Map<String,Integer> response_map=new HashMap<String,Integer>();
	        if(dataType.equals("id")) {							//id check
	        	int id_count=service.selectIdCount(data4Check);
	        	if(id_count==0) 
	        		response_map.put("name",1);
	        	else 
	        		response_map.put("name",0);
	        }else if(dataType.equals("name")){					//name check
	        	int name_count=service.selectNameCount(data4Check);
	        	if(name_count==0) 
	        		response_map.put("name",1);
	        	else 
	        		response_map.put("name",0);
	        }else if(dataType.equals("email")) { 				// email key check
	        	int signal=service.IsSameKey(session,data4Check);
	        	if(signal==0)//동일키아님
	        		response_map.put("name",0);
	        	else if(signal==1)//동일키임
	        		response_map.put("name",1);
	        	else//세션맨료
	        		response_map.put("name",-1);
	        }
	        return response_map;
	    }

	@RequestMapping(value="/main/signin/createEmailKey",
			produces = { MediaType.APPLICATION_JSON_VALUE},method=RequestMethod.POST)
	public @ResponseBody Map<String,Integer> emailAuthentication(@RequestBody Map<String,String> map,HttpSession session){
		System.out.println("UserController - emailAuthentication");
		String usermail=map.get("usermail");
		Map<String,Integer> response_map=new HashMap<String, Integer>();
		
		if(service.selectEmailCount(usermail)==1) {
			response_map.put("name", 0);
		}
		else {
			service.createEmailKey(session,usermail);
			response_map.put("name", 1);
		}
		return response_map;
	}
		
	
}
