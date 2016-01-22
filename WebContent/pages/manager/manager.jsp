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
  				<span class=""></span>
			</a>
			管理员窗口
		</div>
	</div>
	<div class="page-content container">
		<div class="columns profilecols">
			<div class="column user on-fourth">
	        	<a href="/account" aria-label="Change your avatar" class="vcard-avatar tooltipped tooltipped-s">
	        		<img class="avatar" height="230" src="<%=basePath%>/picture/16442577.jpg" width="230">
	        	</a>
				<h1 class="vcard-names">
				  <span class="vcard-fullname" itemprop="name">sayhanabi</span>
				  <span class="vcard-username" itemprop="additionalName">Season02</span>
				</h1>
				<ul class="vcard-details">
					<li class="vcard-detail">
					<span aria-hidden="true" class="octicon octicon-clock">
					</span>
					<span class="join-label">Joined on </span>
					<time class="join-date" datetime="2015-12-26T07:51:53Z" day="numeric" is="local-time" month="short" year="numeric" title="Dec 26, 2015 3:51 PM GMT+08:00">Dec 26, 2015</time></li>
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

		<div class="three-fourths">
			<div class="tabnav">
				<div class="right">
					<a href="/account" class="btn btn-sm">
		                <span aria-hidden="true" class="octicon octicon-pencil"></span>
		                Edit profile
					</a>
		        </div>
		
		      <nav class="tabnav-tabs" data-pjax="" role="navigation">
		        <a href="/Season02" class="tabnav-tab selected" aria-selected="true" role="tab">
		          <span aria-hidden="true" class="octicon octicon-diff-added"></span>
		          	管理员功能
		        </a>
		        <a href="/Season02?tab=repositories" class="tabnav-tab " aria-selected="false" role="tab">
		          <span aria-hidden="true" class="octicon octicon-repo"></span>
		          Repositories
		        </a>
		        <a href="/Season02?tab=activity" class="tabnav-tab " aria-selected="false" role="tab">
		          <span aria-hidden="true" class="octicon octicon-rss"></span>
		          Public activity
		        </a>
		      </nav>
    		</div>
    		
			<div class="contributions-tab">			
				<div class="columns popular-repos">
					<div class="single-column">
						<div class="boxed-group flush">
							<h3>Popular repositories</h3>
							<ul class="boxed-group-inner mini-repo-list">
							<li class="public source no-description">
							<a href="/Season02/MK2.0" class="mini-repo-list-item css-truncate">
							<span aria-hidden="true" class="octicon octicon-repo repo-icon"></span>
							<span class="repo-and-owner css-truncate-target">
							<span class="repo" title="MK2.0">MK2.0</span>
							</span>
							<span class="stars">
							0
							<span aria-hidden="true" class="octicon octicon-star"></span>
							</span>
							<span class="repo-description css-truncate-target"></span>
							</a>
							</li>
							<li class="public source no-description">
							<a href="/Season02/ProjectServlet" class="mini-repo-list-item css-truncate">
							<span aria-hidden="true" class="octicon octicon-repo repo-icon"></span>
							<span class="repo-and-owner css-truncate-target">
							<span class="repo" title="ProjectServlet">ProjectServlet</span>
							</span>
							<span class="stars">
							0
							<span aria-hidden="true" class="octicon octicon-star"></span>
							</span>
							<span class="repo-description css-truncate-target"></span>
							</a>
							</li>				
							</ul>
						</div>
					</div>			
				</div>
			</div>
			    		
		</div>
	</div>
		
</body>
</html>