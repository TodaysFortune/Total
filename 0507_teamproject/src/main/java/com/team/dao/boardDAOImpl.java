package com.team.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;

@Repository
public class boardDAOImpl implements boardDAO {

	@Inject
    private SqlSession sqlSession;
	
	private static final String Namespace = "com.team.mapper.boardMapper";
	
	@Override
	public int selectCount() {
		System.out.println("boardDAOImpl - selectCount");
		return sqlSession.selectOne(Namespace+".selectCount");
	}
	@Override
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap) {
		System.out.println("boardDAOImpl - selectList");
		return sqlSession.selectList(Namespace+".selectList",hmap);
	}
	@Override
	public int selectTypeCount(ITboardList iTboardList) {
		System.out.println("boardDAOImpl - selectTypeCount");
		return sqlSession.selectOne(Namespace+".selectTypeCount",iTboardList);
	}
	@Override
	public List<ITboardDTO> selectTypeList(ITboardList iTboardList) {
		System.out.println("boardDAOImpl - selectTypeList");
		return sqlSession.selectList(Namespace+".selectTypeList",iTboardList);
	}

}
