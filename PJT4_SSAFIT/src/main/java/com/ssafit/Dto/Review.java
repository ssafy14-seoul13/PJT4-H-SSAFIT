package com.ssafit.Dto;

import java.util.Date;

public class Review {

	private int videoId;
	private int reviewId;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Review(int videoId, int reviewId, String writer, String title, String content, Date regDate) {
		this.videoId = videoId;
		this.reviewId = reviewId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}



	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}



	@Override
	public String toString() {
		return "Review [videoId=" + videoId + ", reviewId=" + reviewId + ", writer=" + writer + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}
	
}
