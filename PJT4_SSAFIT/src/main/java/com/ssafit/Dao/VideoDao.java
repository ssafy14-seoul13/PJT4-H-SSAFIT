package com.ssafit.Dao;

import java.util.List;

import com.ssafit.Dto.Video;

public interface VideoDao {
	
	// 영상 등록
	public abstract void insert(Video video);
	
	// 영상 선택(id를 통해)
	public abstract Video select(int id);
	
	// 영상 조회수 증가
	public abstract void updateViewCount(int id);
	
	// 영상 리스트 가져오기
	public abstract List<Video> selectAll();
	
	// 영상 삭제(id를 통해)
	public abstract void delete(int id);
	
	// 영상 업데이트
	public abstract void update(Video video);
	
}
