package com.team.dao;

import java.util.HashMap;
import java.util.List;

import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;
import com.team.dto.TotalboardDTO;
import com.team.vo.TotalboardList;

public interface totalboardDAO {

	void inserthumorBoard(HumorboardDTO humorboardDTO);

	void updateHumorBoardGood(HashMap<String, Integer> hmap);

	void insertitBoard(ITboardDTO iTboardDTO);

	void updateItBoardGood(HashMap<String, Integer> hmap);

	void updateHumorBoard(HumorboardDTO humorboardDTO);

	void updateITBoard(ITboardDTO iTboardDTO);

	void deleteHumorBoard(int bidx);

	void deleteITBoard(int bidx);

	List<TotalboardDTO> selectNewList(int num);

	List<TotalboardDTO> selectGoodList(int num);

	void incrementItBoard(int bidx);

	void incrementHumorBoard(int bidx);

	int selectTypeCount(TotalboardList totalboardList);

	List<TotalboardDTO> selectTypeList(TotalboardList totalboardList);

}
