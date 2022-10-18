<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// session에 저장된 cart 제거하기(전부 제거 : session.invalidate();)
	session.removeAttribute("cart");	// cart정보만 제거
	
	// 장바구니 목록으로 이동
	response.sendRedirect("03_cart_list.jsp");
%>