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
		int num=10;
		totalNewList.setList(totalboardservice.selectNewList(num));
		totalGoodList.setList(totalboardservice.selectGoodList(num));
		iTboardList.setList(iTboardservice.selectMainList(num));
		humorboardList.setList(humorboardservice.selectMainList(num));
		
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
	
	@RequestMapping("main/totalBoard")
	public String totalBoard(@RequestParam(value="itcurrentPage",required=false,defaultValue="1") int itcurrentPage,
			@RequestParam(value="humorcurrentPage",required=false,defaultValue="1") int humorcurrentPage,
			@RequestParam(value="totalcurrentPage",required=false,defaultValue="1") int totalcurrentPage,
			HttpServletRequest request,Model model){
			String searchType=request.getParameter("searchType");
			String searchText=request.getParameter("searchText").trim();
			
			AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
			ITboardList itboardList = ctx.getBean("ITboardList", ITboardList.class);
			HumorboardList humorboardList = ctx.getBean("HumorboardList", HumorboardList.class);
			TotalboardList totalboardList = ctx.getBean("TotalboardList1", TotalboardList.class);
			
			itboardList.setSearchText(searchText);
			itboardList.setSearchType(searchType);
			humorboardList.setSearchText(searchText);
			humorboardList.setSearchType(searchType);
			totalboardList.setSearchText(searchText);
			totalboardList.setSearchType(searchType);
			
			int ittotalCount = iTboardservice.selectTypeCount(itboardList);
			int humortotalCount = humorboardservice.selectTypeCount(humorboardList);
			int totalCount = totalboardservice.selectTypeCount(totalboardList);
			
			itboardList.initboardList(ittotalCount,itcurrentPage);
			humorboardList.initboardList(humortotalCount,humorcurrentPage);
			totalboardList.initboardList(totalCount,totalcurrentPage);
			
			itboardList.setList(iTboardservice.selectTypeList(itboardList));
			humorboardList.setList(humorboardservice.selectTypeList(humorboardList));
			totalboardList.setList(totalboardservice.selectTypeList(totalboardList));
			
			model.addAttribute("itboardList", itboardList);
			model.addAttribute("humorboardList", humorboardList);
			model.addAttribute("totalboardList", totalboardList);
			model.addAttribute("searchType",searchType);
			model.addAttribute("searchText",searchText);
			return "Totalboard";
	}
	
}
