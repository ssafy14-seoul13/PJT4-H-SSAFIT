<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<table>
	<tr>
		<th>ID</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>조회수</th>
		<th>등록일</th>
	</tr>
</table>
<c:forEach items="${reviewList}" var="review">
	<tr>
		<td>${review.reviewId}</td>
		<td><a href="review?action=selReviewDtl&videoId=${review.videoId}&reviewId=${review.reviewId}">${review.title}</a></td>
		<td>${review.writer}</td>
		<td>${review.viewCnt}</td>
		<td>${review.regDate}</td>
	</tr>
</c:forEach>

<a href="review?action=insReviewForm&videoId=${video.id}">리뷰 작성</a>