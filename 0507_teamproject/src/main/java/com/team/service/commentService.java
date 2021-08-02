package com.team.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.team.dto.ITcommentDTO;

public interface commentService {
	void insertComment(ITcommentDTO commentDTO);

	int ITcommentnextval(int bidx);

	int selectCount(int bidx);

	List<ITcommentDTO> selectList(HashMap<String, Integer> hmap);

	void deleteComment(int cidx);

	String registerComment(int currentPage, int reply_comment_ref, int comment_currentPage, Authentication authentication,
			Model model, ITcommentDTO iTcommentDTO);

	void deleteComment(ITcommentDTO iTcommentDTO, int currentPage, int comment_currentPage, Model model,
			Authentication authentication);
}
