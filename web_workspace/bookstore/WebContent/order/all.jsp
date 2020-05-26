<%@page import="com.bookstore.util.StringUtil"%>
<%@page import="com.bookstore.dto.UserDetailDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				OrderDao orderDao = new OrderDao(); 
				List<UserDetailDto> userDetailDtos;
			%>
			<%@include file="../common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>주문내역 조회</h1>
		</div>
		<div class="body">
			<%
				String genre = StringUtil.nullToBlank(request.getParameter("genre"));
			
				if(genre.isEmpty()) {
					userDetailDtos = orderDao.getAllOrders();
				} else {
					userDetailDtos = orderDao.getSelectOrders(genre);
				}
			%>
			<div>
				<div>
					<form method="get" action="all.jsp">
						<label>구분</label>
						<select name="genre">
							<option value=""			<%="".equals(genre) ? "selected" : "" %>>전체</option>
							<option value="소설"			<%="소설".equals(genre) ? "selected" : "" %>>소설</option>
							<option value="인문"			<%="인문".equals(genre) ? "selected" : "" %>>인문</option>
							<option value="경제"			<%="경제".equals(genre) ? "selected" : "" %>>경제</option>
							<option value="자연과학/공학"	<%="자연과학/공학".equals(genre) ? "selected" : "" %>>자연과학/공학</option>
							<option value="IT"			<%="IT".equals(genre) ? "selected" : "" %>>IT</option>
							<option value="외국어"		<%="외국어".equals(genre) ? "selected" : "" %>>외국어</option>
						</select>
						<button type="submit">검색</button>
					</form>
				</div>
				<div>
					<h3>주문내역 리스트</h3>
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
							for(UserDetailDto userDetailDto : userDetailDtos) {
						%>
							<tr>
								<td><%=userDetailDto.getNo() %></td>
								<td><%=userDetailDto.getName() %></td>
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
		</div>
		<%@include file="../common/footer.jsp" %>
	</div>
</body>
</html>