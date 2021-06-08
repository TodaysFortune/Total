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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.dto.HumorboardDTO;
import com.team.service.HumorboardService;
import com.team.service.HumorcommentService;
import com.team.service.totalboardService;
import com.team.service.userinfoService;
import com.team.vo.HumorboardList;
import com.team.vo.HumorcommentList;

@Controller
public class HumorBoardController {
	
	@Inject
	private totalboardService totalboardservice;
	@Inject
	private HumorboardService boardservice;
	@Inject
	private userinfoService userinfoservice;
	@Inject
	private HumorcommentService commentservice;
	
	@RequestMapping("/main/humorboard")
	public String boardList(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model) {
		int totalCount = boardservice.selectCount();
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		HumorboardList humorboardList = ctx.getBean("HumorboardList", HumorboardList.class);
		
		humorboardList.initboardList(totalCount, currentPage);
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", humorboardList.getStartNo());
		hmap.put("noSize", humorboardList.getNoSize());
		
		humorboardList.setList(boardservice.selectList(hmap));//sql 이용해서 한페이지 게시글 리스트 초기화.
		model.addAttribute("boardList", humorboardList);
		return "Humorboard";
	}
	@RequestMapping(value="/main/humorboardsearch",method=RequestMethod.GET)
	public String boardSearch(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
		HttpServletRequest request,Model model) {
		
		String searchType=request.getParameter("searchType");
		String searchText=request.getParameter("searchText").trim();
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		HumorboardList humorboardList = ctx.getBean("HumorboardList", HumorboardList.class);
		
		humorboardList.setSearchText(searchText);
		humorboardList.setSearchType(searchType);
		
		int totalCount = boardservice.selectTypeCount(humorboardList);
		
		humorboardList.initboardList(totalCount,currentPage);
		humorboardList.setList(boardservice.selectTypeList(humorboardList));
		
		model.addAttribute("boardList", humorboardList);
		model.addAttribute("searchType",searchType);
		model.addAttribute("searchText",searchText);
		
		return "Humorboard";
	}
	@RequestMapping(value="/main/humorboard/write",method=RequestMethod.GET)
	public String getWriteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,HttpSession session) {
		System.out.println("BoardController-getwrite");
		String Session_userID=(String)session.getAttribute("Session_userID");
		if(Session_userID!=null) {
			String userName=userinfoservice.selectName(Session_userID);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("name", userName);
			model.addAttribute("id",Session_userID);
			return "HumorWrite";
		}
		return "redirect:../login";//비정상적 경로로 입장시 로그인페이지로 이동
	}
	@RequestMapping(value="/main/humorboard/write",method=RequestMethod.POST)
	public String postWriteBoard(HttpSession session,
			@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO) {
		String Session_userID=(String)session.getAttribute("Session_userID");
		if(Session_userID!=null) {
			//레이스 컨디션 방지를 위해서
			//1.먼저 특정 boardnextval(#{category})를 얻어와서 임의의 변수 next_bidx에 대입시킨다. 
			int next_bidx=boardservice.selectBoardNextbidx(humorboardDTO.getCategory());
			//!!  select boardnextval(#{category})
			//2. 이제 레이스 컨디션의 문제는 사라졌으므로 , 획득한 next_bidx로 요리하면된다.
			//3.bidx, board_ref setter 등록해주고 , 게시글등록  
			humorboardDTO.setBidx(next_bidx);
			humorboardDTO.setBoard_ref(next_bidx);
			
			boardservice.insertBoard(humorboardDTO);
			totalboardservice.inserthumorBoard(humorboardDTO);
			
			//4.ITCommentRefsequences테이블의 레코드를 생성하는 프로시져 호출
			boardservice.callProcedure4sequence(next_bidx);
			
			return "redirect:../humorboard";
		}
		return "redirect:../login";//글입력중 세션만료 걸렸을 경우
	}
	@RequestMapping(value="/main/humorboard/increment",method=RequestMethod.GET)
	public String incrementBoard(HttpServletRequest request,Model model) {
		String currentPage=request.getParameter("currentPage");
		model.addAttribute("currentPage", currentPage);
		int bidx;
		try { //이미 게시판이 삭제되었을 경우, 예외처리 
			bidx=Integer.valueOf(request.getParameter("bidx"));
		}catch(Exception e) {		
			return "redirect:../humorboard";
		}
		model.addAttribute("bidx", bidx);
		boardservice.incrementBoard(bidx);
		
		return "redirect:../humorboard/contentView";
	}
	@RequestMapping(value="/main/humorboard/contentView",method=RequestMethod.GET)
	public String boardContentView(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
			HttpServletRequest request,Model model) {
		int bidx=Integer.valueOf(request.getParameter("bidx"));
		HumorboardDTO humorboardDTO=boardservice.selectBoard(bidx);
		
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
		
		//덧글 한페이지 얻기
		int comment_totalCount = commentservice.selectCount(bidx);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		HumorcommentList humorcommentList = ctx.getBean("HumorcommentList", HumorcommentList.class);
		if(comment_totalCount!=0) {
			humorcommentList.initcommentList(comment_totalCount, comment_currentPage);
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("startNo", humorcommentList.getStartNo());
			hmap.put("noSize", humorcommentList.getNoSize());
			hmap.put("bidx", bidx);
			humorcommentList.setList(commentservice.selectList(hmap));
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("boardDTO", humorboardDTO);
		model.addAttribute("comment_currentPage", comment_currentPage);
		model.addAttribute("commentList", humorcommentList);
		model.addAttribute("comment_totalCount",comment_totalCount);
		model.addAttribute("enter", "\n");//개행문자처리
		return "HumorcontentView";
	}
	@RequestMapping(value = "main/humorboard/contentView/update",method=RequestMethod.POST)
	public String getUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			Model model) { //오는것 bidx,currentPage
		HumorboardDTO humorboardDTO=boardservice.selectBoard(bidx);
		
		model.addAttribute("boardDTO", humorboardDTO);
		model.addAttribute("currentPage", currentPage);
		return "Humorupdate";
	}
	@RequestMapping(value = "main/humorboard/contentView/updateBoard",method=RequestMethod.POST)
	public String postUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO,
			Model model) { //오는것 bidx,currentPage
		
		boardservice.updateBoard(humorboardDTO);
		totalboardservice.updateHumorBoard(humorboardDTO);
		
		model.addAttribute("bidx", humorboardDTO.getBidx());// bidx, currentPage가 잘 적용되는지 contentView 에서 볼것 됨. 아주좋아.
		model.addAttribute("currentPage", currentPage);
		return "redirect:../contentView";
	}
	@RequestMapping(value = "main/humorboard/contentView/delete",method=RequestMethod.POST)
	public String deleteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			Model model) {  //오는것 bidx,currentPage
		boardservice.deleteBoard(bidx);
		totalboardservice.deleteHumorBoard(bidx);
		model.addAttribute("currentPage", currentPage);
		return "redirect:../../humorboard";
	}
	@RequestMapping(value = "main/humorboard/contentView/replyBoard",method=RequestMethod.GET)
	public String getReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO,
			HttpSession session) {
		String name=userinfoservice.selectName((String)session.getAttribute("Session_userID"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("name", name);
		return "HumorreplyBoard";
	}
	@RequestMapping(value = "main/humorboard/contentView/replyBoard",method=RequestMethod.POST)
	public String postReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,
			@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO) {
		//1.boardnextval에 의해 증가된 bidx를 우선적으로 받아와서 int next_bidx에 저장한다.  (레이스컨디션은 방지되었음)
		int next_bidx=boardservice.selectBoardNextbidx(humorboardDTO.getCategory());
		//2.이용할 ref는 기존의 iTboardDTO에 그대로 있음
		//3.next_bidx 를 iTboardDTO 에 등록
		humorboardDTO.setBidx(next_bidx);
		//4. 답변게시글등록
		boardservice.insertreplyBoard(humorboardDTO);
		//5. ITCommentRefsequences테이블의 레코드를 생성하는 프로시져 호출
		boardservice.callProcedure4sequence(next_bidx);
		
		model.addAttribute("currentPage", currentPage);
		return "redirect:../../humorboard";
	}
	@RequestMapping(value = "/main/humorboard/asyncGood", 
			produces = { MediaType.APPLICATION_JSON_VALUE} , method=RequestMethod.POST)
	public @ResponseBody Map<String,Integer>clickGood(@RequestBody Map<String,String> map){
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
		HashMap<String,Integer> hmap=new HashMap<String, Integer>();
		hmap.put("bidx", bidx);
		hmap.put("good", goodCount);
		totalboardservice.updateHumorBoardGood(hmap);
		response_map.put("goodCount",goodCount);
		return response_map;
	}

}
