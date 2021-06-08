package com.team.dto;

import java.util.Date;

public class HumorboardDTO {
	private int bidx;
	private String id;
	private String name;
	private String subject;
	private String content;
	private int board_ref;
	private int board_hit;
	private Date writedate;
	private Date recentupdate;
	private int good;
	private int category=2;
	private String categoryname="humorboard";
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoard_ref() {
		return board_ref;
	}
	public void setBoard_ref(int board_ref) {
		this.board_ref = board_ref;
	}
	public int getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(int board_hit) {
		this.board_hit = board_hit;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	public Date getRecentupdate() {
		return recentupdate;
	}
	public void setRecentupdate(Date recentupdate) {
		this.recentupdate = recentupdate;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Override
	public String toString() {
		return "HumorboardDTO [bidx=" + bidx + ", id=" + id + ", name=" + name + ", subject=" + subject + ", content="
				+ content + ", board_ref=" + board_ref + ", board_hit=" + board_hit + ", writedate=" + writedate
				+ ", recentupdate=" + recentupdate + ", good=" + good + ", category=" + category + ", categoryname="
				+ categoryname + "]";
	}
	
	
	
	
}
