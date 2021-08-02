package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.dao.totalboardDAO;
import com.team.dto.HumorboardDTO;
import com.team.dto.ITboardDTO;
import com.team.dto.TotalboardDTO;
import com.team.vo.HumorboardList;
import com.team.vo.ITboardList;
import com.team.vo.TotalboardList;

@Service
public class totalboardServiceImpl implements totalboardService{

	@Inject
	private totalboardDAO dao;
	@Inject
	boardService iTboardservice;
	@Inject
	HumorboardService humorboardservice;

	private static final Logger LOG = LoggerFactory.getLogger(totalboardServiceImpl.class);
	
	@Override
	public void inserthumorBoard(HumorboardDTO humorboardDTO) {
		LOG.debug("inserthumorBoard");
		dao.inserthumorBoard(humorboardDTO);
	}

	@Override
	public void updateHumorBoardGood(HashMap<String, Integer> hmap) {
		LOG.debug("updateHumorBoardGood");
		dao.updateHumorBoardGood(hmap);
	}

	@Override
	public void insertitBoard(ITboardDTO iTboardDTO) {
		LOG.debug("insertitBoard");
		dao.insertitBoard(iTboardDTO);
	}

	@Override
	public void updateItBoardGood(HashMap<String, Integer> hmap) {
		LOG.debug("updateItBoardGood");
		dao.updateItBoardGood(hmap);
	}

	@Override
	public void updateHumorBoard(HumorboardDTO humorboardDTO) {
		LOG.debug("updateHumorBoard");
		dao.updateHumorBoard(humorboardDTO);
	}

	@Override
	public void updateITBoard(ITboardDTO iTboardDTO) {
		LOG.debug("updateITBoard");
		dao.updateITBoard(iTboardDTO);
	}

	@Override
	public void deleteHumorBoard(int bidx) {
		LOG.debug("deleteHumorBoard");
		dao.deleteHumorBoard(bidx);
	}

	@Override
	public void deleteITBoard(int bidx) {
		LOG.debug("deleteITBoard");
		dao.deleteITBoard(bidx);
	}

	@Override
	public List<TotalboardDTO> selectNewList(int num) {
		LOG.debug("selectNewList");
		return dao.selectNewList(num);
	}

	@Override
	public List<TotalboardDTO> selectGoodList(int num) {
		LOG.debug("selectGoodList");
		return dao.selectGoodList(num);
	}

	@Override
	public void incrementItBoard(int bidx) {
		LOG.debug("incrementItBoard");
		dao.incrementItBoard(bidx);
	}

	@Override
	public void incrementHumorBoard(int bidx) {
		LOG.debug("incrementHumorBoard");
		dao.incrementHumorBoard(bidx);
	}

	@Override
	public int selectTypeCount(TotalboardList totalboardList) {
		LOG.debug("selectTypeCount");
		return dao.selectTypeCount(totalboardList);
	}

	@Override
	public List<TotalboardDTO> selectTypeList(TotalboardList totalboardList) {
		LOG.debug("selectTypeList");
		return dao.selectTypeList(totalboardList);
	}

	@Override
	public void welcome(Model model) {
		LOG.debug("welcome");
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		TotalboardList totalNewList=ctx.getBean("TotalboardList1",TotalboardList.class);
		TotalboardList totalGoodList=ctx.getBean("TotalboardList2",TotalboardList.class);
		ITboardList iTboardList=ctx.getBean("ITboardList",ITboardList.class);
		HumorboardList humorboardList=ctx.getBean("HumorboardList",HumorboardList.class);

		//10개씩 가져오기.
		int num=10;
		totalNewList.setList(this.selectNewList(num));
		totalGoodList.setList(this.selectGoodList(num));
		iTboardList.setList(iTboardservice.selectMainList(num));
		humorboardList.setList(humorboardservice.selectMainList(num));

		model.addAttribute("totalNewList", totalNewList);
		model.addAttribute("totalGoodList", totalGoodList);
		model.addAttribute("iTboardList", iTboardList);
		model.addAttribute("humorboardList", humorboardList);
		model.addAttribute("num",num);
		
	}

	@Override
	public void connectBoard(Model model, int bidx) {
		LOG.debug("connectBoard");
		model.addAttribute("bidx", bidx);
	}

	@Override
	public void totalBoard(int itcurrentPage, int humorcurrentPage, int totalcurrentPage, HttpServletRequest request,
			Model model) {
		LOG.debug("totalBoard");
		String searchType=request.getParameter("searchType");
		String searchText=request.getParameter("searchText").trim();

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITboardList itboardList = ctx.getBean("ITboardList", ITboardList.class);
		HumorboardList humorboardList = ctx.getBean("HumorboardList", HumorboardList.class);
		TotalboardList totalboardList = ctx.getBean("TotalboardList1", TotalboardList.class);

		itboardList.setSearchText(searchText);
		itboardList.setSearchType(searchType);
		humorboardList.setSearchText(searchText);
		humorboardList.setSearchType(searchType);
		totalboardList.setSearchText(searchText);
		totalboardList.setSearchType(searchType);

		int ittotalCount = iTboardservice.selectTypeCount(itboardList);
		int humortotalCount = humorboardservice.selectTypeCount(humorboardList);
		int totalCount = this.selectTypeCount(totalboardList);

		itboardList.initboardList(ittotalCount,itcurrentPage);
		humorboardList.initboardList(humortotalCount,humorcurrentPage);
		totalboardList.initboardList(totalCount,totalcurrentPage);

		itboardList.setList(iTboardservice.selectTypeList(itboardList));
		humorboardList.setList(humorboardservice.selectTypeList(humorboardList));
		totalboardList.setList(this.selectTypeList(totalboardList));

		model.addAttribute("itboardList", itboardList);
		model.addAttribute("humorboardList", humorboardList);
		model.addAttribute("totalboardList", totalboardList);
		model.addAttribute("searchType",searchType);
		model.addAttribute("searchText",searchText);
	}
}
