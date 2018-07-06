<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- model 객체에 담은 것은 바로 key값으로 사용됨 
 ex) ModelAndView view = new ModelAndView();
 	view.addObject("mem",m);
	사용시 ${mem.name} --%>



<h2>회원정보</h2>
<form action = "/mUpdate.do" method = "post">
ID : <input type ="text" name = "userId" value = "${mem.userId}" readonly="readonly"/><br>
PW : <input type ="password" name = "userPw" value = "${mem.userPw}"/><br>
PW_re : <input type ="password" name = "userPw_re" value = "${mem.userPw}"/><br>
NAME : <input type ="text" name = "userName" value = "${mem.userName}" readonly="readonly"/><br>
PHONE : <input type ="text" name = "userPhone" value = "${mem.userPhone}"/><br>
<input type = "submit" value  = "수정"/>
</form>
</body>
</html>