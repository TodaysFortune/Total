package com.team.dao;

import java.util.HashMap;
import java.util.List;

import com.team.dto.ITcommentDTO;

public interface commentDAO {
	void insertComment(ITcommentDTO iTcommentDTO);

	int ITcommentnextval(int bidx);

	int selectCount(int bidx);

	List<ITcommentDTO> selectList(HashMap<String, Integer> hmap);
}
