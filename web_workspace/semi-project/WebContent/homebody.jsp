<%@page import="com.br.vo.Product"%>
<%@page import="com.br.dao.ProductDao"%>
<%@page import="com.br.vo.Pagenation"%>
<%@page import="com.br.dto.EventDto"%>
<%@page import="java.util.List"%>
<%@page import="com.br.service.EventService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	
	EventService eventService = new EventService();
	List<EventDto> progressBanners = eventService.getBannerEventAll();
	int bannerSize = progressBanners.size();
	
	ProductDao productDao = new ProductDao();
	List<Product> rankedProducts = productDao.getProductForRank("ICECREAM");
%>


<!-- main banner -->
<div class="banner">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
		<%
			for(int number = 0; number < bannerSize; number++){
		%>
			<li data-target="#carouselExampleIndicators" data-slide-to="<%=number %>"
				class="<%=(number == bannerSize) ? "active" : "" %>"></li>
		
		<%
			}
		%>
		</ol>
		<div class="carousel-inner">
		<%
			int eventLength = 0;
			for(EventDto event : progressBanners){
		%>
			<div class="carousel-item <%=eventLength == 0 ? "active" : "" %>">
				
				<img src="image/EVENT/<%=event.getImagePath() %>" class="d-block w-100" alt="...">
				
			</div>
		<%
			eventLength++;
			}
		%>		
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!-- main banner end -->
</div>
<!-- br-event-container 1 start -->
<div class="br-event-container">
	<h4 class="br-event-title text-center">BR EVENT</h4>
	<div class="container">
		<div class="row"  id="progress-event">
			<!-- progress event -->
		
			
			<!-- progress event -->
		</div>
		<div id="progress-event-pagenation"></div>
	</div>
</div>
<!-- br-event-container 1 end -->
<!-- br-event-container 2 start -->
<div class="br-event-container">
	<h4 class="br-event-title text-center">BR BEST MENU</h4>
	<div class="container">
		<div class="row" id="ranking-ice">
			<!-- product rank -->
			
			<!-- product rank -->
		</div>
		<div id="ranking-ice-pagenation"></div>
	</div>
</div>
<div class="br-event-container">
	<h4 class="br-event-title text-center">BR BEST REVIEW</h4>
	<div class="container">
		<div class="row" id="ranking-review">
			<!-- review rank -->
			
			<!-- review rank -->
		</div>
	</div>
</div>
<%@ include file="review/reviewdetailmodal.jsp" %>
<!-- br-event-container 2 end -->
<script type="text/javascript" src="js/homepagenation.js"></script>
