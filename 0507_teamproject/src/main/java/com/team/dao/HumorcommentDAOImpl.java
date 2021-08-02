package com.team.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.team.dto.HumorcommentDTO;

@Repository
public class HumorcommentDAOImpl implements HumorcommentDAO{

	@Inject
    private SqlSession sqlSession;

	private static final Logger LOG = LoggerFactory.getLogger(HumorcommentDAOImpl.class);
	
	private static final String Namespace = "com.team.mapper.HumorcommentMapper";

	@Override
	public void insertComment(HumorcommentDTO commentDTO) {
		LOG.debug("insertComment");
		sqlSession.insert(Namespace+".insertComment", commentDTO);
	}

	@Override
	public int Humorcommentnextval(int bidx) {
		LOG.debug("ITcommentnextval");
		return sqlSession.selectOne(Namespace+".Humorcommentnextval", bidx);
	}

	@Override
	public int selectCount(int bidx) {
		LOG.debug("selectCount");
		return sqlSession.selectOne(Namespace+".selectCount", bidx);
	}

	@Override
	public List<HumorcommentDTO> selectList(HashMap<String, Integer> hmap) {
		LOG.debug("selectList");
		return sqlSession.selectList(Namespace+".selectList", hmap);
	}

	@Override
	public void deleteComment(int cidx) {
		LOG.debug("deleteComment");
		sqlSession.delete(Namespace+".deleteComment", cidx);
	}
}
