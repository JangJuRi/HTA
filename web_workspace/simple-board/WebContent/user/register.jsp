<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	String password= request.getParameter("pwd");
	
	UserDao userDao = new UserDao();
	
	User findUser = userDao.getUserById(id);
	if(findUser != null) {
		response.sendRedirect("form.jsp?error=dup");
		return;
	}
	
	User user = new User();
	user.setName(name);
	user.setEmail(email);
	user.setId(id);
	user.setPassword(password);
	
	userDao.insertUser(user);
	
	response.sendRedirect("../home.jsp");
%>