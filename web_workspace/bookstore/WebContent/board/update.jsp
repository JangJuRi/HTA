<%@page import="com.bookstore.vo.Board"%>
<%@page import="com.bookstore.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int boardNo = Integer.parseInt(request.getParameter("no"));
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	int password = Integer.parseInt(request.getParameter("password"));
	
	BoardDao boardDao = new BoardDao();
	Board board = boardDao.getBoardByNo(boardNo);
	
	if(board.getPassword() != password) {
		response.sendRedirect("modifyform.jsp?boardno=" + boardNo + "&error=pwd");
	} else {
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		boardDao.updateBoard(board);
		
		response.sendRedirect("detail.jsp?boardno=" + boardNo);
	}
%>