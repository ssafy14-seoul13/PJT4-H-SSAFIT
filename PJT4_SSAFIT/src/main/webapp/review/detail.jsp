<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰상세</title>
</head>
<body>
	<h2>${review.title}</h2>
	<div>
		${review.content}
	</div>
	
	<a href="video?action=selectVideoList&videoId=${review.videoId}&">영상번호</a>
	<a href="review?action=delReview&videoId=${review.videoId}&reviewId=${review.reviewId}">리뷰번호1</a>
	<a href="review?action=updReviewForm&videoId=${review.videoId}&reviewId=${review.reviewId}">리뷰번호2</a>
</body>
</html>