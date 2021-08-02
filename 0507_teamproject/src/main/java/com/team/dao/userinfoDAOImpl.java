package com.team.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.team.vo.UserinfoVO;

@Repository
public class userinfoDAOImpl implements userinfoDAO{

	@Inject
    private SqlSession sqlSession;
    
	private static final Logger LOG = LoggerFactory.getLogger(userinfoDAOImpl.class);

    private static final String Namespace = "com.team.mapper.memberMapper";
    
	
	@Override
	public void insertMember(UserinfoVO userinfoVO) throws Exception {
		LOG.debug("insertMember");
		sqlSession.insert(Namespace+".insertMember",userinfoVO);
	}


	@Override
	public int selectMember(UserinfoVO userinfoVO) throws Exception {
		LOG.debug("selectMember");
		return sqlSession.selectOne(Namespace+".selectMember",userinfoVO);
	}


	@Override
	public String selectName(String userid) {
		LOG.debug("selectName");
		return sqlSession.selectOne(Namespace+".selectName",userid);
	}


	@Override
	public int selectIdCount(String data4Check) {
		LOG.debug("selectIdCount");
		return sqlSession.selectOne(Namespace+".selectIdCount",data4Check);
	}


	@Override
	public int selectNameCount(String data4Check) {
		LOG.debug("selectNameCount");
		return sqlSession.selectOne(Namespace+".selectNameCount",data4Check);
	}


	@Override
	public int selectEmailCount(String usermail) {
		LOG.debug("selectEmailCount");
		return sqlSession.selectOne(Namespace+".selectEmailCount",usermail);
	}


	@Override
	public UserinfoVO getUserById(String username) {
		LOG.debug("getUserById");
		return sqlSession.selectOne(Namespace+".selectUserById", username);
	}
	
}
