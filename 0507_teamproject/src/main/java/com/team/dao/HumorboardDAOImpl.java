package com.team.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.team.dto.HumorboardDTO;
import com.team.vo.HumorboardList;

@Repository
public class HumorboardDAOImpl implements HumorboardDAO {

	@Inject
    private SqlSession sqlSession;
	
	private static final String Namespace = "com.team.mapper.HumorboardMapper";
	
	@Override
	public int selectCount() {
		System.out.println("boardDAOImpl - selectCount");
		return sqlSession.selectOne(Namespace+".selectCount");
	}
	@Override
	public List<HumorboardDTO> selectList(HashMap<String, Integer> hmap) {
		System.out.println("boardDAOImpl - selectList");
		return sqlSession.selectList(Namespace+".selectList",hmap);
	}
	@Override
	public int selectTypeCount(HumorboardList boardList) {
		System.out.println("boardDAOImpl - selectTypeCount");
		return sqlSession.selectOne(Namespace+".selectTypeCount",boardList);
	}
	@Override
	public List<HumorboardDTO> selectTypeList(HumorboardList boardList) {
		System.out.println("boardDAOImpl - selectTypeList");
		return sqlSession.selectList(Namespace+".selectTypeList",boardList);
	}
	@Override
	public void insertBoard(HumorboardDTO boardDTO) {
		System.out.println("boardDAOImpl - insertBoard");
		sqlSession.insert(Namespace+".insertBoard", boardDTO);
	}
	@Override
	public void incrementBoard(int bidx) {
		System.out.println("boardDAOImpl - incrementBoard");
		sqlSession.update(Namespace+".incrementBoard", bidx);
	}
	@Override
	public HumorboardDTO selectBoard(int bidx) {
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
	@Override
	public void updateBoard(HumorboardDTO boardDTO) {
		System.out.println("boardDAOImpl - updateBoard");
		sqlSession.update(Namespace+".updateBoard", boardDTO);
	}
	@Override
	public void deleteBoard(int bidx) {
		System.out.println("boardDAOImpl - deleteBoard");
		sqlSession.delete(Namespace+".deleteBoard", bidx);
	}
	@Override
	public void insertreplyBoard(HumorboardDTO boardDTO) {
		System.out.println("boardDAOImpl - insertreplyBoard");
		sqlSession.insert(Namespace+".insertreplyBoard", boardDTO);
	}
	@Override
	public int selectBoardNextbidx(int category) {
		System.out.println("boardDAOImpl - selectBoardNextbidx");
		return sqlSession.selectOne(Namespace+".selectBoardNextbidx", category);
	}
	@Override
	public void callProcedure4sequence(int next_bidx) {
		System.out.println("boardDAOImpl - callProcedure4sequence");
		sqlSession.selectOne(Namespace+".callProcedure4sequence", next_bidx);
	}

}
