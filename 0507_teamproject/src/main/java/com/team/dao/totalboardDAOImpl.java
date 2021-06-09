package com.team.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;
import com.team.dto.TotalboardDTO;

@Repository
public class totalboardDAOImpl implements totalboardDAO{
	
	@Inject
    private SqlSession sqlSession;
	
	private static final String Namespace = "com.team.mapper.totalboardMapper";

	@Override
	public void inserthumorBoard(HumorboardDTO humorboardDTO) {
		System.out.println("totalboardDAOImpl-inserthumorBoard");
		sqlSession.insert(Namespace+".inserthumorBoard", humorboardDTO);
	}

	@Override
	public void updateHumorBoardGood(HashMap<String, Integer> hmap) {
		System.out.println("totalboardDAOImpl-updateHumorBoardGood");
		sqlSession.update(Namespace+".updateHumorBoardGood", hmap);
	}

	@Override
	public void insertitBoard(ITboardDTO iTboardDTO) {
		System.out.println("totalboardDAOImpl-insertitBoard");
		sqlSession.insert(Namespace+".insertitBoard", iTboardDTO);
	}

	@Override
	public void updateItBoardGood(HashMap<String, Integer> hmap) {
		System.out.println("totalboardDAOImpl-updateItBoardGood");
		sqlSession.update(Namespace+".updateItBoardGood", hmap);
	}

	@Override
	public void updateHumorBoard(HumorboardDTO humorboardDTO) {
		System.out.println("totalboardDAOImpl-updateHumorBoard");
		sqlSession.update(Namespace+".updateHumorBoard", humorboardDTO);
	}

	@Override
	public void updateITBoard(ITboardDTO iTboardDTO) {
		System.out.println("totalboardDAOImpl-updateITBoard");
		sqlSession.update(Namespace+".updateITBoard", iTboardDTO);
	}

	@Override
	public void deleteHumorBoard(int bidx) {
		System.out.println("totalboardDAOImpl-deleteHumorBoard");
		sqlSession.delete(Namespace+".deleteHumorBoard", bidx);
	}

	@Override
	public void deleteITBoard(int bidx) {
		System.out.println("totalboardDAOImpl-deleteITBoard");
		sqlSession.delete(Namespace+".deleteITBoard", bidx);
	}

	@Override
	public List<TotalboardDTO> selectNewList(int num) {
		System.out.println("totalboardDAOImpl-selectNewList");
		return sqlSession.selectList(Namespace+".selectNewList",num);
	}

	@Override
	public List<TotalboardDTO> selectGoodList(int num) {
		System.out.println("totalboardDAOImpl-selectGoodList");
		return sqlSession.selectList(Namespace+".selectGoodList",num);
	}
	
}
