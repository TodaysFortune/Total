package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;
import com.team.dto.TotalboardDTO;
import com.team.vo.TotalboardList;

public interface totalboardService {

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

	void welcome(Model model);

	void connectBoard(Model model, int bidx);

	void totalBoard(int itcurrentPage, int humorcurrentPage, int totalcurrentPage, HttpServletRequest request,
			Model model);

}
