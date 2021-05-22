package com.team.service;

import java.util.HashMap;
import java.util.List;

import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;

public interface boardService {
	public int selectCount();
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap);
	public int selectTypeCount(ITboardList iTboardList);
	public List<ITboardDTO> selectTypeList(ITboardList iTboardList);
}
