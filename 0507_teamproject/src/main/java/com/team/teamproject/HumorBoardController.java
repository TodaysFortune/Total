package com.team.teamproject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
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

	private static final Logger LOG = LoggerFactory.getLogger(HumorBoardController.class);

	@RequestMapping("/humorboard")
	public String boardList(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model) {
		LOG.debug("boardList");
		boardservice.boardList(currentPage,model);
		return "Humorboard";
	}
	@RequestMapping(value="/humorboard/humorboardsearch",method=RequestMethod.GET)
	public String boardSearch(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			HttpServletRequest request,Model model) {
		LOG.debug("boardSearch");
		boardservice.boardSearch(currentPage,request,model);
		return "Humorboard";
	}
	@RequestMapping(value="/humorboard/write",method=RequestMethod.GET)
	public String getWriteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,Authentication authentication) {
		LOG.debug("getWriteBoard");
		boardservice.getWriteBoard(currentPage,model,authentication);
		return "HumorWrite";
	}
	@RequestMapping(value="/humorboard/write",method=RequestMethod.POST)
	public String postWriteBoard(@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO) {
		LOG.debug("postWriteBoard");
		boardservice.postWriteBoard(humorboardDTO);
		return "redirect:/humorboard";
	}
	@RequestMapping(value="/humorboard/increment",method=RequestMethod.GET)
	public String incrementBoard(HttpServletRequest request,Model model) {
		LOG.debug("incrementBoard");
		return boardservice.incrementBoard(request,model);
	}
	@RequestMapping(value="/humorboard/contentView",method=RequestMethod.GET)
	public String boardContentView(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
			HttpServletRequest request,Model model,Authentication authentication) {
		LOG.debug("boardContentView");
		boardservice.boardContentView(currentPage,comment_currentPage,request,model,authentication);
		return "HumorcontentView";
	}
	@RequestMapping(value = "/humorboard/contentView/update",method=RequestMethod.GET)
	public String getUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			@RequestParam(value="id",required=true,defaultValue="") String id,
			Model model,Authentication authentication) { 
		LOG.debug("getUpdateBoard");
		return boardservice.getUpdateBoard(currentPage,bidx,id,model,authentication);
	}
	@RequestMapping(value = "/humorboard/contentView/updateBoard",method=RequestMethod.POST)
	public String postUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO,
			Model model,Authentication authentication) {  
		LOG.debug("postUpdateBoard");
		boardservice.postUpdateBoard(currentPage,humorboardDTO,model,authentication);
		return "redirect:/humorboard/contentView";
	}
	@RequestMapping(value = "/humorboard/contentView/delete",method=RequestMethod.POST)
	public String deleteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			@RequestParam(value="id",required=true) String id,
			Model model,Authentication authentication) {  //오는것 bidx,currentPage
		LOG.debug("deleteBoard");
		return boardservice.deleteBoard(currentPage,bidx,id,model,authentication);
	}
	@RequestMapping(value = "/humorboard/contentView/replyBoard",method=RequestMethod.GET)
	public String getReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO,
			Authentication authentication) {
		LOG.debug("getReplyBoard");
		boardservice.getReplyBoard(currentPage,model,humorboardDTO,authentication);
		return "HumorreplyBoard";
	}
	@RequestMapping(value = "/humorboard/contentView/replyBoard",method=RequestMethod.POST)
	public String postReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,
			@ModelAttribute("boardDTO") HumorboardDTO humorboardDTO,Authentication authentication) {
		LOG.debug("postReplyBoard");
		boardservice.postReplyBoard(currentPage,model,humorboardDTO,authentication);
		return "redirect:/humorboard";
	}
	@RequestMapping(value = "/humorboard/contentView/asyncGood", 
			produces = { MediaType.APPLICATION_JSON_VALUE} , method=RequestMethod.POST)
	public @ResponseBody Map<String,Integer> clickGood(@RequestBody Map<String,String> map){
		LOG.debug("clickGood");
		return boardservice.clickGood(map);
	}
}