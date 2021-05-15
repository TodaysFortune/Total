package com.team.dao;

import com.team.vo.UserinfoVO;

public interface userinfoDAO {
	 public void insertMember(UserinfoVO userinfoVO) throws Exception;
	 public int selectMember(UserinfoVO userinfoVO) throws Exception;
}
