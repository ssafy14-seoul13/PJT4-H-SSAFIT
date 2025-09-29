package com.ssafit.service;

import java.util.*;

import com.ssafit.Dto.Review;

public interface ReviewService {

	// 리뷰 작성
		public abstract void insertReview(Review reivew);
		
		// 리뷰 수정 
		public abstract void updateReview(Review review);
		
		// 리뷰 삭제
		public abstract void deleteReview(int videoId, int reviewId);
		
		//리뷰 선택
		public abstract Review selectOneReview(int videoId, int reviewId);
		
		//리뷰 리스트
		public abstract List<Review> selectAllReview(int videId);
	
}
