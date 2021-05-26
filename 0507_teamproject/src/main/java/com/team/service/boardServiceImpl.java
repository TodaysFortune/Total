package com.team.service;

import java.util.HashMap;
import java.util.List;

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
	public int selectTypeCount(ITboardList iTboardList) {
		
		System.out.println("boardServiceImpl - selectTypeCount");
		if(iTboardList.getSearchText().length()==0 ||
				iTboardList.getSearchType().equals("recommendedNumber"))//검색창에 아무것도 안썻을 경우 || 추천글을 눌렀을 경우
			return dao.selectCount();//일반 게시판첫페이지를 호출할 경우와 같은 효과
		return dao.selectTypeCount(iTboardList);
	}

	@Override
	public List<ITboardDTO> selectTypeList(ITboardList iTboardList) {
		System.out.println("boardServiceImpl - selectTypeList");
		return dao.selectTypeList(iTboardList);
	}

	@Override
	public void insertBoard(ITboardDTO iTboardDTO) {
		System.out.println("boardServiceImpl - insertBoard");
		dao.insertBoard(iTboardDTO);
	}

	
}
