package com.team.service;

import java.util.HashMap;
import java.util.List;

import com.team.dto.ITcommentDTO;

public interface commentService {
	void insertComment(ITcommentDTO commentDTO);

	int ITcommentnextval(int bidx);

	int selectCount(int bidx);

	List<ITcommentDTO> selectList(HashMap<String, Integer> hmap);

	void deleteComment(int cidx);
}
