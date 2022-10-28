<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<script>
	if (${param.res} > 0) {
		alert('삽입 성공');
		location.href = '${contextPath}/list.do';
	} else {
		alert('삽입 실패');
		history.back();
	}
</script>