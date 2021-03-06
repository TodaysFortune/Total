package com.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;

public interface boardDAO {
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
}
