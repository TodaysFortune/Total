package com.team.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.dao.userinfoDAO;
import com.team.vo.UserinfoVO;

@Service
public class userinfoServiceImpl implements userinfoService{

	@Inject
	private userinfoDAO dao;
	
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

	
}
