<%@page import="com.br.dto.BasketDto"%>
<%@page import="com.br.vo.Basket"%>
<%@page import="com.br.dao.OrderDao"%>
<%@page import="com.br.utils.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	int productNo = NumberUtil.stringToInt(request.getParameter("productNo"));
	int amount = NumberUtil.stringToInt(request.getParameter("amount"));
	String type = request.getParameter("type");
	
	OrderDao orderDao = new OrderDao();
	Basket basket = new Basket();
	basket.setUserId(loginedUserId);
	basket.setProductNo(productNo);
	basket.setAmount(amount);
	
	BasketDto basketDto = orderDao.getProductByBasket(productNo, loginedUserId);
	if(basketDto != null) {
		orderDao.basketAmountPlus(basketDto, amount);
		if("no".equals(type)){
			response.sendRedirect("../order/detail.jsp?productNo=" + productNo);
		} else {
			response.sendRedirect("mypage-cart.jsp");
		}
		return;
	}
	
	orderDao.addBasket(basket);
	
	if("no".equals(type)){
		response.sendRedirect("../order/detail.jsp?productNo=" + productNo);
	} else {
		response.sendRedirect("mypage-cart.jsp");
	}
%>