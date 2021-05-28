package com.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Override
	public void insertBoard(ITboardDTO iTboardDTO) {
		System.out.println("boardDAOImpl - insertBoard");
		sqlSession.insert(Namespace+".insertBoard", iTboardDTO);
	}
	@Override
	public void incrementBoard(int bidx) {
		System.out.println("boardDAOImpl - incrementBoard");
		sqlSession.update(Namespace+".incrementBoard", bidx);
	}
	@Override
	public ITboardDTO selectBoard(int bidx) {
		System.out.println("boardDAOImpl - selectBoard");
		return sqlSession.selectOne(Namespace+".selectBoard", bidx);
	}
	@Override
	public int selectGoodChecked(Map<String, String> map) {
		System.out.println("boardDAOImpl - selectGoodChecked");
		return sqlSession.selectOne(Namespace+".selectGoodChecked",map);
	}
	@Override
	public void updateGoodup(Map<String, String> map) {
		System.out.println("boardDAOImpl - updateGoodup");
		sqlSession.insert(Namespace+".updateGoodup", map);
	}
	@Override
	public void updateGooddown(Map<String, String> map) {
		System.out.println("boardDAOImpl - updateGooddown");
		sqlSession.delete(Namespace+".updateGooddown", map);
	}
	@Override
	public int selectGoodCount(int bidx) {
		System.out.println("boardDAOImpl - selectGoodCount");
		return sqlSession.selectOne(Namespace+".selectGoodCount", bidx);
	}
	@Override
	public void updateGooddownBoard(int bidx) {
		System.out.println("boardDAOImpl - updateGooddownBoard");
		sqlSession.update(Namespace+".updateGooddownBoard", bidx);
	}
	@Override
	public void updateGoodupBoard(int bidx) {
		System.out.println("boardDAOImpl - updateGoodupBoard");
		sqlSession.update(Namespace+".updateGoodupBoard", bidx);
	}

}
