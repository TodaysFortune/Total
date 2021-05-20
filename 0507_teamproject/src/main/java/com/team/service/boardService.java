package com.team.service;

import java.util.HashMap;
import java.util.List;

import com.team.dto.ITboardDTO;

public interface boardService {
	public int selectCount();
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap);
}
