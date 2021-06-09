package com.team.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.dao.boardDAO;
import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;

@Service
public class boardServiceImpl implements boardService {
	@Inject
	private boardDAO dao;

	@Override
	public int selectCount() {
		//서비스로직 부분
		System.out.println("boardServiceImpl - selectCount");
		return dao.selectCount();
	}

	@Override
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap) {
		//서비스로직 부분
		System.out.println("boardServiceImpl - selectList");
		return dao.selectList(hmap);
	}

	@Override
	public int selectTypeCount(ITboardList boardList) {
		
		System.out.println("boardServiceImpl - selectTypeCount");
		if(boardList.getSearchText().length()==0 ||
				boardList.getSearchType().equals("recommendedNumber"))//검색창에 아무것도 안썻을 경우 || 추천글을 눌렀을 경우
			return dao.selectCount();//일반 게시판첫페이지를 호출할 경우와 같은 효과
		return dao.selectTypeCount(boardList);
	}

	@Override
	public List<ITboardDTO> selectTypeList(ITboardList boardList) {
		System.out.println("boardServiceImpl - selectTypeList");
		return dao.selectTypeList(boardList);
	}

	@Override
	public void insertBoard(ITboardDTO boardDTO) {
		System.out.println("boardServiceImpl - insertBoard");
		dao.insertBoard(boardDTO);
	}

	@Override
	public void incrementBoard(int bidx) {
		System.out.println("boardServiceImpl - incrementBoard");
		dao.incrementBoard(bidx);
	}

	@Override
	public ITboardDTO selectBoard(int bidx) {
		System.out.println("boardServiceImpl - selectBoard");
		return dao.selectBoard(bidx);
	}

	@Override
	public int selectGoodChecked(Map<String, String> map) {
		System.out.println("boardServiceImpl - selectGoodChecked");
		return dao.selectGoodChecked(map);
	}
	@Override
	public void updateGoodup(Map<String, String> map) {
		System.out.println("boardServiceImpl - updateGoodup");
		dao.updateGoodup(map);
	}

	@Override
	public void updateGooddown(Map<String, String> map) {
		System.out.println("boardServiceImpl - updateGooddown");
		dao.updateGooddown(map);
	}

	@Override
	public int selectGoodCount(int bidx) {
		System.out.println("boardServiceImpl - selectGoodCount");
		return dao.selectGoodCount(bidx);
	}

	@Override
	public void updateGooddownBoard(int bidx) {
		System.out.println("boardServiceImpl - updateGooddownBoard");
		dao.updateGooddownBoard(bidx);
	}

	@Override
	public void updateGoodupBoard(int bidx) {
		System.out.println("boardServiceImpl - updateGoodupBoard");
		dao.updateGoodupBoard(bidx);
	}

	@Override
	public void updateBoard(ITboardDTO boardDTO) {
		System.out.println("boardServiceImpl - updateBoard");
		dao.updateBoard(boardDTO);
		
	}

	@Override
	public void deleteBoard(int bidx) {
		System.out.println("boardServiceImpl - deleteBoard");
		dao.deleteBoard(bidx);
	}


	@Override
	public void insertreplyBoard(ITboardDTO boardDTO) {
		System.out.println("boardServiceImpl - insertreplyBoard");
		dao.insertreplyBoard(boardDTO);
	}

	@Override
	public int selectBoardNextbidx(int category) {
		System.out.println("boardServiceImpl - selectBoardNextbidx");
		return dao.selectBoardNextbidx(category);
	}

	@Override
	public void callProcedure4sequence(int next_bidx) {
		System.out.println("boardServiceImpl - callProcedure4sequence");
		dao.callProcedure4sequence(next_bidx);
	}

	@Override
	public List<ITboardDTO> selectMainList(int num) {
		System.out.println("boardServiceImpl - selectMainList");
		return dao.selectMainList(num);
	}




	
}
