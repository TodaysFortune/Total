package com.team.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.dao.boardDAO;
import com.team.dto.ITboardDTO;
import com.team.vo.ITboardList;
import com.team.vo.ITcommentList;

@Service
public class boardServiceImpl implements boardService {
	@Inject
	private boardDAO dao;
	@Inject
	private userinfoService userinfoservice;
	@Inject
	private totalboardService totalboardservice;
	@Inject
	private commentService commentservice;

	private static final Logger LOG = LoggerFactory.getLogger(boardServiceImpl.class);
	
	@Override
	public int selectCount() {
		//서비스로직 부분
		LOG.debug("selectCount");
		return dao.selectCount();
	}

	@Override
	public List<ITboardDTO> selectList(HashMap<String, Integer> hmap) {
		//서비스로직 부분
		LOG.debug("selectList");
		return dao.selectList(hmap);
	}

	@Override
	public int selectTypeCount(ITboardList boardList) {
		
		LOG.debug("selectTypeCount");
		if(boardList.getSearchText().length()==0 ||
				boardList.getSearchType().equals("recommendedNumber"))//검색창에 아무것도 안썻을 경우 || 추천글을 눌렀을 경우
			return dao.selectCount();//일반 게시판첫페이지를 호출할 경우와 같은 효과
		return dao.selectTypeCount(boardList);
	}

	@Override
	public List<ITboardDTO> selectTypeList(ITboardList boardList) {
		LOG.debug("selectTypeList");
		return dao.selectTypeList(boardList);
	}

	@Override
	public void insertBoard(ITboardDTO boardDTO) {
		LOG.debug("insertBoard");
		dao.insertBoard(boardDTO);
	}

	@Override
	public void incrementBoard(int bidx) {
		LOG.debug("incrementBoard");
		dao.incrementBoard(bidx);
	}

	@Override
	public ITboardDTO selectBoard(int bidx) {
		LOG.debug("selectBoard");
		return dao.selectBoard(bidx);
	}

	@Override
	public int selectGoodChecked(Map<String, String> map) {
		LOG.debug("selectGoodChecked");
		return dao.selectGoodChecked(map);
	}
	@Override
	public void updateGoodup(Map<String, String> map) {
		LOG.debug("updateGoodup");
		dao.updateGoodup(map);
	}

	@Override
	public void updateGooddown(Map<String, String> map) {
		LOG.debug("updateGooddown");
		dao.updateGooddown(map);
	}

	@Override
	public int selectGoodCount(int bidx) {
		LOG.debug("selectGoodCount");
		return dao.selectGoodCount(bidx);
	}

	@Override
	public void updateGooddownBoard(int bidx) {
		LOG.debug("updateGooddownBoard");
		dao.updateGooddownBoard(bidx);
	}

	@Override
	public void updateGoodupBoard(int bidx) {
		LOG.debug("updateGoodupBoard");
		dao.updateGoodupBoard(bidx);
	}

	@Override
	public void updateBoard(ITboardDTO boardDTO) {
		LOG.debug("updateBoard");
		dao.updateBoard(boardDTO);
		
	}

	@Override
	public void deleteBoard(int bidx) {
		LOG.debug("deleteBoard");
		dao.deleteBoard(bidx);
	}


	@Override
	public void insertreplyBoard(ITboardDTO boardDTO) {
		LOG.debug("insertreplyBoard");
		dao.insertreplyBoard(boardDTO);
	}

	@Override
	public int selectBoardNextbidx(int category) {
		LOG.debug("selectBoardNextbidx");
		return dao.selectBoardNextbidx(category);
	}

	@Override
	public void callProcedure4sequence(int next_bidx) {
		LOG.debug("callProcedure4sequence");
		dao.callProcedure4sequence(next_bidx);
	}

	@Override
	public List<ITboardDTO> selectMainList(int num) {
		LOG.debug("selectMainList");
		return dao.selectMainList(num);
	}

	@Override
	public void boardList(int currentPage, Model model) {
		LOG.debug("boardList");
		int totalCount = this.selectCount();

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITboardList iTboardList = ctx.getBean("ITboardList", ITboardList.class);

		iTboardList.initboardList(totalCount, currentPage);

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("startNo", iTboardList.getStartNo());
		hmap.put("noSize", iTboardList.getNoSize());

		iTboardList.setList(this.selectList(hmap));//sql 이용해서 한페이지 게시글 리스트 초기화.
		model.addAttribute("boardList", iTboardList);
	}

	@Override
	public void boardSearch(int currentPage, HttpServletRequest request, Model model) {
		LOG.debug("boardSearch");
		String searchType=request.getParameter("searchType");
		String searchText=request.getParameter("searchText").trim();

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		ITboardList iTboardList = ctx.getBean("ITboardList", ITboardList.class);

		iTboardList.setSearchText(searchText);
		iTboardList.setSearchType(searchType);

		int totalCount = this.selectTypeCount(iTboardList);

		iTboardList.initboardList(totalCount,currentPage);
		iTboardList.setList(this.selectTypeList(iTboardList));

		model.addAttribute("boardList", iTboardList);
		model.addAttribute("searchType",searchType);
		model.addAttribute("searchText",searchText);
	}

	@Override
	public void getWriteBoard(int currentPage, Model model, Authentication authentication) {
		LOG.debug("getWriteBoard");
		String userID=authentication.getName();
		String userName=userinfoservice.selectName(userID);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("name", userName);
		model.addAttribute("id",userID);
	}

	@Override
	public void postWriteBoard(ITboardDTO iTboardDTO, Authentication authentication) {
		LOG.debug("postWriteBoard");
		int next_bidx=this.selectBoardNextbidx(iTboardDTO.getCategory());
		iTboardDTO.setBidx(next_bidx);
		iTboardDTO.setBoard_ref(next_bidx);
		this.insertBoard(iTboardDTO);
		totalboardservice.insertitBoard(iTboardDTO);
		this.callProcedure4sequence(next_bidx);
	}

	@Override
	public String incrementBoard(HttpServletRequest request, Model model) {
		LOG.debug("incrementBoard");
		String currentPage=request.getParameter("currentPage");
		model.addAttribute("currentPage", currentPage);
		int bidx;
		try { //이미 게시판이 삭제되었을 경우, 예외처리 
			bidx=Integer.valueOf(request.getParameter("bidx"));
		}catch(Exception e) {		
			return "redirect:/itboard";
		}
		model.addAttribute("bidx", bidx);
		this.incrementBoard(bidx);
		totalboardservice.incrementItBoard(bidx);

		return "redirect:/itboard/contentView";
	}

	@Override
	public void boardContentView(int currentPage, int comment_currentPage, HttpServletRequest request, Model model,
			Authentication authentication) {
		LOG.debug("boardContentView");
		int bidx=Integer.valueOf(request.getParameter("bidx"));
		ITboardDTO itboardDTO=this.selectBoard(bidx);

		//bidx,사용자아이디를 얻어서  boardservice.selectGoodChecked(map)==1 여부에 따라 초기 하트를 결정함
		Map<String,String> map=new HashMap<String, String>();
		model.addAttribute("heart",0);//비로그인 상태일 경우 , 좋아요를 누른이력이 없는 경우
		if(authentication!=null) {
			map.put("bidx", request.getParameter("bidx"));
			map.put("id",authentication.getName());
			if(this.selectGoodChecked(map)==1) //좋아요 누른 이력이 있다면 , 꽉찬 하트이미지로 보이기
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
	}

	@Override
	public String getUpdateBoard(int currentPage, int bidx, String id, Model model, Authentication authentication) {
		LOG.debug("getUpdateBoard");
		if(authentication!=null && id.equals(authentication.getPrincipal())) {
			model.addAttribute("currentPage", currentPage);
			ITboardDTO iTboardDTO=this.selectBoard(bidx);
			model.addAttribute("boardDTO", iTboardDTO);
			return "update";
		}
		return "redirect:/itboard/contentView?currentPage="+currentPage+"&bidx="+bidx;
	}

	@Override
	public void postUpdateBoard(int currentPage, ITboardDTO iTboardDTO, Model model, Authentication authentication) {
		LOG.debug("postUpdateBoard");
		model.addAttribute("bidx", iTboardDTO.getBidx());// bidx, currentPage가 잘 적용되는지 contentView 에서 볼것 됨. 아주좋아.
		model.addAttribute("currentPage", currentPage);
		if(authentication!=null && iTboardDTO.getId().equals(authentication.getPrincipal())) {
			this.updateBoard(iTboardDTO);
			totalboardservice.updateITBoard(iTboardDTO);
		}
	}

	@Override
	public String deleteBoard(int currentPage, int bidx, String id, Model model, Authentication authentication) {
		LOG.debug("deleteBoard");
		model.addAttribute("currentPage", currentPage);
		if(authentication!=null && id.equals(authentication.getPrincipal())) {
			this.deleteBoard(bidx);
			totalboardservice.deleteITBoard(bidx);
			return "redirect:/itboard";
		}
		return "redirect:/itboard/contentView?currentPage="+currentPage+"&bidx="+bidx;
	}

	@Override
	public void getReplyBoard(int currentPage, Model model, ITboardDTO iTboardDTO, Authentication authentication) {
		LOG.debug("getReplyBoard");
		String name=userinfoservice.selectName(authentication.getName());
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("name", name);
	}

	@Override
	public void postReplyBoard(int currentPage, Model model, ITboardDTO iTboardDTO, Authentication authentication) {
		LOG.debug("postReplyBoard");
		if(authentication!=null) {
			int next_bidx=this.selectBoardNextbidx(iTboardDTO.getCategory());
			iTboardDTO.setBidx(next_bidx);
			this.insertreplyBoard(iTboardDTO);
			this.callProcedure4sequence(next_bidx);
		}
		model.addAttribute("currentPage", currentPage);
	}

	@Override
	public Map<String, Integer> clickGood(Map<String, String> map) {
		LOG.debug("clickGood");
		Map<String,Integer> response_map=new HashMap<String, Integer>();
		int bidx=Integer.valueOf(map.get("bidx"));
		if(this.selectGoodChecked(map)==1) {//특정아이디에 해당하는 이미 좋아요 누른 상태이면
			//좋아요를 해제
			this.updateGooddown(map);
			//clicked= 0도 반환
			response_map.put("clicked", 0);
			//특정 itboard 테이블의 good 변경
			this.updateGooddownBoard(bidx);
		}else {//좋아요가 안눌린 상태라면
			//좋아요를 넣어주기
			this.updateGoodup(map);
			//clicked= 1도 반환
			response_map.put("clicked", 1);
			//특정 itboard 테이블의 good 변경
			this.updateGoodupBoard(bidx);
		}
		//총좋아요갯수반환
		int goodCount=this.selectGoodCount(bidx);
		HashMap<String,Integer> hmap=new HashMap<String, Integer>();
		hmap.put("bidx", bidx);
		hmap.put("good", goodCount);
		totalboardservice.updateItBoardGood(hmap);
		response_map.put("goodCount",goodCount);
		return response_map;
	}
}
