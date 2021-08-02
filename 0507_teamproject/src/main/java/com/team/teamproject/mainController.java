package com.team.teamproject;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.service.HumorboardService;
import com.team.service.boardService;
import com.team.service.totalboardService;
import com.team.vo.HumorboardList;
import com.team.vo.ITboardList;
import com.team.vo.TotalboardList;

@Controller
public class mainController {

	@Inject
	totalboardService totalboardservice;

	private static final Logger LOG = LoggerFactory.getLogger(mainController.class);

	@RequestMapping("/")
	public String welcome(Model model) {
		LOG.debug("welcome");
		totalboardservice.welcome(model);
		return "main";
	}

	@RequestMapping("/moveBoard")
	public String connectBoard(Model model,
			@RequestParam(value="bidx",required=true) int bidx,
			@RequestParam(value="url",required=true) String url){
		LOG.debug("connectBoard");
		totalboardservice.connectBoard(model,bidx);
		return "redirect:/"+url+"/contentView";
	}
	
	@RequestMapping("totalBoard")
	public String totalBoard(@RequestParam(value="itcurrentPage",required=false,defaultValue="1") int itcurrentPage,
			@RequestParam(value="humorcurrentPage",required=false,defaultValue="1") int humorcurrentPage,
			@RequestParam(value="totalcurrentPage",required=false,defaultValue="1") int totalcurrentPage,
			HttpServletRequest request,Model model){
		LOG.debug("totalBoard");
		totalboardservice.totalBoard(itcurrentPage,humorcurrentPage,totalcurrentPage,request,model);
		return "Totalboard";
	}

}
