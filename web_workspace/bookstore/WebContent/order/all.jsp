<%@page import="com.bookstore.dao.UserDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookstore.util.StringUtil"%>
<%@page import="com.bookstore.dto.UserDetailDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
<style type="text/css">
	label {
		font-weight: bold;
	}
	select {
		display: inline-block;
		width: 200px;
		height: 37px;
	}
	button {
		height: 37px;
	}
</style>
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "order";
				List<UserDetailDto> userDetailDtos;
			%>
			<%@include file="../common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>주문내역 조회</h1>
		</div>
		<div class="body">
			<%
				// 세션에서 조회한 회원정보로 그 회원의 주문내역을 조회한다.
				UserDao userDao = new UserDao();
				List<UserDetailDto> orders = userDao.getOrderByUserId(loginedUserId);
			%>
		
			<div>
				<p><strong><%=loginedUserName %></strong>님, 주문 내역을 확인하세요.</p>
				<table class="table">
					<thead>
						<tr>
							<th>주문번호</th>
							<th>사용자명</th>
							<th>제목</th>
							<th>주문가격</th>
							<th>구매수량</th>
							<th>결제금액</th>
							<th>주문날짜</th>
						</tr>
					</thead>
					<tbody>
					<%
						for(UserDetailDto userDetailDto : orders) {
					%>
						<tr>
							<td><%=userDetailDto.getNo() %></td>
							<td><%=loginedUserName %></td>
							<td><%=userDetailDto.getTitle() %></td>
							<td><%=userDetailDto.getPrice() %></td>
							<td><%=userDetailDto.getAmount() %></td>
							<td><%=userDetailDto.getOrderPrice() %></td>
							<td><%=userDetailDto.getRegisteredDate() %></td>
						</tr>
					<%
						}
					%>
					</tbody>
				</table>
			</div>
		</div>
		<%@include file="../common/footer.jsp" %>
	</div>
</body>
</html>