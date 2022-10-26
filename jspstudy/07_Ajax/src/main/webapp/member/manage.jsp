<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String contextPath = request.getContextPath();		// ${contextPath}는 사용 할 수 없음.(jsp 메개저장장소 중 어디도 저장하지 않았기 때문)
	pageContext.setAttribute("contextPath", contextPath); 		// <c:set var="contextPath" value="<%=req...%" 대신해 사용
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/member.css">
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){    	/* onload = function(){}과 동일 */
		fn_init();
		fn_getAllMembers();
		fn_getMember();
		fn_registration();
		fn_modify();
		fn_remove();
	})
	
	
	function fn_init(){		/* 초기화 */
		$('#id').val('').prop('readonly', false);
		$('#name').val('');
		$(':radio[name=gender]').prop('checked', false);
		$('#grade').val('');
		$('#address').val('');
	}
	
	
	function fn_getAllMembers(){
		$.ajax({
			/* 요청(postman 주소창 요청 타입) */
			type: 'get',		
			url: '${contextPath}/member/list.do',
			/* 응답 */
			dataType: 'json',
			success: function(resData){    // resData : {"count": 3, "members": [{}, {}, {}]}
				// 1. resData.count, resData['count']
				$('#count').text(resData.count);
				
				// 2. member_list 영역 초기화(새로 가져와서 다시 생성할 수 있도록(append 사용하므로))
				$('#member_list').empty();
				
				// 3. resData.members : [{}, {}, {}]
				// 	  $.each(배열, funciton(인덱스, 배열요소){})
				$.each(resData.members, function(i, member){
					var tr = '<tr>';
					tr += '<td>' + member.memberNo + '</td>';
					tr += '<td>' + member.id + '</td>';
					tr += '<td>' + member.name + '</td>';
					tr += '<td>' + (member.gender == 'M' ? '남자' : '여자') + '</td>';
					tr += '<td>' + member.grade + '</td>';
					tr += '<td>' + member.address + '</td>';
					tr += '<td><input type="hidden" value="' + member.memberNo + '"><input type="button" value="조회" class="btn_detail"> <input type="button" value="삭제" class="btn_primary btn_remove"><input type="hidden" value="' + member.memberNo + '"></td>';			// 동적 요소(js event 16장 참조) // 상세보기는 "btn_detail" 버튼을 눌렀을 때 // id는 동일하게 생성되면 안되므로 class(동일한 class가 있어도 상관x)로 변경하여 사용
					tr += '</tr>';
					$('#member_list').append(tr);		// html는 원래 있던 거에 덮어쓰기 됨으로 원래 있던거 아래에 추가를 위해 append를 사용
				})
			}
		});
	}
	
	
	function fn_getMember(){
		// "조회" 버튼은 동적 요소이기 때문에 다음 이벤트 방식을 사용해야 한다.
		// $(부모요소).on(이벤트타입, 이벤트대상, 이벤트리스너)
		/* 하기 버튼은 클릭되지 않음(이미 만들어진 버튼이라면 가능하나 동적요소임으로 클릭이 불가능)
			$('.btn_detail').click(function(){
				alert('ahahah');
			});
		*/
		$('body').on('click', '.btn_detail', function(){
			$.ajax({
				type: 'get',
				url: '${contextPath}/member/detail.do',
				data: 'memberNo=' + $(this).next().val(),		// this.next()는 실행되지 않음.(메소드가 다름)		// "hidden"을 앞에 작성하면 next()는 prev()가 되어야함.(this 기준)
				/* 응답 */
				dataType: 'json',
				success: function(resData){	   // resData : ("exists":true, "member": {"id": "user3", ...})
					if(resData.exists) {
						alert('회원 정보가 조회되었습니다.');
						$('#id').val(resData.member.id).prop('readonly', true);		// 속성 부여 확인 (attribute, property)
						$('#name').val(resData.member.name);
						$(':radio[name=gender][value= ' + resData.member.gender + ']').prop('checked', true);	// 라디오 부르기 ':radio'   // value값은 변수(M/F)를 지정해주어야함.  (주의! .val(M)은 모든 gender값을 M으로 변경한다라는 코드임.)
						$('#grade').val(resData.member.grade);
						$('#address').val(resData.member.address);
						$('#memberNo').val(resData.member.memberNo);		// 회원번호 예외처리(개발자 도구 element 상으로 hidden처리 확인)
					} else {
						alert('조회된 회원 정보가 없습니다.');
					}				
				}
			});
		});
	}
	
	
	function fn_registration(){			/* 등록 */
		
		$('#btn_add').click(function(){
			
			$.ajax({
				/* 요청 */
				type: 'post',		// insert와 update는 'post'로 진행
				url: '${contextPath}/member/add.do',
				data: $('#frm_member').serialize(),	// serialize() : 폼의 모든 입력 요소를 파라미터로 변환하는 메소드(사용하지 않으면 id하나하나 전부 작성해야함)
				
				/* 응답 */
				dataType: 'json',
				// 정상 응답
				success: function(resData){	 // resData : {"isSuccess": true}
					if(resData.isSuccess){
						alert('신규 회원이 등록되었습니다.');
						fn_getAllMembers();		// 목록을 새로 가져와서 갱신함  // ajax 안에 또 ajax를 작성시 promise를 사용해야한다.(ajax는 비동기 통신)	// ajax는 화면 변화 없이 한 화면에서 추가 가능
						fn_init();	// 입력된 데이터를 초기화(성공시에만)
					} else {
						alert('신규 회원 등록이 실패했습니다.');
					}
				}, 
				// 예외 응답
				error: function(jqXHR){	  // 예외 처리 응답 데이터(일반 텍스트)는 jqXHR 객체의 responseText 속성에 저장됨		// jqXHR안에 AddService에 예외 처리 응답에서 만든 내용이 text형식으로 들어가 있음
					alert(jqXHR.responseText);
				}
				
			});	// ajax
			
		});	// click
		
	}	// function
	
	
	function fn_modify(){
		
		$('#btn_modify').click(function(){
			
			$.ajax({
				/* 요청 */
				type: 'post',
				url: '${contextPath}/member/modify.do',
				data: $('#frm_member').serialize(),
				/* 응답 */
				dataType: 'json',
				success: function(resData){		// resData : {"isSuccess": true}
					if(resData.isSuccess){
						alert('회원 정보가 수정되었습니다.');
						fn_getAllMembers();		// 수정된 내용이 반영되도록 회원목록을 새로 고침
					} else {
						alert('회원 정보 수정이 실패했습니다.');
					}
				}, 
				error: function(jqXHR){
					alert(jqXHR.responseText);	   // error 프로퍼티로 전달되서 출력 됨
				}
				
			});	// ajax
			
		});	// click
		
	}	// function
	
	
	function fn_remove(){
		
		$('body').on('click', '.btn_remove', function(){
			
			if(confirm('삭제할까요?') == false){
				return;	// 코드진행 막음
			}
			
			$.ajax({
				/* 요청 */
				type: 'get',
				url: '${contextPath}/member/remove.do',
				data: 'memberNo=' + $(this).next().val(),
				/* 응답 */
				dataType: 'json',
				success: function(resData){  // resData : {"isSuccess": true}
					if(resData.isSuccess){
						alert('회원 정보가 삭제되었습니다.');
						fn_getAllMembers();
						fn_init();
					} else {
						alert('회원 정보 삭제가 실패했습니다.');
					}
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);
				}
		
			});	// ajax
			
		});	// click
		
	}	//function
	
</script>
</head>
<body>

	<div class="wrap">
		<h1 class="title">회원관리</h1>
		<form id="frm_member">
			<label for="id">아이디</label>
			<div class="ipt_area">
				<input type="text" id="id" name="id" class="frm_member_ipt">
			</div>
			<label for="name">이름</label>
			<div class="ipt_area">
				<input type="text" id="name" name="name" class="frm_member_ipt">
			</div>
			<label>성별</label>
			<div class="gender_area">
				<label for="male">
					남자
					<input type="radio" id="male" name="gender" value="M">
				</label>
				<label for="female">
					여자
					<input type="radio" id="female" name="gender" value="F">
				</label>
			</div>
			<label for="grade">회원등급</label>
			<div class="ipt_area">
				<select id="grade" name="grade"  class="frm_member_ipt">
					<option value="">등급선택</option>
					<option value="gold">골드</option>
					<option value="silver">실버</option>
					<option value="bronze">브론즈</option>
				</select>
			</div>
			<label for="address">주소</label>
			<div class="ipt_area">
				<input type="text" id="address" name="address"  class="frm_member_ipt">
			</div>
			<div class="btn_area">
				<input type="button" value="초기화" class="btn_primary" onclick="fn_init();">
				<input type="button" value="신규등록" id="btn_add" class="btn_primary">
				<input type="button" value="변경내용저장" id="btn_modify" class="btn_primary">
				<input type="button" value="회원삭제" class="btn_primary btn_remove">
				<input type="hidden" id="memberNo">
			</div>
		</form>
		<hr>
		<table class="member_table">
			<caption>전체 회원수 : <span id="count"></span>명</caption>
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>성별</td>
					<td>등급</td>
					<td>주소</td>
					<td></td>
				</tr>
			</thead>
			<tbody id="member_list"></tbody>
		</table>
	</div>

</body>
</html>