package com.team.teamproject;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.service.boardService;
import com.team.vo.ITboardList;

@Controller
public class BoardController {
	
	@Inject
	private boardService boardservice;
	
	@RequestMapping("/main/itboard")
	public String ITboard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,HttpServletRequest request,Model model) {
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
		//test
		System.out.println(iTboardList);
		return "ITboard";		
	}
}
