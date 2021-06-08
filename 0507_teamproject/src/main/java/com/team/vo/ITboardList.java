package com.team.vo;

import java.util.ArrayList;
import java.util.List;

import com.team.dto.ITboardDTO;


public class ITboardList {
	private List<ITboardDTO> list = new ArrayList<ITboardDTO>();
	private int noSize= 10;
	private int PageSize = 10;
	private int totalCount = 0;//number of records
	private int totalPage = 0;
	private int currentPage =1; 
	private int startNo = 0;
	private int endNo = 0;
	private int startPage = 0;
	private int endPage = 0;
	private String searchType=null;
	private String searchText=null;
	
	//pageSize,totalCount,currentPage를 넘겨받아 페이지 작업에 사용할  4개의 변수를 초기화 시키는 메소드
	public void initboardList(int totalCount, int currentPage) {
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
		startPage = (currentPage - 1)/PageSize * PageSize + 1 ; 
		endPage = startPage + PageSize-1;
		endPage = endPage > totalPage ? totalPage : endPage;
	}



	public List<ITboardDTO> getList() {
		return list;
	}

	public void setList(List<ITboardDTO> list) {
		this.list = list;
	}

	public int getNoSize() {
		return noSize;
	}

	public void setNoSize(int noSize) {
		noSize = noSize;
	}

	public int getPageSize() {
		return PageSize;
	}

	public void setPageSize(int pageSize) {
		PageSize = pageSize;
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

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "ITboardList [list=" + list + ", noSize=" + noSize + ", PageSize=" + PageSize + ", totalCount="
				+ totalCount + ", totalPage=" + totalPage + ", currentPage=" + currentPage + ", startNo=" + startNo
				+ ", endNo=" + endNo + ", startPage=" + startPage + ", endPage=" + endPage + ", searchType="
				+ searchType + ", searchText=" + searchText + "]";
	}

	
}
