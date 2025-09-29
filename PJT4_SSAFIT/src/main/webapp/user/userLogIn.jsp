<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>SSAFIT 로그인</h1>

	<form action="user" method="POST">
	<input type="hidden" name="action" value="login">
	<div>이메일 : <input type="email" name="userEmail"></div> 
	<div>비밀번호 : <input type="password" name="userPassword"></div> 
	<button>로그인하기</button>

	</form>
	
	<a href="user?action=signupform">회원가입</a>

</body>
</html>