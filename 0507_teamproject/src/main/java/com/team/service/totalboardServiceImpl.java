package com.team.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.dao.totalboardDAO;
import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;

@Service
public class totalboardServiceImpl implements totalboardService{

	@Inject
	private totalboardDAO dao;

	@Override
	public void inserthumorBoard(HumorboardDTO humorboardDTO) {
		System.out.println("totalboardServiceImpl-inserthumorBoard");
		dao.inserthumorBoard(humorboardDTO);
	}

	@Override
	public void updateHumorBoardGood(HashMap<String, Integer> hmap) {
		System.out.println("totalboardServiceImpl-updateHumorBoardGood");
		dao.updateHumorBoardGood(hmap);
	}

	@Override
	public void insertitBoard(ITboardDTO iTboardDTO) {
		System.out.println("totalboardServiceImpl-insertitBoard");
		dao.insertitBoard(iTboardDTO);
	}

	@Override
	public void updateItBoardGood(HashMap<String, Integer> hmap) {
		System.out.println("totalboardServiceImpl-updateItBoardGood");
		dao.updateItBoardGood(hmap);
	}

	@Override
	public void updateHumorBoard(HumorboardDTO humorboardDTO) {
		System.out.println("totalboardServiceImpl-updateHumorBoard");
		dao.updateHumorBoard(humorboardDTO);
	}

	@Override
	public void updateITBoard(ITboardDTO iTboardDTO) {
		System.out.println("totalboardServiceImpl-updateITBoard");
		dao.updateITBoard(iTboardDTO);
	}

	@Override
	public void deleteHumorBoard(int bidx) {
		System.out.println("totalboardServiceImpl-deleteHumorBoard");
		dao.deleteHumorBoard(bidx);
	}

	@Override
	public void deleteITBoard(int bidx) {
		System.out.println("totalboardServiceImpl-deleteITBoard");
		dao.deleteITBoard(bidx);
	}
}
