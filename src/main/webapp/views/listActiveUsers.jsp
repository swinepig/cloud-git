<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${activeUsers}" var="nm">
		<li><strong>${ nm.key.username }</strong> / Last Active: <strong>${ nm.value }</strong></li>
	</c:forEach>
</body>
</html>