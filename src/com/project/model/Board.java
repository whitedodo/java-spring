package com.project.model;

import java.sql.Date;

public class Board {
	
	private int id;
	private int category;
	private int reply;
	private String subject;
	private String content;
	private String writer;
	private int member_id;
	private String password;
	private int type;
	private int attach;
	private String uuid;
	private int count;
	private Date regidate;
	private String ip;
	private int article_id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategory() {
		return category;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	
	public int getReply() {
		return reply;
	}
	
	public void setReply(int reply) {
		this.reply = reply;
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
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public int getMember_id() {
		return member_id;
	}
	
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getAttach() {
		return attach;
	}
	
	public void setAttach(int attach) {
		this.attach = attach;
	}
	
	public String getUuid(){
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public Date getRegidate() {
		return regidate;
	}
	
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public int getArticle_id() {
		return article_id;
	}
	
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	
}
