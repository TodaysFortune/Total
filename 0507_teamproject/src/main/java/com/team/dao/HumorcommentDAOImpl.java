package com.team.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.team.dto.HumorcommentDTO;

@Repository
public class HumorcommentDAOImpl implements HumorcommentDAO{

	@Inject
    private SqlSession sqlSession;
	
	private static final String Namespace = "com.team.mapper.HumorcommentMapper";

	@Override
	public void insertComment(HumorcommentDTO commentDTO) {
		System.out.println("commentDAOImpl-insertComment");
		sqlSession.insert(Namespace+".insertComment", commentDTO);
	}

	@Override
	public int Humorcommentnextval(int bidx) {
		System.out.println("commentDAOImpl-ITcommentnextval");
		return sqlSession.selectOne(Namespace+".Humorcommentnextval", bidx);
	}

	@Override
	public int selectCount(int bidx) {
		System.out.println("commentDAOImpl-selectCount");
		return sqlSession.selectOne(Namespace+".selectCount", bidx);
	}

	@Override
	public List<HumorcommentDTO> selectList(HashMap<String, Integer> hmap) {
		System.out.println("commentDAOImpl-selectList");
		return sqlSession.selectList(Namespace+".selectList", hmap);
	}

	@Override
	public void deleteComment(int cidx) {
		System.out.println("commentDAOImpl-deleteComment");
		sqlSession.delete(Namespace+".deleteComment", cidx);
	}
}
