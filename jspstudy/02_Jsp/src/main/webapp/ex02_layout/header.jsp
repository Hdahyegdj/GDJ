<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	if(title == null){
		title = "환영합니다";		/* 타이트을 별도 전달하지 않으면 "환영합니다"로 표시됨. */
	}
%>  <!-- 자바코드 작성 가능  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
</head>								<%-- body에 있는 문장을 삭제 --%>
<body>

	<header>
		<h1>홈페이지</h1>
		<nav>
			<ul>
				<li><a href="body_economic.jsp">경제</a></li>
				<li><a href="body_society.jsp">사회</a></li>
				<li>메뉴3</li>
				<li>메뉴4</li>
			</ul>
		</nav>
	</header>

