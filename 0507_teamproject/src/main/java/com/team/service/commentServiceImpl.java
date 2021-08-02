package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.dao.commentDAO;
import com.team.dto.ITcommentDTO;

@Service
public class commentServiceImpl implements commentService{
	@Inject
	private commentDAO dao;
	@Inject
	private userinfoService userinfoservice;
	
	private static final Logger LOG = LoggerFactory.getLogger(commentServiceImpl.class);

	@Override
	public void insertComment(ITcommentDTO commentDTO) {
		LOG.debug("insertComment");
		dao.insertComment(commentDTO);
	}

	@Override
	public int ITcommentnextval(int bidx) {
		LOG.debug("ITcommentnextval");
		return dao.ITcommentnextval(bidx);
	}

	@Override
	public int selectCount(int bidx) {
		LOG.debug("selectCount");
		return dao.selectCount(bidx);
	}

	@Override
	public List<ITcommentDTO> selectList(HashMap<String, Integer> hmap) {
		LOG.debug("selectList");
		return dao.selectList(hmap);
	}

	@Override
	public void deleteComment(int cidx) {
		LOG.debug("deleteComment");
		dao.deleteComment(cidx);
	}

	@Override
	public String registerComment(int currentPage, int reply_comment_ref, int comment_currentPage,
			Authentication authentication, Model model, ITcommentDTO iTcommentDTO) {
		LOG.debug("registerComment");
		if(authentication==null)
			return "/login";
		String userid=authentication.getName();
		String username=userinfoservice.selectName(userid);
		iTcommentDTO.setId(userid);
		iTcommentDTO.setName(username);
		int bidx= iTcommentDTO.getBidx();
		if(reply_comment_ref==0) {//일반 덧글이 달릴경우
			int next_ref=this.ITcommentnextval(bidx);
			iTcommentDTO.setComment_ref(next_ref);
		}else {//대댓글이 달릴경우
			iTcommentDTO.setComment_ref(reply_comment_ref);
		}
		//4.덧글 테이블에 덧글삽입
		this.insertComment(iTcommentDTO);
		
		model.addAttribute("bidx",bidx);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("comment_currentPage", comment_currentPage);
		return "redirect:/itboard/contentView";
	}

	@Override
	public void deleteComment(ITcommentDTO iTcommentDTO, int currentPage, int comment_currentPage, Model model,
			Authentication authentication) {
		LOG.debug("deleteComment");
		LOG.debug("iTcommentDTO ={}",iTcommentDTO);
		if(authentication!=null && iTcommentDTO.getId().equals(authentication.getName()))
			this.deleteComment(iTcommentDTO.getCidx());
		model.addAttribute("bidx",iTcommentDTO.getBidx());
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("comment_currentPage",comment_currentPage);
	}
}
