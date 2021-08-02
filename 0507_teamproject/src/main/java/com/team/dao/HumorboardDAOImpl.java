package com.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.team.dto.HumorboardDTO;
import com.team.vo.HumorboardList;

@Repository
public class HumorboardDAOImpl implements HumorboardDAO {

	@Inject
    private SqlSession sqlSession;
	
	private static final Logger LOG = LoggerFactory.getLogger(HumorboardDAOImpl.class);
	
	private static final String Namespace = "com.team.mapper.HumorboardMapper";
	
	@Override
	public int selectCount() {
		LOG.debug("selectCount");
		return sqlSession.selectOne(Namespace+".selectCount");
	}
	@Override
	public List<HumorboardDTO> selectList(HashMap<String, Integer> hmap) {
		LOG.debug("selectList");
		return sqlSession.selectList(Namespace+".selectList",hmap);
	}
	@Override
	public int selectTypeCount(HumorboardList boardList) {
		LOG.debug("selectTypeCount");
		return sqlSession.selectOne(Namespace+".selectTypeCount",boardList);
	}
	@Override
	public List<HumorboardDTO> selectTypeList(HumorboardList boardList) {
		LOG.debug("selectTypeList");
		return sqlSession.selectList(Namespace+".selectTypeList",boardList);
	}
	@Override
	public void insertBoard(HumorboardDTO boardDTO) {
		LOG.debug("insertBoard");
		sqlSession.insert(Namespace+".insertBoard", boardDTO);
	}
	@Override
	public void incrementBoard(int bidx) {
		LOG.debug("incrementBoard");
		sqlSession.update(Namespace+".incrementBoard", bidx);
	}
	@Override
	public HumorboardDTO selectBoard(int bidx) {
		LOG.debug("selectBoard");
		return sqlSession.selectOne(Namespace+".selectBoard", bidx);
	}
	@Override
	public int selectGoodChecked(Map<String, String> map) {
		LOG.debug("selectGoodChecked");
		return sqlSession.selectOne(Namespace+".selectGoodChecked",map);
	}
	@Override
	public void updateGoodup(Map<String, String> map) {
		LOG.debug("updateGoodup");
		sqlSession.insert(Namespace+".updateGoodup", map);
	}
	@Override
	public void updateGooddown(Map<String, String> map) {
		LOG.debug("updateGooddown");
		sqlSession.delete(Namespace+".updateGooddown", map);
	}
	@Override
	public int selectGoodCount(int bidx) {
		LOG.debug("selectGoodCount");
		return sqlSession.selectOne(Namespace+".selectGoodCount", bidx);
	}
	@Override
	public void updateGooddownBoard(int bidx) {
		LOG.debug("updateGooddownBoard");
		sqlSession.update(Namespace+".updateGooddownBoard", bidx);
	}
	@Override
	public void updateGoodupBoard(int bidx) {
		LOG.debug("updateGoodupBoard");
		sqlSession.update(Namespace+".updateGoodupBoard", bidx);
	}
	@Override
	public void updateBoard(HumorboardDTO boardDTO) {
		LOG.debug("updateBoard");
		sqlSession.update(Namespace+".updateBoard", boardDTO);
	}
	@Override
	public void deleteBoard(int bidx) {
		LOG.debug("deleteBoard");
		sqlSession.delete(Namespace+".deleteBoard", bidx);
	}
	@Override
	public void insertreplyBoard(HumorboardDTO boardDTO) {
		LOG.debug("insertreplyBoard");
		sqlSession.insert(Namespace+".insertreplyBoard", boardDTO);
	}
	@Override
	public int selectBoardNextbidx(int category) {
		LOG.debug("selectBoardNextbidx");
		return sqlSession.selectOne(Namespace+".selectBoardNextbidx", category);
	}
	@Override
	public void callProcedure4sequence(int next_bidx) {
		LOG.debug("callProcedure4sequence");
		sqlSession.selectOne(Namespace+".callProcedure4sequence", next_bidx);
	}
	@Override
	public List<HumorboardDTO> selectMainList(int num) {
		LOG.debug("selectMainList");
		return sqlSession.selectList(Namespace+".selectMainList",num);
	}

}
