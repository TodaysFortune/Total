package com.team.dto;

import java.util.Date;

public class TotalboardDTO {
	private Date writedate;
	private String url;
	private int bidx;
	private int board_hit;
	private String name;
	private String subject;
	private String content;
	private int good;
	
	
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getBoard_hit() {
		return board_hit;
	}


	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}


	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}



	public Date getWritedate() {
		return writedate;
	}



	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public int getBidx() {
		return bidx;
	}



	public void setBidx(int bidx) {
		this.bidx = bidx;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public int getGood() {
		return good;
	}



	public void setGood(int good) {
		this.good = good;
	}


	@Override
	public String toString() {
		return "TotalboardDTO [writedate=" + writedate + ", url=" + url + ", bidx=" + bidx + ", board_hit=" + board_hit
				+ ", name=" + name + ", subject=" + subject + ", content=" + content + ", good=" + good + "]";
	}




}
