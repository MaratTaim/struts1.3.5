package com.epam.testapp.model;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class News {

//	parameters must be not null
	public static final News EMPTY = new News();
	private int id;
	private String title = "";
	private String date  = new Date(new java.util.Date().getTime()).toString();
	private String brief = "";
	private String content = "";
	private boolean delete;

	public News() {}

	public News(int id, String title, String date, String brief, String content) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.brief = brief;
		this.content = content;
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "News{" +
				"id=" + id +
				", title='" + title + '\'' +
				", date=" + date +
				", brief='" + brief + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}