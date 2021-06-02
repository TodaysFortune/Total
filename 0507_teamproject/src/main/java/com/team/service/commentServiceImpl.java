package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.dao.commentDAO;
import com.team.dto.ITcommentDTO;

@Service
public class commentServiceImpl implements commentService{
	@Inject
	private commentDAO dao;

	@Override
	public void insertComment(ITcommentDTO iTcommentDTO) {
		System.out.println("commentServiceImpl-insertComment");
		dao.insertComment(iTcommentDTO);
	}

	@Override
	public int ITcommentnextval(int bidx) {
		System.out.println("commentServiceImpl-ITcommentnextval");
		return dao.ITcommentnextval(bidx);
	}

	@Override
	public int selectCount(int bidx) {
		System.out.println("commentServiceImpl-selectCount");
		return dao.selectCount(bidx);
	}

	@Override
	public List<ITcommentDTO> selectList(HashMap<String, Integer> hmap) {
		System.out.println("commentServiceImpl-selectList");
		return dao.selectList(hmap);
	}

	@Override
	public void deleteComment(int cidx) {
		System.out.println("commentServiceImpl-deleteComment");
		dao.deleteComment(cidx);
	}
	
}
