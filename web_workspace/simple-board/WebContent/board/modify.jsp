<%@page import="com.simple.dto.BoardDto"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	int boardNo = Integer.parseInt(request.getParameter("no"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDao boardDao = new BoardDao();
	BoardDto boardDto = boardDao.getBoardByNo(boardNo);
	
	if(boardDto.getWriter().equals(loginedUserId)) {
		boardDto.setTitle(title);
		boardDto.setContent(content);
		
		boardDao.updateBoard(boardDto);
		
		response.sendRedirect("detail.jsp?no=" + boardNo);
	}
%>