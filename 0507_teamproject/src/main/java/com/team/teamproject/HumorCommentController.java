package com.team.teamproject;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.dto.HumorcommentDTO;
import com.team.service.HumorcommentService;
import com.team.service.userinfoService;

@Controller
public class HumorCommentController {
	
	@Inject
	private HumorcommentService commentservice;
	
	private static final Logger LOG = LoggerFactory.getLogger(HumorCommentController.class);
	
	@RequestMapping(value="/humorboard/contentView/registerComment",method=RequestMethod.POST)
	String registerComment(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
				@RequestParam(value="reply_comment_ref",required=false,defaultValue="0") int reply_comment_ref,
				@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
				Authentication authentication,Model model,
			@ModelAttribute("commentDTO") HumorcommentDTO humorcommentDTO) {
		LOG.debug("registerComment");
		return commentservice.registerComment(currentPage,reply_comment_ref,comment_currentPage,authentication,model,humorcommentDTO);
	}

	@RequestMapping(value="/humorboard/contentView/deleteComment",method=RequestMethod.POST)
	String deleteComment(@ModelAttribute("commentDTO") HumorcommentDTO humorcommentDTO,
			@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
			Model model,Authentication authentication) {
		LOG.debug("deleteComment");
		commentservice.deleteComment(humorcommentDTO,currentPage,comment_currentPage,model,authentication);
		return "redirect:/humorboard/contentView";
	}
}
