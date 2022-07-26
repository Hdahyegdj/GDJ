<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	* {
		box-sizing: border-box;
	}
	a {
		text-decoration: none;
		color: gray;
	}
	.paging {
		width: 210px;
		margin: 0 auto;
		color: gray;
	}
	.paging a, .paging span {
		display: inline-block;
		width: 30px;
		height: 30px;
		line-height: 30px;
		text-align: center;
	}
	.hidden {
		visibility: hidden;
	}
	.now_page {
		border: 1px solid gray;
		color: teal;
		font-weight: 900;
	}
	.lnk:hover {
		border: 1px solid gray;
		color: skyblue;
	}
</style>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
		// area1, area2 표시
		// 초기 상태 : area1, area2 둘 다 숨김
		$('#area1, #area2').css('display', 'none');		/* display은 none을 사용해야함 */
		// column 선택에 따른 area1, area2 표시
		$('#column').change(function(){
			let combo = $(this);
			if(combo.val() == ''){
				$('#area1, #area2').css('display', 'none');
			} else if(combo.val() == 'HIRE_DATE' || combo.val() == 'SALARY'){
				$('#area1').css('display', 'none');
				$('#area2').css('display', 'inline');
			} else {
				$('#area1').css('display', 'inline');
				$('#area2').css('display', 'none');
			}
		});
		
		// 자동 완성(keyup : 한글자 기입 시 표시)
		$('#email').keyup(function(){
			$('#auto_complete').empty();
			$.ajax({
				/* 요청 */
				type: 'get',
				url: '${contextPath}/emp/autoComplete',
				data: 'param=' + $(this).val(),
				/* 응답(받아오는 데이터는 json을 사용) */
				dataType: 'json',
				success: function(resData){
					if(resData.status == 200){
						$.each(resData.list, function(i, emp){		  /* $.each(배열, funciton(인덱스, 요소)) */
							$('#auto_complete')
							.append($('<option>').val(emp["email"]));
						});
					}
				}
			});
		});
		
	});
</script>
</head>
<body>

	<div>	<!-- 하단 내용이 employee.xml의 쿼리문으로 들어감 -->
		<form id="frm_search" action="${contextPath}/emp/search">		<!-- method는 적지 않으면 get방식 사용 -->
			<select id="column" name="column">
				<option value="">:::선택:::</option>
				<option value="EMPLOYEE_ID">사원번호</option>
				<option value="E.DEPARTMENT_ID">부서번호</option>				
				<option value="LAST_NAME">성</option>
				<option value="FIRST_NAME">이름</option>
				<option value="PHONE_NUMBER">연락처</option>
				<option value="HIRE_DATE">입사일</option>
				<option value="SALARY">연봉</option>
			</select>
			<span id="area1">
				<input type="text" id="query" name="query">
			</span>
			<span id="area2">
				<input type="text" id="start" name="start">
				~
				<input type="text" id="stop" name="stop">
			</span>
			<span>
				<input type="submit" value="검색">
				<input type="button" value="전체사원조회" id="btn_all">	<!-- 스크립트를 짜기 위해서는 id값을 줘야함. -->
			</span>
		</form>
	</div>

	<div>
		<label for="email">이메일</label>
		<input type="text" id="email" name="email" list="auto_complete">
		<datalist id="auto_complete"></datalist>		<!-- datalist는 목록상자 생성해줌 -->
	</div>

	<hr>

	<div>
		<table>
			<thead>
				<tr>
					<td>순번</td>
					<td>사원번호</td>
					<td>사원명</td>
					<td>이메일</td>
					<td>전화번호</td>
					<td>입사일자</td>
					<td>연봉</td>
					<td>커미션</td>
					<td>부서번호</td>
					<td>부서명</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp" varStatus="vs">	<!-- 순번표시를 -1씩 표기하기 위해서 index 사용이 필요 -> index 사용을 위해서는 varStatus를 이용해야함 -->
					<tr>
						<td>${beginNo - vs.index}</td>
						<td>${emp.employeeId}</td>
						<td>${emp.firstName} ${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.phoneNumber}</td>
						<td>${emp.hireDate}</td>
						<td>${emp.salary}</td>
						<td>${emp.commissionPct}</td>
						<td>${emp.deptDTO.departmentId}</td>
						<td>${emp.deptDTO.departmentName}</td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="10">
						${paging}	<!-- serviceImpl과 동일한 이름 사용 -->
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>