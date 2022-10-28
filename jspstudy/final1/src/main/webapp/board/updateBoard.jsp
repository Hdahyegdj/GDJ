<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<script>
	if (${param.res} > 0) {
		alert('수정 성공');
		location.href = '${contextPath}/detail.do?no=${param.no}';
	} else {
		alert('수정 실패');
		history.back();
	}
</script>