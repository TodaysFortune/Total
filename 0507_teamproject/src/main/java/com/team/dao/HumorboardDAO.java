package com.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.team.dto.HumorboardDTO;
import com.team.vo.HumorboardList;

public interface HumorboardDAO {
	public int selectCount();
	public List<HumorboardDTO> selectList(HashMap<String, Integer> hmap);
	public int selectTypeCount(HumorboardList boardList);
	public List<HumorboardDTO> selectTypeList(HumorboardList boardList);
	public void insertBoard(HumorboardDTO boardDTO);
	public void incrementBoard(int bidx);
	public HumorboardDTO selectBoard(int bidx);
	public int selectGoodChecked(Map<String, String> map);
	public void updateGoodup(Map<String, String> map);
	public void updateGooddown(Map<String, String> map);
	public int selectGoodCount(int bidx);
	public void updateGooddownBoard(int bidx);
	public void updateGoodupBoard(int bidx);
	public void updateBoard(HumorboardDTO boardDTO);
	public void deleteBoard(int bidx);
	public void insertreplyBoard(HumorboardDTO boardDTO);
	public int selectBoardNextbidx(int category);
	public void callProcedure4sequence(int next_bidx);
	public List<HumorboardDTO> selectMainList(int num);
}
