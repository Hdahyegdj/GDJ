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
	<form action="${contextPath}/add.do" method="POST">
		<table border="1">
			<tbody>
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" name="writer" value="${writer}">
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="title" value="${title}">
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
						<input type="button" value="등록" onclick="location.href='${contextPath}/add.do'">	
						<input type="button" value="목록" onclick="location.href='${contextPath}/list.do'">	
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>