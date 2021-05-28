package com.team.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;

public interface boardService {
	public int selectCount();
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap);
	public int selectTypeCount(ITboardList iTboardList);
	public List<ITboardDTO> selectTypeList(ITboardList iTboardList);
	public void insertBoard(ITboardDTO iTboardDTO);
	public void incrementBoard(int bidx);
	public ITboardDTO selectBoard(int bidx);
	public int selectGoodChecked(Map<String, String> map);
	public void updateGoodup(Map<String, String> map);
	public void updateGooddown(Map<String, String> map);
	public int selectGoodCount(int bidx);
	public void updateGooddownBoard(int bidx);
	public void updateGoodupBoard(int bidx);
}
