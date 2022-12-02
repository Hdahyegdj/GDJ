<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function(event){
		
		alert('전체 10개의 목록을 가져왔습니다.');
		event.preventDefault();
		return;
		
	});
	
</script>
<script>

	$(document).ready(function(){

		$('#column').change(function(){

			}
		});
		
		$('#title').keyup(function(){
			$('#auto_complete').empty();
			$.ajax({

				type: 'get',
				url: '${contextPath}/movie/autoComplete',
				data: 'param=' + $(this).val(),

				dataType: 'json',
				success: function(resData){
					if(resData.status == 200){
						$.each(resData.list, function(i, emp){		 
							$('#auto_complete')
							.append($('<option>').val(emp["movie"]));
						});
					}
				}
			});
		});
		
	});
</script>
</head>
<body>

	<div>
	
		<form id="frm_search" action="${contextPath}/movie/search">
			
			<select id="column" name="column">
				<option value="TITLE">제목</option>
				<option value="GENRE">장르</option>
				<option value="DESCRIPTION">내용</option>
			</select>
			<input type="text" id="searchText" name="searchText">
			<input type="button" id="btn_search" value="검색">
			<input type="button" id="btn_init" value="초기화">
			
			<br><hr><br>
			
			<table border="1">
				<thead>
					<tr>
						<td>제목</td>
						<td>장르</td>
						<td>내용</td>
						<td>평점</td>
					</tr>
				</thead>
				<tbody id="list"></tbody>
				<datalist id="auto_complete"></datalist>	
			</table>
			
		</form>
		
	</div>

</body>
</html>