<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 상세 페이지</title>
</head>
<body>
	<iframe width="560" height="315" src="${video.url}" title="${video.title}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
	<h2>${video.title}</h2>
	<table>
	<thead>
		<tr>
			<th>조회수</th>
			<th>부위</th>
			<th>채널명</th>
		<tr>
	</thead>
	<tbody>
		<tr>
			<td>${video.viewCnt}</td>
			<td>${video.part}</td>
			<td>${video.channelName}</td>
		</tr>
	</tbody>
	</table>
	<hr>
	<%@ include file="/review/list.jsp"%>

	<a href="${pageContext.request.contextPath}/main">돌아가기</a>

</body>
</html>