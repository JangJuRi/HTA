<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="application/javascript; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	BufferedReader in = request.getReader();
	String requestData = in.readLine();
	System.out.println("요청 데이터: " + requestData);
	
	String cat = request.getParameter("cat");
	String type = request.getParameter("type");
	String callback = request.getParameter("callback");
	
	System.out.println("cat: " + cat);
	System.out.println("type: " + type);
	System.out.println("callback: " + callback);
	
	Map<String, Object> map = new HashMap<>();
	map.put("name", "맥북 프로");
	map.put("price", 2800000);
	map.put("stock", 10);
	
	Gson gson = new Gson();
	String data = gson.toJson(map);
	
	String script = callback + "(" + data + ");";
	out.write(script);
%>