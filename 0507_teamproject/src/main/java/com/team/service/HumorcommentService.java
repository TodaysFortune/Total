package com.team.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.team.dto.HumorcommentDTO;

public interface HumorcommentService {
	void insertComment(HumorcommentDTO commentDTO);

	int Humorcommentnextval(int bidx);

	int selectCount(int bidx);

	List<HumorcommentDTO> selectList(HashMap<String, Integer> hmap);

	void deleteComment(int cidx);

	String registerComment(int currentPage, int reply_comment_ref, int comment_currentPage, Authentication authentication,
			Model model,HumorcommentDTO humorcommentDTO);

	void deleteComment(HumorcommentDTO humorcommentDTO, int currentPage, int comment_currentPage, Model model,
			Authentication authentication);
}
