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

	$(function(){
		fn_list();
		fn_add();
		fn_find();
	});
	
	function fn_list(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				$('#list').empty();
				$.each(resData, function(i, staff){
					
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#list').append(tr);
					
					/* 둘 중 하나 사용
					$('<tr>')
					.append( $('<td>').text(staff.sno) )
					.append( $('<td>').text(staff.name) )
					.append( $('<td>').text(staff.dept) )
					.append( $('<td>').text(staff.salary) )
					.appendTo('#list'); */
					
				});
			}
		});
	}
	
	function fn_add(){
		$('#addbtn').click(function(){
			if( /^[0-9]{5}$/.test($('#sno').val()) == false ) {    	/* 숫자로 시작해서 숫자로 끝나는 다섯자리(/정규식/) */
				alert('사원번호는 5자리 숫자입니다.');
				return;		/*  상기 click (ajax처리) 막음 */
			}
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				data: $('#add').serialize(),
				// data: 'sno' + $('#sno').val() + '&name=' + $('#name').val() + '&dept' + $('#dept').val(),      (상기코드와 같음)
				dataType: 'text',
				success: function(resData){
					alert(resData);		// 알림창 메시지'사원 등록이 성공했습니다.'
					fn_list();
					$('#sno').val('') 	// value 가져오기(form에서 입력한 코드 지워줌)	// document.getElementById('sno').value = '';  와 동일 코드(자바스크립트)
					$('#name').val('')
					$('#dept').val('')
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);		// 응답텍스트를 넘어올 수 있게    // 응답텍스트는 success로 보낼거면 try, error는 catch를 통해 보내줌
				}
			});
			
		});
	}
	
	function fn_find(){
		$('#btn_find').click(function(){
			$.ajax({
				type: 'get',
				url: '${contextPath}/find.json',
				data: 'sno=' + $('#find').val(),
				dataType: 'json',
				success: function(resData){
					$('#stf_list').empty();
					var tr = '<tr>';
					tr += '<td>' + resData.sno + '</td>';
					tr += '<td>' + resData.name + '</td>';
					tr += '<td>' + resData.dept + '</td>';
					tr += '<td>' + resData.salary + '</td>';
					tr += '</tr>'
					$('#stf_list').append(tr);
				},
				error: function(jqXHR){
					alert('조회된 결과가 없습니다.');
				}
			});
		})
	}


</script>

</head>
<body>

	<h3>사원등록</h3>
	<form id="add">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원명">
		<input type="text" id="dept" name="dept" placeholder="부서명">
		<input type="button" value="등록" id="addbtn">
	</form>

	<hr>
	
	<h3>사원조회</h3>
	<form id="frm_find">	
		<input type="text" id="find" name="find" placeholder="사원번호">
		<input type="button" id="btn_find" value="조회">
		<input type="submit" value="전체" onclick="list">
	</form>
	
	<hr>

	<h3>사원목록</h3>
	
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="list">
		
			<c:forEach items="${staffs}" var="emp" varStatus="vs">
				<tr>
					<td>${emp.sno}</td>
					<td>${emp.name}</td>
					<td>${emp.dept}</td>
					<td>${emp.salary}</td>
				</tr>
			</c:forEach>
		
		
		</tbody>
		
	</table>

	

</body>
</html>