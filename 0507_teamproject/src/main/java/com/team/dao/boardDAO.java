package com.team.dao;

import java.util.HashMap;
import java.util.List;

import com.team.dto.ITboardDTO;

public interface boardDAO {
	public int selectCount();
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap);
}
