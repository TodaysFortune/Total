package com.team.dto;

import java.util.Date;

public class TotalboardDTO {
	private Date writedate;
	private String url;
	private int bidx;
	private String subject;
	private int good;
	
	
	
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
		return "TotalboardDTO [writedate=" + writedate + ", url=" + url + ", bidx=" + bidx + ", subject=" + subject
				+ ", good=" + good + "]";
	}
	
	
}
