package com.team.teamproject;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.team.dto.ITboardDTO;
import com.team.service.boardService;

@Controller
public class ITBoardController {

	@Inject
	private boardService boardservice;

	private static final Logger LOG = LoggerFactory.getLogger(ITBoardController.class);

	@RequestMapping("/itboard")
	public String boardList(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model) {
		LOG.debug("boardList");
		boardservice.boardList(currentPage,model);
		return "ITboard";
	}
	@RequestMapping(value="/itboard/itboardsearch",method=RequestMethod.GET)
	public String boardSearch(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			HttpServletRequest request,Model model) {
		LOG.debug("boardSearch");
		boardservice.boardSearch(currentPage,request,model);
		return "ITboard";
	}

	@RequestMapping(value="/itboard/write",method=RequestMethod.GET)
	public String getWriteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,Authentication authentication) {
		LOG.debug("getWriteBoard");
		boardservice.getWriteBoard(currentPage,model,authentication);
		return "Write";
	}
	@RequestMapping(value="/itboard/write",method=RequestMethod.POST)
	public String postWriteBoard(@ModelAttribute("boardDTO") ITboardDTO iTboardDTO,Authentication authentication) {
		LOG.debug("postWriteBoard");
		boardservice.postWriteBoard(iTboardDTO,authentication);
		return "redirect:/itboard";
	}
	@RequestMapping(value="/itboard/increment",method=RequestMethod.GET)
	public String incrementBoard(HttpServletRequest request,Model model) {
		LOG.debug("incrementBoard");
		return boardservice.incrementBoard(request,model);
	}
	@RequestMapping(value="/itboard/contentView",method=RequestMethod.GET)
	public String boardContentView(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
			HttpServletRequest request,Model model,Authentication authentication) {
		LOG.debug("boardContentView");
		boardservice.boardContentView(currentPage,comment_currentPage,request,model,authentication);
		return "contentView";
	}
	@RequestMapping(value = "/itboard/contentView/update",method=RequestMethod.GET)
	public String getUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			@RequestParam(value="id",required=true,defaultValue="") String id,
			Model model,Authentication authentication) { 
		LOG.debug("getUpdateBoard");
		return boardservice.getUpdateBoard(currentPage,bidx,id,model,authentication);
	}
	@RequestMapping(value = "/itboard/contentView/updateBoard",method=RequestMethod.POST) 
	public String postUpdateBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@ModelAttribute("boardDTO") ITboardDTO iTboardDTO,
			Model model,Authentication authentication) { //오는것 bidx,currentPage
		LOG.debug("postUpdateBoard");
		boardservice.postUpdateBoard(currentPage,iTboardDTO,model,authentication);
		return "redirect:/itboard/contentView";
	}
	@RequestMapping(value = "/itboard/contentView/delete",method=RequestMethod.POST)
	public String deleteBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="bidx",required=true) int bidx,
			@RequestParam(value="id",required=true) String id,
			Model model,Authentication authentication) {  
		LOG.debug("deleteBoard");
		return boardservice.deleteBoard(currentPage,bidx,id,model,authentication);
	}
	@RequestMapping(value = "/itboard/contentView/replyBoard",method=RequestMethod.GET)
	public String getReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,@ModelAttribute("boardDTO") ITboardDTO iTboardDTO,
			Authentication authentication) {
		LOG.debug("getReplyBoard");
		boardservice.getReplyBoard(currentPage,model,iTboardDTO,authentication);
		return "replyBoard";
	}
	@RequestMapping(value = "/itboard/contentView/replyBoard",method=RequestMethod.POST)
	public String postReplyBoard(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			Model model,
			@ModelAttribute("boardDTO") ITboardDTO iTboardDTO,Authentication authentication) {
		LOG.debug("postReplyBoard");
		boardservice.postReplyBoard(currentPage,model,iTboardDTO,authentication);
		return "redirect:/itboard";
	}
	@RequestMapping(value = "/itboard/contentView/asyncGood",
			produces = { MediaType.APPLICATION_JSON_VALUE} , method=RequestMethod.POST)
	public @ResponseBody Map<String,Integer> clickGood(@RequestBody Map<String,String> map){
		LOG.debug("clickGood");
		return boardservice.clickGood(map);
	}
}
