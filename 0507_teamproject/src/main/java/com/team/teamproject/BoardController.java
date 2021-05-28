package com.team.teamproject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.dto.ITboardDTO;
import com.team.service.boardService;
import com.team.service.userinfoService;
import com.team.vo.ITboardList;

@Controller
public class BoardController {
	
	@Inject
	private boardService boardservice;
	@Inject
	private userinfoService userinfoservice;
	@RequestMapping("/main/itboard")
	public String ITboard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,Model model) {
		System.out.println("BoardController의 ITboard() 메소드");
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
	@RequestMapping(value="/main/itboard/increment",method=RequestMethod.GET)
	public String incrementBoard(HttpServletRequest request,Model model) {
		System.out.println("BoardController-incrementBoard");
		String currentPage=request.getParameter("currentPage");
		model.addAttribute("currentPage", currentPage);
		int bidx;
		try { //이미 게시판이 삭제되었을 경우, 예외처리 
			bidx=Integer.valueOf(request.getParameter("bidx"));
		}catch(Exception e) {		
			return "redirect:../itboard";
		}
		model.addAttribute("bidx", bidx);
		boardservice.incrementBoard(bidx);
		
		return "redirect:../itboard/contentView";
	}
	@RequestMapping(value="/main/itboard/contentView",method=RequestMethod.GET)
	public String boardContentView(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			HttpServletRequest request,Model model) {
		System.out.println("BoardController-boardContentView");
		int bidx=Integer.valueOf(request.getParameter("bidx"));
		ITboardDTO itboardDTO=boardservice.selectBoard(bidx);
		
		//bidx,사용자아이디를 얻어서  boardservice.selectGoodChecked(map)==1 여부에 따라 초기 하트를 결정함
		Map<String,String> map=new HashMap<String, String>();
		String userid=(String)request.getSession().getAttribute("Session_userID");//세션이없을 경우 null이 들어감
		model.addAttribute("heart",0);//비로그인 상태일 경우 , 좋아요를 누른이력이 없는 경우
		if(userid!=null) {
			map.put("bidx", request.getParameter("bidx"));
			map.put("id",userid);
			if(boardservice.selectGoodChecked(map)==1)
				model.addAttribute("heart",1);
		}
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("itboardDTO", itboardDTO);
		return "contentView";
	}
	@RequestMapping(value = "/main/itboard/asyncGood", 
			produces = { MediaType.APPLICATION_JSON_VALUE} , method=RequestMethod.POST)
	public @ResponseBody Map<String,Integer>asyncGood(@RequestBody Map<String,String> map){
		System.out.println("BoardController-asyncGood");
		Map<String,Integer> response_map=new HashMap<String, Integer>();
		int bidx=Integer.valueOf(map.get("bidx"));
		if(boardservice.selectGoodChecked(map)==1) {//특정아이디에 해당하는 이미 좋아요 누른 상태이면
			//좋아요를 해제
			boardservice.updateGooddown(map);
			//clicked= 0도 반환
			response_map.put("clicked", 0);
			//특정 itboard 테이블의 good 변경
			boardservice.updateGooddownBoard(bidx);
		}else {//좋아요가 안눌린 상태라면
			//좋아요를 넣어주기
			boardservice.updateGoodup(map);
			//clicked= 1도 반환
			response_map.put("clicked", 1);
			//특정 itboard 테이블의 good 변경
			boardservice.updateGoodupBoard(bidx);
		}
		//총좋아요갯수반환
		int goodCount=boardservice.selectGoodCount(bidx);
		response_map.put("goodCount",goodCount);
		return response_map;
	}

}
