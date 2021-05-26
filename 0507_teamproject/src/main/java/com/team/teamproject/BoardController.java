package com.team.teamproject;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.dto.ITboardDTO;
import com.team.service.boardService;
import com.team.service.userinfoService;
import com.team.vo.ITboardList;
import com.team.vo.UserinfoVO;

@Controller
public class BoardController {
	
	@Inject
	private boardService boardservice;
	@Inject
	private userinfoService userinfoservice;
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
	@RequestMapping(value="/main/itboard/write",method=RequestMethod.GET)
	public String getwrite(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,Model model,HttpSession session) {
		System.out.println("BoardController-getwrite");
		String Session_userID=(String)session.getAttribute("Session_userID");
		if(Session_userID!=null) {
			String userName=userinfoservice.selectName(Session_userID);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("name", userName);
			model.addAttribute("id",Session_userID);
			return "Write";
		}
		return "redirect:../login";//비정상적 경로로 입장시 로그인페이지로 이동
	}
	@RequestMapping(value="/main/itboard/write",method=RequestMethod.POST)
	public String postwrite(HttpSession session,ITboardDTO iTboardDTO) {
		System.out.println("BoardController-postwrite");
		String Session_userID=(String)session.getAttribute("Session_userID");
		if(Session_userID!=null) {
			boardservice.insertBoard(iTboardDTO);
			return "redirect:../itboard";
		}
		return "redirect:../login";//글입력중 세션만료 걸렸을 경우
	}
}
