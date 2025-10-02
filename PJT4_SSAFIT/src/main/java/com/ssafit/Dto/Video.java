package com.ssafit.Dto;

import java.sql.Timestamp;

public class Video {
	
	private int id;
	private int viewCnt;
	private String title;
	private String url;
	private String part;
	private String channelName;
	private Timestamp regDate;
	
	public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(String title, String url, String part, String channelName) {
		this.viewCnt = 0;
		this.title = title;
		this.url = url;
		this.part = part;
		this.channelName = channelName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", viewCnt=" + viewCnt + ", title=" + title + ", url=" + url + ", part=" + part
				+ ", channelName=" + channelName + ", regDate=" + regDate + "]";
	}
	
	

}
