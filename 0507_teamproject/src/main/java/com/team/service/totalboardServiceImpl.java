package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.dao.totalboardDAO;
import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;
import com.team.dto.TotalboardDTO;
import com.team.vo.TotalboardList;

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

	@Override
	public List<TotalboardDTO> selectNewList(int num) {
		System.out.println("totalboardServiceImpl-selectNewList");
		return dao.selectNewList(num);
	}

	@Override
	public List<TotalboardDTO> selectGoodList(int num) {
		System.out.println("totalboardServiceImpl-selectGoodList");
		return dao.selectGoodList(num);
	}

	@Override
	public void incrementItBoard(int bidx) {
		System.out.println("totalboardServiceImpl-incrementItBoard");
		dao.incrementItBoard(bidx);
	}

	@Override
	public void incrementHumorBoard(int bidx) {
		System.out.println("totalboardServiceImpl-incrementHumorBoard");
		dao.incrementHumorBoard(bidx);
	}

	@Override
	public int selectTypeCount(TotalboardList totalboardList) {
		System.out.println("totalboardServiceImpl-selectTypeCount");
		return dao.selectTypeCount(totalboardList);
	}

	@Override
	public List<TotalboardDTO> selectTypeList(TotalboardList totalboardList) {
		System.out.println("totalboardServiceImpl-selectTypeList");
		return dao.selectTypeList(totalboardList);
	}
}
