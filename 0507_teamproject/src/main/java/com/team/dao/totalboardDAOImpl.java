package com.team.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;
import com.team.dto.TotalboardDTO;
import com.team.vo.TotalboardList;

@Repository
public class totalboardDAOImpl implements totalboardDAO{
	
	@Inject
    private SqlSession sqlSession;
	
	private static final Logger LOG = LoggerFactory.getLogger(totalboardDAOImpl.class);
	
	private static final String Namespace = "com.team.mapper.totalboardMapper";

	@Override
	public void inserthumorBoard(HumorboardDTO humorboardDTO) {
		LOG.debug("inserthumorBoard");
		sqlSession.insert(Namespace+".inserthumorBoard", humorboardDTO);
	}

	@Override
	public void updateHumorBoardGood(HashMap<String, Integer> hmap) {
		LOG.debug("updateHumorBoardGood");
		sqlSession.update(Namespace+".updateHumorBoardGood", hmap);
	}

	@Override
	public void insertitBoard(ITboardDTO iTboardDTO) {
		LOG.debug("insertitBoard");
		sqlSession.insert(Namespace+".insertitBoard", iTboardDTO);
	}

	@Override
	public void updateItBoardGood(HashMap<String, Integer> hmap) {
		LOG.debug("updateItBoardGood");
		sqlSession.update(Namespace+".updateItBoardGood", hmap);
	}

	@Override
	public void updateHumorBoard(HumorboardDTO humorboardDTO) {
		LOG.debug("updateHumorBoard");
		sqlSession.update(Namespace+".updateHumorBoard", humorboardDTO);
	}

	@Override
	public void updateITBoard(ITboardDTO iTboardDTO) {
		LOG.debug("updateITBoard");
		sqlSession.update(Namespace+".updateITBoard", iTboardDTO);
	}

	@Override
	public void deleteHumorBoard(int bidx) {
		LOG.debug("deleteHumorBoard");
		sqlSession.delete(Namespace+".deleteHumorBoard", bidx);
	}

	@Override
	public void deleteITBoard(int bidx) {
		LOG.debug("deleteITBoard");
		sqlSession.delete(Namespace+".deleteITBoard", bidx);
	}

	@Override
	public List<TotalboardDTO> selectNewList(int num) {
		LOG.debug("selectNewList");
		return sqlSession.selectList(Namespace+".selectNewList",num);
	}

	@Override
	public List<TotalboardDTO> selectGoodList(int num) {
		LOG.debug("selectGoodList");
		return sqlSession.selectList(Namespace+".selectGoodList",num);
	}

	@Override
	public void incrementItBoard(int bidx) {
		LOG.debug("incrementItBoard");
		sqlSession.update(Namespace+".incrementItBoard",bidx);
	}

	@Override
	public void incrementHumorBoard(int bidx) {
		LOG.debug("incrementHumorBoard");
		sqlSession.update(Namespace+".incrementHumorBoard",bidx);
	}

	@Override
	public int selectTypeCount(TotalboardList totalboardList) {
		LOG.debug("selectTypeCount");
		return sqlSession.selectOne(Namespace+".selectTypeCount",totalboardList);
	}

	@Override
	public List<TotalboardDTO> selectTypeList(TotalboardList totalboardList) {
		LOG.debug("selectTypeList");
		return sqlSession.selectList(Namespace+".selectTypeList",totalboardList);
	}
	
}
