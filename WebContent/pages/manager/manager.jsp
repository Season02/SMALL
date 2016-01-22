<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	<%@ include file="/css/manager.css" %>
</style>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
	<%@ include file="/css/public.css" %>
</style>
</head>
<body>
	<div class="header">
		<div class="container">
			<a class="header-logo-invertocat" href="index.jsp">
  				<span class="mega-octicon octicon-mark-github"></span>
			</a>
			管理员窗口
		</div>
	</div>
	<div class="page-content">
		<div class="column user on-fourth">
        	<a href="/account" aria-label="Change your avatar" class="vcard-avatar tooltipped tooltipped-s"><img class="avatar" height="230" src="<%=basePath%>/picture/16442577.jpg" width="230"></a>
			<h1 class="vcard-names">
			  <span class="vcard-fullname" itemprop="name">sayhanabi</span>
			  <span class="vcard-username" itemprop="additionalName">Season02</span>
			</h1>
			<ul class="vcard-details">
				<li class="vcard-detail"><span aria-hidden="true" class="octicon octicon-clock"></span><span class="join-label">Joined on </span><time class="join-date" datetime="2015-12-26T07:51:53Z" day="numeric" is="local-time" month="short" year="numeric" title="Dec 26, 2015 3:51 PM GMT+08:00">Dec 26, 2015</time></li>
			</ul>
			<div class="vcard-stats">
				<a class="vcard-stat" href="/Season02/followers">
					<strong class="vcard-stat-count">0</strong>
					<span class="text-muted">Followers</span>
				</a>
				<a class="vcard-stat" href="/stars">
					<strong class="vcard-stat-count">0</strong>
					<span class="text-muted">Starred</span>
				</a>
				<a class="vcard-stat" href="/Season02/following">
					<strong class="vcard-stat-count">0</strong>
					<span class="text-muted">Following</span>
				</a>
			</div>			
		</div>
		
	</div>
	<div class="column control">
	</div>
</body>
</html>