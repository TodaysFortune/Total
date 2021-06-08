package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.team.dao.HumorcommentDAO;
import com.team.dto.HumorcommentDTO;

@Service
public class HumorcommentServiceImpl implements HumorcommentService{
	@Inject
	private HumorcommentDAO dao;

	@Override
	public void insertComment(HumorcommentDTO commentDTO) {
		System.out.println("commentServiceImpl-insertComment");
		dao.insertComment(commentDTO);
	}

	@Override
	public int Humorcommentnextval(int bidx) {
		System.out.println("commentServiceImpl-ITcommentnextval");
		return dao.Humorcommentnextval(bidx);
	}

	@Override
	public int selectCount(int bidx) {
		System.out.println("commentServiceImpl-selectCount");
		return dao.selectCount(bidx);
	}

	@Override
	public List<HumorcommentDTO> selectList(HashMap<String, Integer> hmap) {
		System.out.println("commentServiceImpl-selectList");
		return dao.selectList(hmap);
	}

	@Override
	public void deleteComment(int cidx) {
		System.out.println("commentServiceImpl-deleteComment");
		dao.deleteComment(cidx);
	}
	
}
