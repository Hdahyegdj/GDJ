<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<script>
	if (${param.res} > 0) {
		alert('삭제 성공');
		location.href = '${contextPath}/list.do';
	} else {
		alert('삭제 실패');
		history.back();
	}
</script>