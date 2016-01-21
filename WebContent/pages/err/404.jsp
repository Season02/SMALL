<%@ page language="java" contentType="text/html; charset=utf-8"
	isErrorPage="true" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	/*min-height: 101%;*/
	background: url(picture/404.jpg) no-repeat center;
	background-size: 70%;
	background-attachment: fixed;
}
</style>

</head>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<%
 /**
 * 本页面是在客户查找的页面无法找到的情况下调用的
 */
 response.setStatus(HttpServletResponse.SC_OK);
 %>

<body>

</body>
</html>
