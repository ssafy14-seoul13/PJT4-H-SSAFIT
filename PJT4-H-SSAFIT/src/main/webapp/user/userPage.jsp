<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 페이지</title>
</head>
<body>
	<h1>안녕하세요!</h1>

	<a href="user?act=signout&userId=${user.userId}">로그아웃</a>
	<a href="user?act=remove&userId=${user.userId}">회원탈퇴</a>

</body>
</html>