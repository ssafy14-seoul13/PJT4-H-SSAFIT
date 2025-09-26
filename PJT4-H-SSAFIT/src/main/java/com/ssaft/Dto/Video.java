package com.ssaft.Dto;

import java.util.Date;

public class Video {
	
	private int id;
	private int viewCnt;
	private String title;
	private String url;
	private String part;
	private String channelName;
	private Date regDate;
	
	public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(int id, int viewCnt, String title, String url, String part, String channelName, Date regDate) {
		this.id = id;
		this.viewCnt = viewCnt;
		this.title = title;
		this.url = url;
		this.part = part;
		this.channelName = channelName;
		this.regDate = regDate;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", viewCnt=" + viewCnt + ", title=" + title + ", url=" + url + ", part=" + part
				+ ", channelName=" + channelName + ", regDate=" + regDate + "]";
	}
	
	

}
