package com.team.vo;

import java.util.ArrayList;
import java.util.List;

import com.team.dto.TotalboardDTO;


public class TotalboardList {
	private List<TotalboardDTO> list = new ArrayList<TotalboardDTO>();

	public List<TotalboardDTO> getList() {
		return list;
	}

	public void setList(List<TotalboardDTO> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "TotalboardList [list=" + list + "]";
	}
	
}
