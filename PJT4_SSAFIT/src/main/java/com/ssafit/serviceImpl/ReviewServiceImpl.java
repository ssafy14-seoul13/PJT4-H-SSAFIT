package com.ssafit.serviceImpl;

import java.util.List;

import com.ssafit.Dao.ReviewDao;
import com.ssafit.DaoImpl.ReviewDaoImpl;
import com.ssafit.Dto.Review;
import com.ssafit.service.ReviewService;

public class ReviewServiceImpl implements ReviewService{
	
	//싱글턴
	private static ReviewService service = new ReviewServiceImpl();
	
	
	private ReviewServiceImpl() {
		
	}
	
	public static ReviewService getInstance() {
		return service;
	}

	private ReviewDao dao = ReviewDaoImpl.getInstance();
	
	@Override
	public void insertReview(Review review) {
		
		dao.insertReview(review);
	}

	@Override
	public void updateReview(Review review) {
		dao.updateReview(review);
		
	}

	@Override
	public void deleteReview(int videoId, int reviewId) {
		dao.deleteReview(videoId, reviewId);
		
	}

	@Override
	public Review selectOneReview(int videoId, int reviewId) {
	
		return dao.selectOneReview(videoId, reviewId);
	}

	@Override
	public List<Review> selectAllReview(int videId) {
		return dao.selectAllReview(videId);
	}

}
