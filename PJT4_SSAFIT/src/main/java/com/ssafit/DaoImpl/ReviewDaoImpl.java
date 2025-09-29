package com.ssafit.DaoImpl;

import java.util.*;

import com.ssafit.Dao.ReviewDao;
import com.ssafit.Dto.Review;

public class ReviewDaoImpl implements ReviewDao{

	private Map<Integer, Map<Integer,Review>> reviews = new HashMap<>();
	private static int reviewIdCounter = 1;
	
	// 싱글턴으로 구현
	private static ReviewDao reviewDao = new ReviewDaoImpl();
	
	private ReviewDaoImpl() {
	}
	
	public static ReviewDao getInstance() {
		return reviewDao;
	}
	
	
	@Override
	public void insertReview(Review review) {
		int videoId = review.getVideoId();
		
		// 해당 비디오의 맵이 없으면 새로 생성
		if(!reviews.containsKey(videoId)) {
			reviews.put(videoId, new HashMap<>());
		}
		
		//리뷰 번호 하나씩 증가시키며 추가 
		review.setReviewId(reviewIdCounter++);
		
		// 해당 비디오의 리뷰 맵에 리뷰 추가해넣기 
		reviews.get(videoId).put(review.getReviewId(), review);
		
	}

	@Override
	public void updateReview(Review review) {
		int videoId = review.getVideoId();
		int reviewId = review.getReviewId();
		// 해당 비디오의 해당 리뷰 -> 있으면 그 값에 새로 put
		if(reviews.containsKey(videoId) && reviews.get(videoId).containsKey(reviewId)) {
			reviews.get(videoId).put(reviewId, review);
		}
		
	}

	@Override
	public void deleteReview(int videoId, int reviewId) {
		
		if (reviews.containsKey(videoId)) {
			reviews.get(videoId).remove(reviewId);
		}
		
	}

	@Override
	public Review selectOneReview(int videoId, int reviewId) {
			
		return reviews.get(reviewDao).get(reviewId);
	}

	@Override
	public List<Review> selectAllReview(int videoId) {
		
		Map<Integer, Review> review = reviews.get(videoId);
	    if (reviews == null) {
	        return new ArrayList<>();
	    }
	    return new ArrayList<>(review.values());
	}

	
	
}
