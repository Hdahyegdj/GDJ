<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<table border="1">
		<tbody>
			<tr>
				<td>순번</td>
				<td>
					<input type="number" name="no">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="writer" value="${board.writer}">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="title">
				</td>
			</tr>
			<tr>				
				<td>내용</td>
				<td>
					<textarea name="content" rows="5" cols="30"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정" onclick="location.href='${contextPath}/edit.do'">	
					<input type="button" value="목록" onclick="location.href='${contextPath}/list.do'">	
					<input type="button" value="삭제" onclick="location.href='${contextPath}/remove.do'">	
				</td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>