package com.example.demo.dto;

import java.util.Map;

public class ArticleReply {
	private int id;
	private String regDate;
	private String body;
	private int articleId;
	private int memberId;
	private Map<String, Object> extra;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Map<String, Object> getExtra() {
		return extra;
	}
	public void setExtra(Map<String, Object> extra) {
		this.extra = extra;
	}
	
	
}
