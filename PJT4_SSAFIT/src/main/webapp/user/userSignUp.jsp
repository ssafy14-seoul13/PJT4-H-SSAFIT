<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>회원가입</title></head>
<body>
    <h3>회원가입</h3>
    <form action="${pageContext.request.contextPath}/user?action=signup" method="POST">
        ID: <input type="text" name="id"><br/>
        이름: <input type="text" name="name"><br/>
        <input type="submit" value="가입하기">
    </form>
    <a href="<%= request.getContextPath() %>/index.jsp">홈으로</a>
</body>
</html>