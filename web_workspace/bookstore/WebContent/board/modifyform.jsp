<%@page import="com.bookstore.vo.Board"%>
<%@page import="com.bookstore.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
	<%
		int boardNo = Integer.parseInt(request.getParameter("boardno"));
		String error = request.getParameter("error");
		
		BoardDao boardDao = new BoardDao();
		Board board = boardDao.getBoardByNo(boardNo);
		
		if("pwd".equals(error)) {
			// 추가해야됨
		}
	%>

<div class="wrapper">
	<div class="navi">
		<%
			String position = "board";
		%>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글 수정</h1>
	</div>
	<div class="body">
		<p>게시글 정보확인하고 수정하세요.</p>
		<div class="well">
			<form method="post" action="update.jsp">
				<input type="hidden" name="no" value="<%=boardNo %>" />
				<div class="form-group">
					<label>제목</label>
					<div><input type="text" name="title" value="<%=board.getTitle()%>"/></div>
				</div>
				<div class="form-group">
					<label>작성자</label>
					<div><input type="text" name="writer" value="<%=board.getWriter()%>"/></div>
				</div>
				<div class="form-group">
					<label>내용</label>
					<div><textarea rows="6" name="content"><%=board.getContent() %></textarea> </div>
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<div><input type="password" name="password" maxlength="4"/></div>
				</div>
				<div class="text-right">
					<button type="submit">수정</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>