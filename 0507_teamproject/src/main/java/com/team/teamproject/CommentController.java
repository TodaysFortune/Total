package com.team.teamproject;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.dto.ITcommentDTO;
import com.team.service.commentService;
import com.team.service.userinfoService;

@Controller
public class CommentController {
	
	@Inject
	private userinfoService userinfoservice;
	@Inject
	private commentService commentservice;
	
	@RequestMapping(value="main/itboard/contentView/registerComment")
	String registerComment(@RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage,
			HttpSession session,ITcommentDTO iTcommentDTO,Model model) {
		//currentPage,bidx,content,id(세션으로획득),name(sql로 획득),comment_ref(함수로획득)     
		System.out.println("CommentController-registerComment");
		
		String userid=(String)session.getAttribute("Session_userID");
		String username=userinfoservice.selectName(userid);
		iTcommentDTO.setId(userid);
		iTcommentDTO.setName(username);
		int bidx= iTcommentDTO.getBidx();
		
		//1.ITcommentnextval(bidx) 함수를 써서   int next_ref에 대입함
		int next_ref=commentservice.ITcommentnextval(bidx);
		//2.이제 레이스 컨디션 문제는 걱정안해도됨
		//3.next_ref를 iTcommentDTO의 ref에 대입 .
		iTcommentDTO.setComment_ref(next_ref);
		//4.덧글 테이블에 덧글삽입
		commentservice.insertComment(iTcommentDTO);
		
		model.addAttribute("bidx",bidx);
		model.addAttribute("currentPage", currentPage);
		return "redirect:../contentView";
	}
	
	
}
