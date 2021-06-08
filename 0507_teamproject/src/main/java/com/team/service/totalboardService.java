package com.team.service;

import java.util.HashMap;

import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;

public interface totalboardService {

	void inserthumorBoard(HumorboardDTO humorboardDTO);

	void updateHumorBoardGood(HashMap<String, Integer> hmap);

	void insertitBoard(ITboardDTO iTboardDTO);

	void updateItBoardGood(HashMap<String, Integer> hmap);

	void updateHumorBoard(HumorboardDTO humorboardDTO);

	void updateITBoard(ITboardDTO iTboardDTO);

	void deleteHumorBoard(int bidx);

	void deleteITBoard(int bidx);

}
