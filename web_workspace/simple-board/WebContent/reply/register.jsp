<%@page import="com.simple.vo.Reply"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	int boardNo = Integer.parseInt(request.getParameter("boardno"));
	String content = request.getParameter("content");
	
	Reply reply = new Reply();
	reply.setWriter(loginedUserId);
	reply.setContent(content);
	reply.setBoardNo(boardNo);
	
	ReplyDao replyDao = new ReplyDao();
	replyDao.insertReply(reply);
	
	response.sendRedirect("../board/detail.jsp?no=" + boardNo);
%>