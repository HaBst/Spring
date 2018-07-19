<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인페이지</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body>
<div style = "padding:5px">
<c:choose>
<c:when test="${sessionScope.member==null}">
<form action = "/login.do" method = "post">
ID : <input type ="text" placeholder = "아이디" class= "form-control" name = "userId" /><br>
PW : <input type = "password" placeholder = "비밀번호" class= "form-control" name = "userPw" /><br>
<input type = "submit" class = "form-control btn btn-primary" value = "로그인"/>
<a href = "/enrollPage.do" class = "form-control btn btn-primary">회원가입</a>
</form>
</c:when>

<c:otherwise>
<h1>[${sessionScope.member.userName}]님 환영합니다.</h1>
<a href = "/logout.do">로그아웃</a><br>
<a href = "/myInfo.do">마이정보 보기</a><br>
<a href = "/delete.do">회원 탈퇴</a><br>
<c:if test="${sessionScope.member.userId == 'admin'}"><br>
<a href = "/memberList.do">전체회원 보기[관리자 전용]</a><br>
</c:if>

</c:otherwise>

</c:choose>
</div>



</body>
</html>