package com.habuma.spitter.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3446362977544462065L;
	
	private int id;
	
	private String title;
	
	private String author;
	
	private String content;
	
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
