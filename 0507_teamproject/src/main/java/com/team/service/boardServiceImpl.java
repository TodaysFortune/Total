package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.dao.boardDAO;
import com.team.dto.ITboardDTO;

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
	
	
}
