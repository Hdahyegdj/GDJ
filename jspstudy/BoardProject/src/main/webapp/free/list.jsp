<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />   
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체 목록</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" /> 

<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		
		$('#btn_write').click(function(){
			location.href = '${contextPath}/free/insert.do';
		});
		
		$('#remove_link').click(function(event){
			if(!confirm('삭제할까요?')){	
				alert('취소되었습니다.');
				event.preventDefault();		
				return;
			}
		});
		
	});
 
</script>

</head>
<body>

	<div>
		<input type="button" value="작성하러 가기" id="btn_write">
	</div>
	<hr>
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>게시글번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>조회수</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${frees}" var="free">
					<tr>
						<td>${free.freeNo}</td>
						<td><a href="${contextPath}/free/detail.do?freeNo=${free.freeNo}">${free.title}</a></td>		
						<td>$free.create_date}</td>
						<td>
							<a id="remove_link" href="${contextPath}/free/remove.do?freeNo=${free.freeNo}"><i class="fa-solid fa-x"></i></a>     
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	

	
</body>
</html>