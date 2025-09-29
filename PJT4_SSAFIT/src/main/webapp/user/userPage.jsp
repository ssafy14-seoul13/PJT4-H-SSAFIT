<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 페이지</title>
</head>
<body>
	<h1>안녕하세요! ${user.userName}님</h1>

	<a href="user?action=logout&userId=${user.userId}">로그아웃</a>
	<a href="user?action=remove&userId=${user.userId}">회원탈퇴</a>
	<a href="main">메인으로 돌아가기</a>

</body>
</html>