<%@page import="com.sayhanabi.framework.vo.Manager"%>
<%@page import="com.sayhanabi.framework.vo.PagePointer"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>爱樱花,爱商城!</title>
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
<script>
	function toServlet(servlet,arg) 
	{	
		document.forms[0].setAttribute("action", <%=path%> + "/" + servlet + "?action=" + arg);
	 	document.forms[0].submit();
	}
	
</script>
</head>
<body>

	<div class="header">
		<div class="container">
			<a class="header-logo-invertocat" href="index.jsp">
  				<span class=""></span>
			</a>
			樱花商城管理员窗口
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
			
			<div class="column three-fourths">
				<div class="tabnav">
					<div class="right">
						<a href="/account" class="btn btn-sm">
			                <span aria-hidden="true" class="octicon octicon-pencil"></span>
			                Edit profile
						</a>
			        </div>
			
			      <nav class="tabnav-tabs" data-pjax="" role="navigation">
			        <a href="<%=path%>/pages/manager/manager.jsp" class="tabnav-tab selected" aria-selected="true" role="tab">
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
	    		
	    		<div class="tab-content js-repo-filter">
	    			<div class="contributions-tab">
						<div class="columns popular-repos">
							<div class="single-column">
								<div class="boxed-group flush">
									<c:choose>
										<c:when test="${message.equals('data_gather')}">
											<h3>查询所有管理员</h3>
											<!--
											 <div class="site-search" role="search">
											<form accept-charset="UTF-8" action="/search" method="get">
											<label class="js-chromeless-input-container form-control">
												<input type="text" placeholder="按姓名搜索">
											</label>
											</form>
											</div>
											-->
										</c:when>
									</c:choose>
									
									<ul class="boxed-group-inner mini-repo-list">
										<c:choose>
											<c:when test="${message.equals('data_gather')}">
												<li id="title" class="public source no-description">
													<a id="${current.index}" class="mini-repo-list-item">
													<span class="repo" name="id" title="ID">ID</span>
													<span class="stars">用户名</span>
													<span onClick="add_manager()" class="btn-inline btn-add btn-sm" >添加</span>
													</a>
												</li>
												<c:forEach items="${all_manager}" var="manager" varStatus="current">
													<li class="public source no-description">
													<a id="${current.index}" class="mini-repo-list-item">
														<span class="repo" name="id" title="ID">${manager.id }</span>
														<span class="stars"> ${manager.manager } </span>
														<span onClick="delete_manager(this)" class="btn-inline btn-delete btn-sm" >删除</span>
													</a>
													</li>
												</c:forEach>
												<% int limit = ((PagePointer)(request.getSession().getAttribute("page_pointer"))).limit; %>
												<% int count = ((java.util.List)(request.getAttribute("all_manager"))).size(); %>
												<% int loop = limit - count; %>
												<% while(loop-- > 0)
													{
														out.print("<li class='public source no-description'>");
														out.print("<a href='' class='mini-repo-list-item'> &nbsp </a>");
														out.print("<span class='repo'>  </span></li>");
													}
												%>
												<li id="control" class="public source no-description ">
													<div class="mini-repo-list-item ">
														<div class="panel-btn-control">
															<a href="javascript:void()" onclick="firstPage('<%=path%>/ManagerServlet','${page_pointer.total}','${page_pointer.current}')" class="btn-control">第一页</a>
															<a href="javascript:void()" onclick="previousPage('<%=path%>/ManagerServlet','${page_pointer.total}','${page_pointer.current}')" class="btn-control" >上一页</a>
															<a href="javascript:void()" onclick="nextPage('<%=path%>/ManagerServlet','${page_pointer.total}','${page_pointer.current}')" class="btn-control" >下一页</a>
															<a href="javascript:void()" onclick="lastPage('<%=path%>/ManagerServlet','${page_pointer.total}','${page_pointer.current}')" class="btn-control">最后一页(${page_pointer.total})</a>
														</div>
													</div>
												</li>
											</c:when>
											<c:otherwise>
												<li class="public source no-description">
												<a href="<%=path%>/ManagerServlet?action=data_gather" class="mini-repo-list-item css-truncate">
													<span class="repo" title="Shiny Days!">查询所有管理员</span>
													<span class="stars"> ${count} </span>
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
											</c:otherwise>											
										</c:choose>
													
									</ul>
								</div>
							</div>
						</div>
					</div>
	    		</div>
			</div>
					
		</div>

		
	</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/manager/pageIndex.js"></script>
<script src="${pageContext.request.contextPath}/js/manager/manager.js"></script>
</body>
</html>