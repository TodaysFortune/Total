package com.team.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.team.dao.HumorcommentDAO;
import com.team.dto.HumorcommentDTO;

@Service
public class HumorcommentServiceImpl implements HumorcommentService{
	@Inject
	private HumorcommentDAO dao;
	@Inject
	private userinfoService userinfoservice;

	private static final Logger LOG = LoggerFactory.getLogger(HumorcommentServiceImpl.class);

	@Override
	public void insertComment(HumorcommentDTO commentDTO) {
		LOG.debug("insertComment");
		dao.insertComment(commentDTO);
	}

	@Override
	public int Humorcommentnextval(int bidx) {
		LOG.debug("ITcommentnextval");
		return dao.Humorcommentnextval(bidx);
	}

	@Override
	public int selectCount(int bidx) {
		LOG.debug("selectCount");
		return dao.selectCount(bidx);
	}

	@Override
	public List<HumorcommentDTO> selectList(HashMap<String, Integer> hmap) {
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
			Authentication authentication, Model model,HumorcommentDTO humorcommentDTO) {
		LOG.debug("registerComment");
		if(authentication==null)
			return "/login";
		String userid=authentication.getName();
		String username=userinfoservice.selectName(userid);
		humorcommentDTO.setId(userid);
		humorcommentDTO.setName(username);
		int bidx= humorcommentDTO.getBidx();
		if(reply_comment_ref==0) {//일반 덧글이 달릴경우
			int next_ref=this.Humorcommentnextval(bidx);
			humorcommentDTO.setComment_ref(next_ref);
		}else {//대댓글이 달릴경우
			humorcommentDTO.setComment_ref(reply_comment_ref);
		}
		this.insertComment(humorcommentDTO);
		
		model.addAttribute("bidx",bidx);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("comment_currentPage", comment_currentPage);
		return "redirect:/humorboard/contentView";
	}

	@Override
	public void deleteComment(HumorcommentDTO humorcommentDTO, int currentPage, int comment_currentPage, Model model,
			Authentication authentication) {
		LOG.debug("deleteComment");
		LOG.debug("humorcommentDTO ={}",humorcommentDTO);
		if(authentication!=null && humorcommentDTO.getId().equals(authentication.getName()))
			this.deleteComment(humorcommentDTO.getCidx());
		model.addAttribute("bidx",humorcommentDTO.getBidx());
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("comment_currentPage",comment_currentPage);
	}
	
}
