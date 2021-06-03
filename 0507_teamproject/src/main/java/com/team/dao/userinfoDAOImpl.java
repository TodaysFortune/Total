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


	@Override
	public String selectName(String userid) {
		System.out.println("userinfoDAOImpl - selectName");
		return sqlSession.selectOne(Namespace+".selectName",userid);
	}


	@Override
	public int selectIdCount(String data4Check) {
		System.out.println("userinfoDAOImpl - selectIdCount");
		return sqlSession.selectOne(Namespace+".selectIdCount",data4Check);
	}


	@Override
	public int selectNameCount(String data4Check) {
		System.out.println("userinfoDAOImpl - selectNameCount");
		return sqlSession.selectOne(Namespace+".selectNameCount",data4Check);
	}
	
}
