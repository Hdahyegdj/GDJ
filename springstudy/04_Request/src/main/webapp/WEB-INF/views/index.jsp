<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.mis.js"></script>
</head>
<body>

	<img src="${contextPath}/resources/images/animal10.jpg" width="200px">
	
	<hr>
	
	<h3>Member 관련 요청</h3>
	
	<div>
		<a href="${contextPath}/member/detail1?id=admin&pw=1234">전송</a>		<!-- a링크 요청 메소드 : GET / 매핑값 : detail까지 / 파라미터 : id=admin&pw=1234  -->
	</div>
	
	<div>
		<input type="button" value="전송" id="btn">
	</div>
	<script>
		$('#btn').click(function(){
		    // location.href='${contextPath}/member/detail2?id=admin&pw=1234';		<!-- location 링크 요청 메소드 : GET -->	
			// location.href='${contextPath}/member/detail2';
			
			// location.href='${contextPath}/member/detail3?id=admin&pw=1234';
			location.href='${contextPath}/member/detail3';
			
		});
	</script>
	
	<form action="${contextPath}/member/detail4" method="post">		<!-- get 방식 일 경우, 메소드를 'get'로 변경 후 실행 -->
		<div>
			<input type="text" name="id" placeholder="아이디">
		</div>
		<div>
			<input type="text" name="pw" placeholder="패스워드">
		</div>
		<button>전송</button>
	</form>
	
	<hr>
	
	<div>
		<a href="${contextPath}/board/detail1?title=공지사항&hit=10">전송</a>
	</div>
	
	<div>
		<a href="${contextPath}/board/detail3?title=공지사항&hit=10">전송</a>
	</div>
	
	
	
	
	
	
	

</body>
</html>