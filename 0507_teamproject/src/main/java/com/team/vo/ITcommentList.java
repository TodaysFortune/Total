package com.team.vo;

import java.util.ArrayList;
import java.util.List;

import com.team.dto.ITcommentDTO;

public class ITcommentList {
	List<ITcommentDTO> list = new ArrayList<ITcommentDTO>();
	private int noSize= 10;
	//private int PageSize = 10;
	private int totalCount = 0;//number of records
	private int totalPage = 0;
	private int currentPage =1; 
	private int startNo = 0;
	private int endNo = 0;
	private int startPage = 1;
	private int endPage = 0;
	public void initcommentList(int totalCount, int currentPage) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		calculator();
	}
	private void calculator() {
		totalPage = (totalCount -1) / noSize +1;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
		startNo = (currentPage - 1) * noSize; //mysql
		//startNo = (currentPage - 1) * pageSize+1; //oracle전용, 오라클은 인덱스가 1부터시작하기에
		endNo = startNo + noSize -1;  //$ db에 이 계산은 필요없을수 있음
		endNo = endNo > totalCount ? totalCount : endNo;//$ db에 이 계산은 필요없을수 있음
		//startPage = (currentPage - 1)/PageSize * PageSize + 1 ; 
		//endPage = startPage + PageSize-1;
		endPage = totalPage;
		//endPage = endPage > totalPage ? totalPage : endPage;
	}
	public List<ITcommentDTO> getList() {
		return list;
	}
	public void setList(List<ITcommentDTO> list) {
		this.list = list;
	}
	public int getNoSize() {
		return noSize;
	}
	public void setNoSize(int noSize) {
		this.noSize = noSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	@Override
	public String toString() {
		return "ITcommentList [list=" + list + ", noSize=" + noSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", currentPage=" + currentPage + ", startNo=" + startNo + ", endNo=" + endNo
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}

