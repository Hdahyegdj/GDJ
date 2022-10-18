<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// (자바요소 입력)
	// 요청 파라미터
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// 로그인 처리
	// id와 pwd가 동일하면 로그인 성공으로 처리
	if(id.equals(pwd)){		// id와 pwd가 같으면 세션에 저장
		session.setAttribute("id", id);		// 세션에 저장
		session.setAttribute("pwd", pwd);
	}
	
	// 로그인 폼으로 가기(자바로 이동하는 방법 : forward, redirect)
	response.sendRedirect("01_form.jsp");
	
%>