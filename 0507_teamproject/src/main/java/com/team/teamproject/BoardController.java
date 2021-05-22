package com.team.teamproject;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.service.boardService;
import com.team.vo.ITboardList;

@Controller
public class BoardController {
	
	@Inject
	private boardService boardservice;
	
	@RequestMapping("/main/itboard")
	public String ITboard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,Model model) {
		System.out.println("BoardController의 ITboard() 메소드");
		//test
		//System.out.println(currentPage);
		
		int totalCount = boardservice.selectCount();
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITboardList iTboardList = ctx.getBean("ITboardList", ITboardList.class);
		iTboardList.initITboardList(totalCount, currentPage);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", iTboardList.getStartNo());
		hmap.put("noSize", iTboardList.getNoSize());
		iTboardList.setList(boardservice.selectList(hmap));//sql 이용해서 한페이지 게시글 리스트 초기화.
		model.addAttribute("iTboardList", iTboardList);
		return "ITboard";		
	}
	
	@RequestMapping(value="/main/itboardsearch",method=RequestMethod.GET)
	public String ITboardsearch(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			HttpServletRequest request,Model model) {
		
		System.out.println("BoardController의 ITboardsearch() 메소드");
		
		String searchType=request.getParameter("searchType");
		String searchText=request.getParameter("searchText").trim();
			
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITboardList iTboardList = ctx.getBean("ITboardList", ITboardList.class);
		
		iTboardList.setSearchText(searchText);
		iTboardList.setSearchType(searchType);
		
		int totalCount = boardservice.selectTypeCount(iTboardList);
		
		System.out.println("totalCount"+totalCount);//test
		
		iTboardList.initITboardList(totalCount,currentPage);
		iTboardList.setList(boardservice.selectTypeList(iTboardList));
		
		model.addAttribute("iTboardList", iTboardList);
		model.addAttribute("searchType",searchType);
		model.addAttribute("searchText",searchText);
		
		return "ITboard";
	}
}
