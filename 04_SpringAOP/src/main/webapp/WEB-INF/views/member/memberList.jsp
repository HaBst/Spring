<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 리스트</title>
</head>
<body>
<h1>회원 리스트</h1>
<table border="1">
	<tr><th>아이디</th><th>이름</th><th>전화번호</th></tr>
<c:forEach items = "${memberList}" var = "member">
	<tr>
		<td>${member.userId}</td>
		<td>${member.userName}</td>
		<td>${member.userPhone}</td>
	</tr>
</c:forEach>
</table>
<a href = "/home.do">메인으로 돌아가기</a>

</body>
</html>