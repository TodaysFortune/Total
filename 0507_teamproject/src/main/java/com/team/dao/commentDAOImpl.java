package com.team.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.team.dto.ITcommentDTO;
import com.team.service.commentService;

@Repository
public class commentDAOImpl implements commentDAO{

	@Inject
    private SqlSession sqlSession;
	
	private static final String Namespace = "com.team.mapper.commentMapper";

	@Override
	public void insertComment(ITcommentDTO iTcommentDTO) {
		System.out.println("commentDAOImpl-insertComment");
		sqlSession.insert(Namespace+".insertComment", iTcommentDTO);
	}

	@Override
	public int ITcommentnextval(int bidx) {
		System.out.println("commentDAOImpl-ITcommentnextval");
		return sqlSession.selectOne(Namespace+".ITcommentnextval", bidx);
	}

	@Override
	public int selectCount(int bidx) {
		System.out.println("commentDAOImpl-selectCount");
		return sqlSession.selectOne(Namespace+".selectCount", bidx);
	}

	@Override
	public List<ITcommentDTO> selectList(HashMap<String, Integer> hmap) {
		System.out.println("commentDAOImpl-selectList");
		return sqlSession.selectList(Namespace+".selectList", hmap);
	}
}
