<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />   
<html>
<head>
<meta charset="UTF-8">
<title>${free.freeno}번 게시글</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script> 
	
	$(document).ready(function(){
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/free/list.do';
		});
		
	});

</script>


</head>
<body>

	<h1>자유게시판 게시글 상세보기화면</h1>
	
	<div>
		<form method="POST" action="${contextPath}/free/modify.do" id="frm_edit">
			<div>
				게시글번호 : ${free.freeNo}
			</div>
			<div>
				작성자  ${free.writer}
			</div>
			<div>
				작성IP  ${free.ip}
			</div>
			<div>
				조회수  ${free.hit}
			</div>
			
			<div>
				게시글 제목  <input type="text" name="title" id="title" value="${free.title}">		
			</div>
			
			<div>
		
				<textarea name="content" id="content" rows="5" cols="30">${free.content}</textarea>
			</div>
			
			<div>
				<input type="submit" value="수정"> 	
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
		

</body>
</html>