<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />   
<html>
<head>
<meta charset="UTF-8">
<title>새 게시글 작성</title>

<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function(){
		
		$('#frm_free').submit(function(event){
			if($('#writer').val() == ''){
				alert('작성자는 필수입니다.');
				event.preventDefault();  
				return;                 
			}
		}); 
		$('#frm_free').submit(function(event){
			if($('#title').val() == ''){
				alert('제목은 필수입니다.');
				event.preventDefault();  
				return;                 
			}
		});
		$('#frm_free').submit(function(event){
			if($('#content').val() == ''){
				alert('내용은 필수입니다.');
				event.preventDefault();  
				return;                 
			}
		});
		
		$('#btn_list').click(function(event){
			location.href = '${contextPath}/free/list.do';		
		});
		
	});
	
</script>

</head>
<body>

	<h1>자유게시판 게시글 작성화면</h1>
	<div>
		<form method="POST" action="${contextPath}/free/add.do" id="frm_free">
			<div>
				<input type="text" id="writer" name="writer" placeholder="작성자">
			</div>
			<div>
				<input type="text" id="title" name="title" placeholder="제목">
			</div>
			<div>		
				<textarea id="content" name="content" placeholder="내용" rows="3" cols="30"></textarea>
			</div>
			<div>
				<input type="submit" value="작성완료">
				<input type="reset" value="다시작성">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
	
</body>
</html>