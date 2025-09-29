package com.ssafit.controller;

import java.io.IOException;
import java.util.Date;

import com.ssafit.service.ReviewService;
import com.ssafit.Dto.Review;
import com.ssafit.serviceImpl.ReviewServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class ReviewController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    private ReviewService reviewService = ReviewServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        switch (action) {
            case "insReviewForm":
                doInsertReviewForm(request, response);
                break;
            case "insReview":
                doInsertReview(request, response);
                break;
            case "selReviewDtl":
                doSelectReviewDetail(request, response);
                break;
            case "updReviewForm":
                doUpdateReviewForm(request, response);
                break;
            case "updReview":
                doUpdateReview(request, response);
                break;
            case "delReview":
                doDeleteReview(request, response);
                break;
        }
    }

    private void doInsertReviewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/review/insert.jsp").forward(request, response);
    }

    private void doInsertReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");
        
        Review review = new Review(videoId, 0, writer, title, content, new Date());
        
        reviewService.insertReview(review);
        
        response.sendRedirect("video?action=selectVideoDetail&videoId=" + videoId);
    }

    private void doSelectReviewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        
        Review review = reviewService.selectOneReview(videoId, reviewId);
        
        request.setAttribute("review", review);
        request.getRequestDispatcher("/review/detail.jsp").forward(request, response);
    }

    private void doUpdateReviewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        
        Review review = reviewService.selectOneReview(videoId, reviewId);
        
        request.setAttribute("review", review);
        request.getRequestDispatcher("/review/update.jsp").forward(request, response);
    }

    private void doUpdateReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");
        
        Review review = new Review(videoId, reviewId, writer, title, content, new Date());
        
        reviewService.updateReview(review);
        
        response.sendRedirect("video?action=selectVideoDetail&videoId=" + videoId);
    }

    private void doDeleteReview(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        
        reviewService.deleteReview(videoId, reviewId);
        
        response.sendRedirect("video?action=selectVideoDetail&videoId=" + videoId);
    }
}
