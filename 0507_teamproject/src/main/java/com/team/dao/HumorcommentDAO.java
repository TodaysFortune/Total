package com.team.dao;

import java.util.HashMap;
import java.util.List;

import com.team.dto.HumorcommentDTO;

public interface HumorcommentDAO {
	void insertComment(HumorcommentDTO commentDTO);

	int Humorcommentnextval(int bidx);

	int selectCount(int bidx);

	List<HumorcommentDTO> selectList(HashMap<String, Integer> hmap);

	void deleteComment(int cidx);
}
