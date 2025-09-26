<%@ page language="java" contentType="text/html ; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>SSAFIT 회원가입</h1>

	<form action="user" method="POST">
		<input type="hidden" name="act" value="signup">
		<div>
			닉네임 : <input type="text" name="userNickName">
		</div>
		<div>
			이메일 : <input type="email" name="userEmail">
		</div>
		<div>
			비밀번호 : <input type="password" name="userPassword">
		</div>
		<button>회원가입하기</button>
</body>
</html>