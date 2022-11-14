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
<script type="text/javascript">
	$(function(){
		
		if('${recordPerPage}' != ''){
			$('#recordPerPage').val(${recordPerPage});			
		} else {
			$('#recordPerPage').val(10);
		}
		
		$('#recordPerPage').change(function(){
			location.href = '${contextPath}/bbs/list?recordPerPage=' + $(this).val();
		});
		
	});
</script>
<style>
	.lnk_remove {
		cursor: pointer;
	}
	.blind {		/* 있지만 보이지 않도록 처리 */
		display: none;
	}
</style>
</head>
<body>

	<div>
		<a href="${contextPath}/bbs/write">작성하러가기</a>
	</div>

	<div>
		<select id="recordPerPage">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
		</select>
	</div>

	<div>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>작성자</td>
					<td>제목</td>
					<td>IP</td>
					<td>작성일</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bbs" items="${bbsList}" varStatus="vs">
					<c:if test="${bbs.state == 1}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td>${bbs.writer}</td>
							<td>
								<!-- DEPTH에 따른 들여쓰기 -->
								<c:forEach begin="1" end="${bbs.depth}" step="1">
									&nbsp;&nbsp;
								</c:forEach>
								<!-- 답글은 [RE] 표시 -->
								<c:if test="${bbs.depth > 0}">
									[RE]
								</c:if>
								<!-- 제목 -->
								${bbs.title}
								<!-- 답글달기 버튼 -->
								<%--
									1단 답글로 운용하는 경우 아래와 같이 처리한다.
									<c:if test="${bbs.depth == 0}">
										<input type="button" value="답글" class="btn_reply_write">
									</c:if>
								--%>
								<input type="button" value="답글" class="btn_reply_write">
								<script>
									$('.btn_reply_write').click(function(){
										$('.reply_write_tr').addClass('blind');
										$(this).parent().parent().next().removeClass('blind');
									});
								</script>
							</td>
							<td>${bbs.ip}</td>
							<td>${bbs.createDate}</td>
							<td>
								<form method="post" action="${contextPath}/bbs/remove">	<!-- data속성 : date-(-뒤에는 자유롭게 작성) -->
									<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
									<a class="lnk_remove" id="lnk_remove${bbs.bbsNo}">X</a>	<!-- id를 다르게 사용 -->
								</form>
								<script>
									$('#lnk_remove${bbs.bbsNo}').click(function(){
										if(confirm('삭제할까요?')){
											$(this).parent().submit();
										}		
											// $('.frm_remove').submit();
											// alert( $('.frm_remove'). data('aaa') ); 	 /* data()안에는 data속성에서 준 값을 동일하게 입력 */
											//}	
									});
								</script>
							</td>
						</tr>
						<tr class="reply_write_tr blind">		<!-- class는 공백으로 구분 --><!-- class 처리를 통해 있지만 보이지 않도록 처리 -->
							<td colspan="6">
								<form method="post" action="${contextPath}/bbs/reply/add">
									<div><input type="text" name="writer" placeholder="작성자" required></div>
									<div><input type="text" name="title" placeholder="제목" required></div>
									<div><button>답글달기</button></div>
									<input type="hidden" name="depth" value="${bbs.depth}">	<!-- 답글달기와 같은 form안에만 있으면 됨 -->
									<input type="hidden" name="groupNo" value="${bbs.groupNo}">
									<input type="hidden" name="groupOrder" value="${bbs.groupOrder}">
								</form>
							</td>
						<tr>
					</c:if>
					<c:if test="${bbs.state == 0}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td colspan="5">삭제된 게시글입니다</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">${paging}</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>