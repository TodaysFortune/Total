package com.team.service;

import com.team.vo.UserinfoVO;

public interface userinfoService {
	public void insertMember(UserinfoVO userinfoVO) throws Exception;
	public int selectMember(UserinfoVO userinfoVO) throws Exception;
	public String selectName(String userid);
	public int selectIdCount(String data4Check);
	public int selectNameCount(String data4Check);
}
