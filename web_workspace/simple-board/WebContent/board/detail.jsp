<%@page import="com.simple.dto.ReplyDto"%>
<%@page import="com.simple.vo.Reply"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@page import="com.simple.util.StringUtil"%>
<%@page import="com.simple.dto.BoardDto"%>
<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
<style>
	.bold-bordered {
		border-bottom: 1px double black;
	}
</style>
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글 상세정보</h1>
	</div>
	<div class="body">
	<%
		int boardNo = Integer.parseInt(request.getParameter("no"));
			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.getBoardByNo(boardNo);
 	%>
		<p>게시글의 내용을 확인하고, 댓글도 달아보세요.</p>
		<div>
			<table class="table bordered">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=boardDto.getTitle() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><a href="writer.jsp?userid=<%=boardDto.getWriter()%>"><%=boardDto.getWriterName() %></a></td>
						<th>등록일</th>
						<td><%=boardDto.getCreateDate() %></td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><%=boardDto.getHit() %></td>
						<th>댓글갯수</th>
						<td><%=boardDto.getReplyCnt() %></td>
					</tr>
					<tr>
						<th style="vertical-align: top;">내용</th>
						<td colspan="3" style="vertical-align:top; height:150px; min-height: 150px;"><%=StringUtil.strWithBr(boardDto.getContent()) %></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="text-right">
		<%
			if(boardDto.getWriter().equals(loginedUserId)) {
		%>
			[<a href="modifyform.jsp?no=<%=boardNo %>">수정하기</a>]
			[<a href="delete.jsp?no=<%=boardNo %>">삭제하기</a>]
		<%
			}
		%>
			[<a href="list.jsp">목록가기</a>]
		</div>
		
		<div>
			<p>댓글을 확인하세요.</p>
		<%
			ReplyDao replyDao = new ReplyDao();
			List<ReplyDto> replies = replyDao.getAllReplysByBoardNo(boardNo);
		%>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
				<%
					for(ReplyDto replyDto : replies) {
				%>
					<tr>
						<th>작성자</th>
						<td><%=replyDto.getWriterName() %></td>
						<th>등록일</th>
						<td><%=replyDto.getCreateDate() %></td>
					</tr>
					<tr class="bold-bordered">
						<th>내용</th>
						<td colspan="3"><%=StringUtil.strWithBr(replyDto.getContent()) %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
			<br/>
			<div class="well">
				<form method="post" action="../reply/register.jsp">
					<input type="hidden" name="boardno" value="<%=boardNo %>"/>
					<div class="form-group">
						<textarea rows="3" name="content"></textarea>
					</div>
					<div class="text-right">
						<button type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>