<%@page import="com.sample.dao.UserDao"%>
<%@page import="com.sample.dao.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
	%>
	
	<h1>사용자 등록 완료</h1>
	
	<dl>
		<dt>아이디</dt>
		<dd><%=id %></dd>
	</dl>
	<dl>
		<dt>비밀번호</dt>
		<dd><%=password %></dd>
	</dl>
	<dl>
		<dt>이름</dt>
		<dd><%=name %></dd>
	</dl>
	<dl>
		<dt>이메일</dt>
		<dd><%=email %></dd>
	</dl>
</body>
</html>