<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 수정</title>
</head>
<body>
	<h2>리뷰 수정</h2>
	<form
		action="review?action=insReview&videoId=${videoId}&reviewId=${reviewId}"
		method="POST">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			작성자 : <input type="text" name="writer" value="익명">
		</div>
		<div>
			내용 :
			<textarea rows="10" cols="30" name="content"></textarea>
		</div>
		<button>등록</button>
		<a href="/video?action=selectVideoList&videoId=${videoId}">취소</a>
	</form>

</body>
</html>