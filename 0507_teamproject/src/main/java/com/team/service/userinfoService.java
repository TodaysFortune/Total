package com.team.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.team.vo.UserinfoVO;

public interface userinfoService {
	public void insertMember(UserinfoVO userinfoVO) throws Exception;
	public int selectMember(UserinfoVO userinfoVO) throws Exception;
	public String selectName(String userid);
	public int selectIdCount(String data4Check);
	public int selectNameCount(String data4Check);
	public void createEmailKey(HttpSession session,String usermail);
	public int IsSameKey(HttpSession session,String data4Check);
	public int selectEmailCount(String usermail);
	public void getLogin(Model model, String userId);
	public Map<String, Integer> IsUnique(Map<String, String> map, HttpSession session);
	public Map<String, Integer> emailAuthentication(Map<String, String> map, HttpSession session);
}
