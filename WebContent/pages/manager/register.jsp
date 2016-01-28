<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>樱花商场 管理员注册</title>
	<style type="text/css">
		<%@ include file="/css/ixiqi/buttons.min.css" %>
	</style>
	<style type="text/css">
		<%@ include file="/css/ixiqi/dashicons.min.css" %>
	</style>
	<style type="text/css">
		<%@ include file="/css/ixiqi/login.min.css" %>
	</style>
	<script>
	      function check(form) 
	      {
	          var p1 = form.user_pass;
	          var p2 = form.user_repass;
	          if (p1.value != p2.value) 
	          {
	              p2.oninvalid();
	              return false;
	          }
	          return true;
	      }
	      onload = function() 
	      {
	          var p2 = document.forms["registerform"].user_repass;
	          p2.oninvalid = function() 
	          {
	              this.setCustomValidity("密码不一致，请重新输入");
	          }
	          p2.oninput = function() 
	          {
	              this.setCustomValidity("");
	          }
	      }
	</script>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
</head>
<body class="login login-action-register wp-core-ui  locale-zh-cn">
	<div id="login">
		<h1><a href="https://cn.wordpress.org/" title="爱樱花，爱商城！">爱樱花，爱商城！</a></h1>
		<p class="message register">注册超级管理员</p>
		
		<c:choose>
		<c:when test="${login_err.equals('code') }">
			<div id="login_error">	<strong>错误</strong>：邀请码错误。<br>
				<strong>提示</strong>：请联系站长大人。<br>
			</div>
		</c:when>
		<c:when test="${login_err.equals('fail') }">
			<div id="login_error">	<strong>错误</strong>：注册失败。<br>
				<strong>提示</strong>：请联系站长大人。<br>
			</div>
		</c:when>
		</c:choose>
		<form name="registerform" id="registerform" action="<%=path %>/ManagerLoginServlet?action=register" method="post" onsubmit="return check(this);">
			<p>
				<label for="user_code">邀请码<br>
				<input type="password" name="user_code" required="required" autofocus="autofocus" id="user_code" class="input" value="" size="20"></label>
			</p>
			<p>
				<label for="user_login">用户名<br>
				<input type="text" name="user_login" required="required" id="user_login" class="input" value="" size="20"></label>
			</p>
			<p>
				<label for="user_pass">密码<br>
				<input type="password" name="user_pass" required="required" id="user_pass" class="input" value="" size="20"></label>
			</p>
			<p>
				<label for="user_repass">重复密码<br>
				<input type="password" name="user_repass" required="required" id="user_repass" class="input" value="" size="20"></label>
			</p>
				<p id="reg_passmail">请向站长大人取得邀请码。</p>
			<br class="clear">
			<input type="hidden" name="redirect_to" value="">
			<p class="submit"><input type="submit" name="wp-submit" id="wp-submit" class="button button-primary button-large" value="注册"></p>
		</form>
		<p id="nav">
		<a href="<%=path %>/index.jsp">登录</a> |
		<a href="http://www.ixiqi.com/wp-login.php?action=lostpassword" title="找回密码">忘记密码？</a>
		</p>
	
		<p id="backtoblog"><a href="/index.jsp" title="不知道自己在哪？">← 回到樱花商城主页！</a></p>
	</div>

	<script type="text/javascript">
		try{document.getElementById('user_login').focus();}catch(e){}
		if(typeof wpOnload=='function')wpOnload();
	</script>
	
	<div class="clear"></div>

</body>
</html>



