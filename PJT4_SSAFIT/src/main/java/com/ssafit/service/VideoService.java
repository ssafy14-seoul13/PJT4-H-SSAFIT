package com.ssafit.service;

import java.util.List;

import com.ssafit.Dto.Video;

public interface VideoService {
	
	// 영상 등록
	public abstract void ins(Video video);
	
	// 영상 선택
	public abstract Video selDtl(int id);
	
	// 영상 조회수 증가 
	public abstract void updViewCnt(int id);
	
	// 영상 리스트 
	public abstract List<Video> selList();
	
	// 영상 삭제
	public abstract void del(int id);
	
	// 영상 수정
	public abstract void upd(Video video);
}
