package com.team.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;

public interface boardService {
	public int selectCount();
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap);
	public int selectTypeCount(ITboardList boardList);
	public List<ITboardDTO> selectTypeList(ITboardList boardList);
	public void insertBoard(ITboardDTO boardDTO);
	public void incrementBoard(int bidx);
	public ITboardDTO selectBoard(int bidx);
	public int selectGoodChecked(Map<String, String> map);
	public void updateGoodup(Map<String, String> map);
	public void updateGooddown(Map<String, String> map);
	public int selectGoodCount(int bidx);
	public void updateGooddownBoard(int bidx);
	public void updateGoodupBoard(int bidx);
	public void updateBoard(ITboardDTO boardDTO);
	public void deleteBoard(int bidx);
	public void insertreplyBoard(ITboardDTO boardDTO);
	public int selectBoardNextbidx(int category);
	public void callProcedure4sequence(int next_bidx);
	public List<ITboardDTO> selectMainList(int num);
	public void boardList(int currentPage, Model model);
	public void boardSearch(int currentPage, HttpServletRequest request, Model model);
	public void getWriteBoard(int currentPage, Model model, Authentication authentication);
	public void postWriteBoard(ITboardDTO iTboardDTO, Authentication authentication);
	public String incrementBoard(HttpServletRequest request, Model model);
	public void boardContentView(int currentPage, int comment_currentPage, HttpServletRequest request, Model model,
			Authentication authentication);
	public String getUpdateBoard(int currentPage, int bidx, String id, Model model, Authentication authentication);
	public void postUpdateBoard(int currentPage, ITboardDTO iTboardDTO, Model model, Authentication authentication);
	public String deleteBoard(int currentPage, int bidx, String id, Model model, Authentication authentication);
	public void getReplyBoard(int currentPage, Model model, ITboardDTO iTboardDTO, Authentication authentication);
	public void postReplyBoard(int currentPage, Model model, ITboardDTO iTboardDTO, Authentication authentication);
	public Map<String, Integer> clickGood(Map<String, String> map);
}
