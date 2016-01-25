<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.lang.annotation.Target" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${requestScope.request} request;
${session } session;
${application } application;

<c:forEach items="${list }" var="obj" varStatus="current" >
${current.index } ${obj }
<c:choose>
	<c:when test="${obj.equals('hi') }">what</c:when>
	<c:otherwise>okey</c:otherwise>
</c:choose>
</c:forEach>
</body>
</html>