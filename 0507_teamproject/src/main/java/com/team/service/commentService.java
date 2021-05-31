package com.team.service;

import java.util.HashMap;
import java.util.List;

import com.team.dto.ITcommentDTO;

public interface commentService {
	void insertComment(ITcommentDTO iTcommentDTO);

	int ITcommentnextval(int bidx);

	int selectCount(int bidx);

	List<ITcommentDTO> selectList(HashMap<String, Integer> hmap);
}
