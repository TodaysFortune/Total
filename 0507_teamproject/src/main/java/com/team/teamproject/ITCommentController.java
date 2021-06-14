package com.team.teamproject;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.dto.ITcommentDTO;
import com.team.service.commentService;
import com.team.service.userinfoService;

@Controller
public class ITCommentController {
	
	@Inject
	private userinfoService userinfoservice;
	@Inject
	private commentService commentservice;
	
	@RequestMapping(value="main/itboard/contentView/registerComment")
	String registerComment(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
				@RequestParam(value="reply_comment_ref",required=false,defaultValue="0") int reply_comment_ref,
				@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
			HttpSession session,Model model,
			@ModelAttribute("commentDTO") ITcommentDTO iTcommentDTO) {
		//currentPage,bidx,content,id(세션으로획득),name(sql로 획득),comment_ref(함수로획득)     
		System.out.println("CommentController-registerComment");
		
		String userid=(String)session.getAttribute("Session_userID");
		String username=userinfoservice.selectName(userid);
		iTcommentDTO.setId(userid);
		iTcommentDTO.setName(username);
		int bidx= iTcommentDTO.getBidx();
		if(reply_comment_ref==0) {//일반 덧글이 달릴경우
		//1.ITcommentnextval(bidx) 함수를 써서   int next_ref에 대입함
			int next_ref=commentservice.ITcommentnextval(bidx);
		//2.이제 레이스 컨디션 문제는 걱정안해도됨
		//3.next_ref를 iTcommentDTO의 ref에 대입 .
			iTcommentDTO.setComment_ref(next_ref);
		}else {//대댓글이 달릴경우
			iTcommentDTO.setComment_ref(reply_comment_ref);
		}
		//4.덧글 테이블에 덧글삽입
		commentservice.insertComment(iTcommentDTO);
		
		model.addAttribute("bidx",bidx);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("comment_currentPage", comment_currentPage);
		return "redirect:../contentView";
	}

	@RequestMapping(value="main/itboard/contentView/deleteComment")
	String deleteComment(@ModelAttribute("commentDTO") ITcommentDTO iTcommentDTO,
			@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			@RequestParam(value="comment_currentPage",required=false,defaultValue="1") int comment_currentPage,
			Model model) {
		commentservice.deleteComment(iTcommentDTO.getCidx());
		
		model.addAttribute("bidx",iTcommentDTO.getBidx());
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("comment_currentPage",comment_currentPage);
		return "redirect:../contentView";
	}
}