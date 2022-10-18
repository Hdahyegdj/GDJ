<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3><a href="${contextPath}/today.do">오늘은 며칠입니까?</a></h3>	<!-- {contextPath}는 {03_ Mvc}이며, 폴더로 인식되는 경우가 있으므로 contextPath(앞에 / 붙이면 안됨.(자체로 포함하고 있음))값의 변수처리 방식을 통해 작성 --><!-- /Today는 urlMapping값 -->
	<h3><a href="${contextPath}/now.do">지금은 몇시입니까?</a></h3>	<!-- {contextPath}는 {03_ Mvc}이며, 폴더로 인식되는 경우가 있으므로 contextPath(앞에 / 붙이면 안됨.(자체로 포함하고 있음))값의 변수처리 방식을 통해 작성 --><!-- /Today는 urlMapping값 -->
	<h3><a href="${contextPath}/input.do">입력화면으로 이동하기</a></h3>

</body>
</html>