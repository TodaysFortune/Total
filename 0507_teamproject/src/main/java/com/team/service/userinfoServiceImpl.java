package com.team.service;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpSession;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.team.dao.userinfoDAO;
import com.team.vo.UserinfoVO;

@Service
public class userinfoServiceImpl implements userinfoService{

	@Inject
	private userinfoDAO dao;
	@Inject
	private JavaMailSender mailSender;
	
	@Override
	public void insertMember(UserinfoVO userinfoVO) throws Exception {
		//서비스로직 부분
		System.out.println("userinfoServiceImpl - insertMember");
		dao.insertMember(userinfoVO);
	}

	@Override
	public int selectMember(UserinfoVO userinfoVO) throws Exception {
		System.out.println("userinfoServiceImpl - selectMember");
		return dao.selectMember(userinfoVO);
	}

	@Override
	public String selectName(String userid) {
		System.out.println("userinfoServiceImpl - selectName");
		return dao.selectName(userid);
	}

	@Override
	public int selectIdCount(String data4Check) {
		System.out.println("userinfoServiceImpl - selectIdCount");
		return dao.selectIdCount(data4Check);
	}

	@Override
	public int selectNameCount(String data4Check) {
		System.out.println("userinfoServiceImpl - selectNameCount");
		return dao.selectNameCount(data4Check);
	}

	@Override
	public void createEmailKey(HttpSession session,String usermail) {
		System.out.println("userinfoServiceImpl - emailAuthentication");
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
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	//인증키 생성
	public String getKey(int key_len) {
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
		System.out.println("userinfoServiceImpl - IsSameKey");
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
		System.out.println("userinfoServiceImpl - selectEmailCount");
		return dao.selectEmailCount(usermail);
	}
	
}
