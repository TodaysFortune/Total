package com.team.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.team.dto.ITcommentDTO;

@Repository
public class commentDAOImpl implements commentDAO{

	@Inject
    private SqlSession sqlSession;
	
	private static final Logger LOG = LoggerFactory.getLogger(commentDAOImpl.class);
	
	private static final String Namespace = "com.team.mapper.commentMapper";

	@Override
	public void insertComment(ITcommentDTO commentDTO) {
		LOG.debug("insertComment");
		sqlSession.insert(Namespace+".insertComment", commentDTO);
	}

	@Override
	public int ITcommentnextval(int bidx) {
		LOG.debug("ITcommentnextval");
		return sqlSession.selectOne(Namespace+".ITcommentnextval", bidx);
	}

	@Override
	public int selectCount(int bidx) {
		LOG.debug("selectCount");
		return sqlSession.selectOne(Namespace+".selectCount", bidx);
	}

	@Override
	public List<ITcommentDTO> selectList(HashMap<String, Integer> hmap) {
		LOG.debug("selectList");
		return sqlSession.selectList(Namespace+".selectList", hmap);
	}

	@Override
	public void deleteComment(int cidx) {
		LOG.debug("deleteComment");
		sqlSession.delete(Namespace+".deleteComment", cidx);
	}
}
