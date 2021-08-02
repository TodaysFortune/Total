package com.team.dao;

import com.team.vo.UserinfoVO;

public interface userinfoDAO {
	 public void insertMember(UserinfoVO userinfoVO) throws Exception;
	 public int selectMember(UserinfoVO userinfoVO) throws Exception;
	public String selectName(String userid);
	public int selectIdCount(String data4Check);
	public int selectNameCount(String data4Check);
	public int selectEmailCount(String usermail);
	public UserinfoVO getUserById(String username);
}
