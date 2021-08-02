package com.team.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.dao.userinfoDAO;
import com.team.vo.UserinfoVO;

@Service
public class userinfoServiceImpl implements userinfoService,UserDetailsService {

	@Inject
	private userinfoDAO dao;
	@Inject
	private JavaMailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(userinfoServiceImpl.class);
	
	@Override
	public void insertMember(UserinfoVO userinfoVO) throws Exception {
		LOG.debug("insertMember");
		dao.insertMember(userinfoVO);
	}

	@Override
	public int selectMember(UserinfoVO userinfoVO) throws Exception {
		LOG.debug("selectMember");
		return dao.selectMember(userinfoVO);
	}

	@Override
	public String selectName(String userid) {
		LOG.debug("selectName");
		return dao.selectName(userid);
	}

	@Override
	public int selectIdCount(String data4Check) {
		LOG.debug("selectIdCount");
		return dao.selectIdCount(data4Check);
	}

	@Override
	public int selectNameCount(String data4Check) {
		LOG.debug("selectNameCount");
		return dao.selectNameCount(data4Check);
	}

	@Override
	public void createEmailKey(HttpSession session,String usermail) {
		LOG.debug("emailAuthentication");
		String strKey=getKey(8);
		session.setAttribute("authenticationKey", strKey);
		session.setMaxInactiveInterval(60*3);
		MimeMessage mail=mailSender.createMimeMessage();
		String htmlStr="<h2>안녕하세요 TodaysFortune 웹사이트 입니다! </h2><br><br>" 
				+ "<h3>회원님의 가입을 환영합니다<h3>"
				+ "<p>이메일 인증 코드 : " 
				+ "<span style='color:red;'>"+strKey+"</span></p>"
				+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
		try {
			mail.setSubject("[TodaysFortune] 인증메일입니다.", "utf-8");
			mail.setText(htmlStr,"utf-8","html");
			mail.addRecipient(RecipientType.TO,new InternetAddress(usermail));//의심
			mailSender.send(mail);
		} catch (MessagingException e) {}

	}

	//인증키 생성
	public String getKey(int key_len) {
		LOG.debug("getKey");
		Random rnd=new Random();
		StringBuffer buf=new StringBuffer();
		for(int i=1;i<=key_len;i++) {
			if(rnd.nextBoolean())
				buf.append((char)(rnd.nextInt(26)+65));   // 0~25(26개) + 65 
			else
				buf.append(rnd.nextInt(10));
		}
		return buf.toString();
	}

	@Override
	public int IsSameKey(HttpSession session,String data4Check) {
		LOG.debug("IsSameKey");
		try {
			String authenticationKey=(String)session.getAttribute("authenticationKey");
			session.invalidate();
			if(authenticationKey.equals(data4Check)) {
				return 1;
			}
			else return 0;
		}catch(Exception e) {
			return -1;
		}
		
	}

	@Override
	public int selectEmailCount(String usermail) {
		LOG.debug("selectEmailCount");
		return dao.selectEmailCount(usermail);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOG.debug("loadUserByUsername");
		UserinfoVO user =dao.getUserById(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

	@Override
	public void getLogin(Model model, String userId) {
		LOG.debug("getLogin");
		model.addAttribute("userid", userId);
	}

	@Override
	public Map<String, Integer> IsUnique(Map<String, String> map, HttpSession session) {
		String dataType=map.get("dataType");
		String data4Check=map.get("data4Check");
		Map<String,Integer> response_map=new HashMap<String,Integer>();
		if(dataType.equals("id")) {							//id check
			int id_count=this.selectIdCount(data4Check);
			if(id_count==0) 
				response_map.put("name",1);
			else 
				response_map.put("name",0);
		}else if(dataType.equals("name")){					//name check
			int name_count=this.selectNameCount(data4Check);
			if(name_count==0) 
				response_map.put("name",1);
			else 
				response_map.put("name",0);
		}else if(dataType.equals("email")) { 				// email key check
			int signal=this.IsSameKey(session,data4Check);
			if(signal==0)//동일키아님
				response_map.put("name",0);
			else if(signal==1)//동일키임
				response_map.put("name",1);
			else//세션맨료
				response_map.put("name",-1);
		}
		return response_map;
	}

	@Override
	public Map<String, Integer> emailAuthentication(Map<String, String> map, HttpSession session) {
		String usermail=map.get("usermail");
		Map<String,Integer> response_map=new HashMap<String, Integer>();

		if(this.selectEmailCount(usermail)==1) {
			response_map.put("name", 0);
		}
		else {
			this.createEmailKey(session,usermail);
			response_map.put("name", 1);
		}
		return response_map;
	}
}
