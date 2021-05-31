package com.team.dto;

import java.util.Date;

public class ITcommentDTO {
	private int cidx;
	private int category=1;
	private int bidx;
	private String id;
	private String name;
	private Date writedate;
	private String content;
	private int comment_ref;
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getBidx() {
		return bidx;
	}
	public void setBidx(int bidx) {
		this.bidx = bidx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getComment_ref() {
		return comment_ref;
	}
	public void setComment_ref(int comment_ref) {
		this.comment_ref = comment_ref;
	}
	public int getCidx() {
		return cidx;
	}
	public void setCidx(int cidx) {
		this.cidx = cidx;
	}
	@Override
	public String toString() {
		return "ITcommentDTO [cidx=" + cidx + ", category=" + category + ", bidx=" + bidx + ", id=" + id + ", name="
				+ name + ", writedate=" + writedate + ", content=" + content + ", comment_ref=" + comment_ref + "]";
	}
	
}
