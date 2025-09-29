<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상목록</title>
</head>
<body>
	<table>
		<tr>
			<th>게시물 번호</th>
			<th>제목</th>
			<th>부위</th>
			<th>채널명</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${videos}" var="video" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><a href="video?action=selectVideoDetail&videoId=${video.id}">${video.title}</a></td>
				<td>${video.part}</td>
				<td>${video.channelName}</td>
                <td>${video.regDate}</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
