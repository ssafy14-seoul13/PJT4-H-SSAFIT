package com.ssafit.Dao;

import java.util.*;

import com.ssafit.Dto.Review;

public interface ReviewDao {
	
	// 리뷰 작성
	public abstract void insertReview(Review review);
	
	// 리뷰 수정 
	public abstract void updateReview(Review review);
	
	// 리뷰 삭제
	public abstract void deleteReview(int videoId, int reviewId);
	
	//리뷰 선택
	public abstract Review selectOneReview(int videoId, int reviewId);
	
	//리뷰 리스트
	public abstract List<Review> selectAllReview(int videId);
	
}
