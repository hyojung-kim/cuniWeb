package com.example.demo.dto;

import java.util.HashMap;
import java.util.Map;

public class Article {
	private int id;
	private String regDate;
	private String title;
	private String body;
	private int boardId;
	private int memberId;
	private int hit;
	private Map<String, Object> extra;
	
	
	public Map<String, Object> getExtra() {
		return extra;
	}
	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	

}
