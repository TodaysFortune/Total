package com.team.dao;

import java.util.HashMap;
import java.util.List;

import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;

public interface boardDAO {
	public int selectCount();
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap);
	public int selectTypeCount(ITboardList iTboardList);
	public List<ITboardDTO> selectTypeList(ITboardList iTboardList);
	public void insertBoard(ITboardDTO iTboardDTO);
}
