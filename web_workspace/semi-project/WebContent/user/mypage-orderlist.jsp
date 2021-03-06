<%@page import="com.br.vo.Pagenation"%>
<%@page import="com.br.vo.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.br.vo.Order"%>
<%@page import="com.br.utils.NumberUtil"%>
<%@page import="com.br.dto.OrderDto"%>
<%@page import="com.br.vo.User"%>
<%@page import="com.br.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="com.br.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<body>
	<div class="wrapper">
		<div class="header">
			<%@ include file="/common/header.jsp"%>
		</div>
		<div class="navi">
			<%
				String position = "order";
			%>
			<%@ include file="/common/navi.jsp"%>
		</div>
		<div class="body">
			<%
			UserDao userDao = new UserDao();
			User user = userDao.getUserById(loginedUserId);
			
			OrderDao orderDao = new OrderDao();
			
			/* 페이징 처리 */
			int pageNo = NumberUtil.stringToInt(request.getParameter("page"),1);
			int totalRows = orderDao.getTotal(loginedUserId);
			Pagenation pagenation = new Pagenation(5, 5, pageNo, totalRows);
			List<OrderDto> orderDtos = orderDao.getOrderByUserId(loginedUserId, pagenation.getBeginIndex(), pagenation.getEndIndex());
			
			
			List<OrderDto> orders = orderDao.getOrderByOrderNo(174);
		%>
			<div class="container">
				<div class="content-header text-center">
					<h1 class="display-4">MY PAGE</h1>
					<p>
						<strong>회원님을 위한 베스킨라빈스의 다양한 정보</strong>
					</p>
				</div>
				<div class="custom-content-box">
					<hr />
					<%
						String myPagePosition = "myOrderlist";
					%>
					<!-- mypage-nav start -->
					<%@ include file="mypage-navi.jsp"%>
					<!-- mypage-nav end -->
					<!-- mypage-orderlist content start -->
					<!-- 서버에서 주문정보 불러와서 테이블 형태로 화면에 나타내기 -->
					<div class="row content-header text-center">
						<div class="col-12">
							<h2 class="text-info"><%=loginedUserName %>님의 주문내역입니다.
							</h2>
						</div>
					</div>
					<div class="row content-header">
						<div class="col-12">
							<h4>나의 주문내역</h4>
							<hr />
							<div class="my-order-table">
								<table class="table table-borered">
									<thead>
										<tr>
											<th>상품명</th>
											<th>결제금액</th>
											<th>구매일</th>
											<th>상세내역</th>
										</tr>
									</thead>
									<tbody>
										<%
										if (!orderDtos.isEmpty()) {
									
											for (OrderDto orderDto : orderDtos) {
											
									%>
										<tr>
											<!-- modal -->

											<!-- modal end -->
											<td><%=orderDto.getName() %><%=orderDto.getOrderProductAmount()>1 ? "외" + (orderDto.getOrderProductAmount()-1) + "건" : " " %></td>
											<td><%=NumberUtil.numberWithComma(orderDto.getPayment()) %></td>
											<td><%=orderDto.getRegDate()%></td>
											<td><button class="btn btn-primary"
													onclick="openPopup(<%=orderDto.getOrderNo() %>, event, <%=orderDto.getProductNo()%>)"
													data-toggle="modal" data-target="#product-detail-01">상세내역</button></td>
										</tr>
										<%
											}
										} else {
									%>
										<tr class="text-center">
											<td colspan="5">주문내역이 존재하지 않습니다.</td>
										</tr>
										<% 
										}
									%>
									</tbody>
								</table>
								<!--  페이지 처리 시작 -->
								<ul class="pagination justify-content-center"
									style="margin: 20px 0">

									<%
										if (pagenation.getPageNo() > 1) {
									%>
									<li class="page-item"><a class="page-link"
										href="mypage-orderlist.jsp?page=<%=pagenation.getPageNo() - 1%>">이전</a></li>
									<%
										}

										for (int num = pagenation.getBeginPage(); num <= pagenation.getEndPage(); num++) {
									%>

									<li class="page-item"><a
										class="page-link <%=num == pageNo ? "active" : ""%>"
										href="mypage-orderlist.jsp?page=<%=num%>"><%=num%></a></li>

									<%
										}

										if (pagenation.getPageNo() < pagenation.getTotalPages()) {
									%>
									<li class="page-item"><a class="page-link"
										href="mypage-orderlist.jsp?page=<%=pagenation.getPageNo() + 1 %>">다음</a></li>
									<%
										}
									%>
								</ul>
								<!-- 페이징 처리 끝 -->
							</div>
						</div>
					</div>
					<!-- modal -->
					<div class="modal fade" tabindex="-1" role="dialog"
						id="product-detail-01">
						<div class="modal-dialog modal-dialog-scrollable modal-xl">
							<div class="modal-content">
								<div class="modal-header">
									<div class="col-12 custom-modal-x">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
								</div>
								<div class="modal-body">
									<div class="row text-center" style="font-size: 1.2rem;" >
										<div class="col-2"></div>
										<div class="col-2">상품명</div>
										<div class="col-1">상품가</div>
										<div class="col-1">수량</div>
										<div class="col-2">구매금액</div>
										<div class="col-2">구매일</div>
										<div class="col-2"></div>
									</div>
									<div class="row text-center" id="innerhtml">
									</div>
								</div>
								<!-- Modal footer -->
								<div class="modal-footer">
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<!-- modal -->
					<!-- mypage-orderlist content end -->
				</div>
			</div>
		</div>
		<div class="footer">
			<%@ include file="/common/footer.jsp"%>
		</div>
	</div>

	<script type="text/javascript">
function openPopup(orderNo, event, productNo){
	var loginedUserId = "<%=session.getAttribute("LOGINED_USER_ID") %>"
    var loginedAdmin = "<%=session.getAttribute("LOGINED_ADMIN") %>"
    console.log(loginedUserId, loginedAdmin);
    
    var target = $('#innerhtml');
    target.empty();
	event.preventDefault();
	console.log("start ajax");
	$.ajax({
		type:'get',
		url:'../user/data.jsp?orderNo='+orderNo,
		success:function(data){
		var orderDto = JSON.parse(data);
		
			var imageRoot = "";
			console.log("orderDto",orderDto);
			for(var i = 0; i < orderDto.length; i++){
			//	document.querySelector("#name").textContent=orderDto[i].name;
			//	document.querySelector("#price").textContent=orderDto[i].price;
			//	document.querySelector("#amount").textContent=orderDto[i].orderProductAmount;
			//	document.querySelector("#date").textContent=orderDto[i].regDate;
				
				var imagePath = "";
				if(orderDto[i].category == "CAKE"){
					imagePath = "../image/CAKE/"+orderDto[i].imagePath;
				} else {
					imagePath = "../image/ICECREAM/"+orderDto[i].imagePath;
				}
			//	document.querySelector("#images-2").src=imageRoot+orderDto[i].imagePath;
		
				
				var innerhtml='<div class="col-2">'
							  +'<img class="img-thumbnail" src="'+imagePath+'" class=""alt=""style="">'
							  +'</div>'
							  +'<div class="col-2 vertical-box text-center">'
							  +'<a class="color-pink" href="../product/detail.jsp?productNo='+orderDto[i].productNo+'"><span id="name" class="font-weight-bold">'+orderDto[i].name+'</span></a>'
							  +'</div>'
							  +'<div class="col-1 vertical-box">'
							  +'<p><span id="price" class="font-weight-bold">'+orderDto[i].price+'</span><span>원</span></p>'
							  +'</div>'
							  +'<div class="col-1 vertical-box">'
							  +'<p><span id="amount" class="font-weight-bold">'+orderDto[i].orderProductAmount+'</span><span> 건</span></p>'
							  +'</div>'
							  +'<div class="col-2 vertical-box">'
							  +'<p><span id="pricexamount" class="font-weight-bold">'+orderDto[i].price*orderDto[i].orderProductAmount+'</span><span> 원</span></p>'
							  +'</div>'
							  +'<div class="col-2 vertical-box">'
							  +'<p><span id="date" class="font-weight-bold">'+getDate(orderDto[i].regDate)+'</span></p>'
							  +'</div>'
							  +'<div class="col-2 vertical-box">'
							  +'<a class="btn btn-primary" href="../review/reviewform.jsp?productNo='+orderDto[i].productNo+'">리뷰작성</a>'
							  +'</div>'
							  ;
					target.append(innerhtml);
			}
			
		}
	});
}
//String Date 값을  ISO TYPE 날짜 형식으로 바꾸는 함수
function getDate(date){
	var year = date.split(',')[1];
	var month =  date.split('월')[0];
	var day = date.split('월')[1].split(',')[0];
	
	var setDate = year+'년'+month+'월'+day+'일';
	
	return setDate;
}
</script>
</body>
</html>