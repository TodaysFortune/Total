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

import com.team.dto.ITboardDTO;
import com.team.service.boardService;
import com.team.service.commentService;
import com.team.service.totalboardService;
import com.team.service.userinfoService;
import com.team.vo.ITboardList;
import com.team.vo.ITcommentList;

@Controller
public class ITBoardController {
	
	@Inject
	private totalboardService totalboardservice;
	@Inject
	private boardService boardservice;
	@Inject
	private userinfoService userinfoservice;
	@Inject
	private commentService commentservice;
	
	@RequestMapping("/main/itboard")
	public String boardList(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model) {
		int totalCount = boardservice.selectCount();
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITboardList iTboardList = ctx.getBean("ITboardList", ITboardList.class);
		
		iTboardList.initboardList(totalCount, currentPage);
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", iTboardList.getStartNo());
		hmap.put("noSize", iTboardList.getNoSize());
		
		iTboardList.setList(boardservice.selectList(hmap));//sql 이용해서 한페이지 게시글 리스트 초기화.
		model.addAttribute("boardList", iTboardList);
		return "ITboard";
	}
	@RequestMapping(value="/main/itboardsearch",method=RequestMethod.GET)
	public String boardSearch(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
		HttpServletRequest request,Model model) {
		
		String searchType=request.getParameter("searchType");
		String searchText=request.getParameter("searchText").trim();
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITboardList iTboardList = ctx.getBean("ITboardList", ITboardList.class);
		
		iTboardList.setSearchText(searchText);
		iTboardList.setSearchType(searchType);
		
		int totalCount = boardservice.selectTypeCount(iTboardList);
		
		iTboardList.initboardList(totalCount,currentPage);
		iTboardList.setList(boardservice.selectTypeList(iTboardList));
		
		model.addAttribute("boardList", iTboardList);
		model.addAttribute("searchType",searchType);
		model.addAttribute("searchText",searchText);
		
		return "ITboard";
	}
	@RequestMapping(value="/main/itboard/write",method=RequestMethod.GET)
	public String getWriteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,HttpSession session) {
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
	public String postWriteBoard(HttpSession session,
			@ModelAttribute("boardDTO") ITboardDTO iTboardDTO) {
		String Session_userID=(String)session.getAttribute("Session_userID");
		if(Session_userID!=null) {
			//레이스 컨디션 방지를 위해서
			//1.먼저 특정 boardnextval(#{category})를 얻어와서 임의의 변수 next_bidx에 대입시킨다. 
			int next_bidx=boardservice.selectBoardNextbidx(iTboardDTO.getCategory());
			//!!  select boardnextval(#{category})
			//2. 이제 레이스 컨디션의 문제는 사라졌으므로 , 획득한 next_bidx로 요리하면된다.
			//3.bidx, board_ref setter 등록해주고 , 게시글등록  
			iTboardDTO.setBidx(next_bidx);
			iTboardDTO.setBoard_ref(next_bidx);
			boardservice.insertBoard(iTboardDTO);
			totalboardservice.insertitBoard(iTboardDTO);
			
			//4.ITCommentRefsequences테이블의 레코드를 생성하는 프로시져 호출
			boardservice.callProcedure4sequence(next_bidx);
			
			return "redirect:../itboard";
		}
		return "redirect:../login";//글입력중 세션만료 걸렸을 경우
	}
	@RequestMapping(value="/main/itboard/increment",method=RequestMethod.GET)
	public String incrementBoard(HttpServletRequest request,Model model) {
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
			@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
			HttpServletRequest request,Model model) {
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
		
		//덧글 한페이지 얻기
		int comment_totalCount = commentservice.selectCount(bidx);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITcommentList iTcommentList = ctx.getBean("ITcommentList", ITcommentList.class);
		if(comment_totalCount!=0) {
			iTcommentList.initcommentList(comment_totalCount, comment_currentPage);
			HashMap<String, Integer> hmap = new HashMap<String, Integer>();
			hmap.put("startNo", iTcommentList.getStartNo());
			hmap.put("noSize", iTcommentList.getNoSize());
			hmap.put("bidx", bidx);
			iTcommentList.setList(commentservice.selectList(hmap));
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("boardDTO", itboardDTO);
		model.addAttribute("comment_currentPage", comment_currentPage);
		model.addAttribute("commentList", iTcommentList);
		model.addAttribute("comment_totalCount",comment_totalCount);
		model.addAttribute("enter", "\n");//개행문자처리
		return "contentView";
	}
	@RequestMapping(value = "main/itboard/contentView/update",method=RequestMethod.POST)
	public String getUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			Model model) { //오는것 bidx,currentPage
		ITboardDTO iTboardDTO=boardservice.selectBoard(bidx);
		
		model.addAttribute("boardDTO", iTboardDTO);
		model.addAttribute("currentPage", currentPage);
		return "update";
	}
	@RequestMapping(value = "main/itboard/contentView/updateBoard",method=RequestMethod.POST)
	public String postUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@ModelAttribute("boardDTO") ITboardDTO iTboardDTO,
			Model model) { //오는것 bidx,currentPage
		
		boardservice.updateBoard(iTboardDTO);
		totalboardservice.updateITBoard(iTboardDTO);
		
		model.addAttribute("bidx", iTboardDTO.getBidx());// bidx, currentPage가 잘 적용되는지 contentView 에서 볼것 됨. 아주좋아.
		model.addAttribute("currentPage", currentPage);
		return "redirect:../contentView";
	}
	@RequestMapping(value = "main/itboard/contentView/delete",method=RequestMethod.POST)
	public String deleteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			Model model) {  //오는것 bidx,currentPage
		boardservice.deleteBoard(bidx);
		totalboardservice.deleteITBoard(bidx);
		model.addAttribute("currentPage", currentPage);
		return "redirect:../../itboard";
	}
	@RequestMapping(value = "main/itboard/contentView/replyBoard",method=RequestMethod.GET)
	public String getReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,@ModelAttribute("boardDTO") ITboardDTO iTboardDTO,
			HttpSession session) {
		String name=userinfoservice.selectName((String)session.getAttribute("Session_userID"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("name", name);
		return "replyBoard";
	}
	@RequestMapping(value = "main/itboard/contentView/replyBoard",method=RequestMethod.POST)
	public String postReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,
			@ModelAttribute("boardDTO") ITboardDTO iTboardDTO) {
		//1.boardnextval에 의해 증가된 bidx를 우선적으로 받아와서 int next_bidx에 저장한다.  (레이스컨디션은 방지되었음)
		int next_bidx=boardservice.selectBoardNextbidx(iTboardDTO.getCategory());
		//2.이용할 ref는 기존의 iTboardDTO에 그대로 있음
		//3.next_bidx 를 iTboardDTO 에 등록
		iTboardDTO.setBidx(next_bidx);
		//4. 답변게시글등록
		boardservice.insertreplyBoard(iTboardDTO);
		//5. ITCommentRefsequences테이블의 레코드를 생성하는 프로시져 호출
		boardservice.callProcedure4sequence(next_bidx);
		
		model.addAttribute("currentPage", currentPage);
		return "redirect:../../itboard";
	}
	@RequestMapping(value = "/main/itboard/asyncGood", 
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
		totalboardservice.updateItBoardGood(hmap);
		response_map.put("goodCount",goodCount);
		return response_map;
	}

}
