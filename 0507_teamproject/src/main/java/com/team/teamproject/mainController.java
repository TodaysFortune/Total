package com.team.teamproject;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
	boardService iTboardservice;
	@Inject
	HumorboardService humorboardservice;
	@Inject
	totalboardService totalboardservice;
	
	@RequestMapping(value= {"/","/main"})
	public String main(Model model) {
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		TotalboardList totalNewList=ctx.getBean("TotalboardList1",TotalboardList.class);
		TotalboardList totalGoodList=ctx.getBean("TotalboardList2",TotalboardList.class);
		ITboardList iTboardList=ctx.getBean("ITboardList",ITboardList.class);
		HumorboardList humorboardList=ctx.getBean("HumorboardList",HumorboardList.class);
				
		//15개씩 가져오기.
		int num=15;
		totalNewList.setList(totalboardservice.selectNewList(20));
		totalGoodList.setList(totalboardservice.selectGoodList(20));
		iTboardList.setList(iTboardservice.selectMainList(20));
		humorboardList.setList(humorboardservice.selectMainList(20));
		
		System.out.println("totalNewList :"+totalNewList);
		System.out.println("totalGoodList :"+totalGoodList);
		System.out.println("iTboardList :"+iTboardList);
		System.out.println("humorboardList :"+humorboardList);
		
		model.addAttribute("totalNewList", totalNewList);
		model.addAttribute("totalGoodList", totalGoodList);
		model.addAttribute("iTboardList", iTboardList);
		model.addAttribute("humorboardList", humorboardList);
		model.addAttribute("num",num);
		return "main";
	}
	
	@RequestMapping("main/moveBoard")
	public String test(Model model,
			@RequestParam(value="bidx",required=true) int bidx,
			@RequestParam(value="url",required=true) String url){
		model.addAttribute("bidx", bidx);
		return "redirect:"+url+"/contentView";
	}
	
}
