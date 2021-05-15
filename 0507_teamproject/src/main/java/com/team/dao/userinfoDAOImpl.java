package com.team.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.team.vo.UserinfoVO;

@Repository
public class userinfoDAOImpl implements userinfoDAO{

	@Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.team.mapper.memberMapper";
    
	
	@Override
	public void insertMember(UserinfoVO userinfoVO) throws Exception {
		System.out.println("userinfoDAOImpl - insertMember");
		sqlSession.insert(Namespace+".insertMember",userinfoVO);
	}


	@Override
	public int selectMember(UserinfoVO userinfoVO) throws Exception {
		System.out.println("userinfoDAOImpl - selectMember");
		return sqlSession.selectOne(Namespace+".selectMember",userinfoVO);
	}
	
}
