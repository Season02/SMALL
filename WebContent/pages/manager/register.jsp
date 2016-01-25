<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>樱花商场 管理员注册</title>
	<link rel="stylesheet" id="buttons-css" href="http://www.ixiqi.com/wp-includes/css/buttons.min.css?ver=3.9.10" type="text/css" media="all">
	<link rel="stylesheet" id="dashicons-css" href="http://www.ixiqi.com/wp-includes/css/dashicons.min.css?ver=3.9.10" type="text/css" media="all">
	<link rel="stylesheet" id="login-css" href="http://www.ixiqi.com/wp-admin/css/login.min.css?ver=3.9.10" type="text/css" media="all">
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
</head>
<body class="login login-action-register wp-core-ui  locale-zh-cn">
	<div id="login">
		<h1><a href="https://cn.wordpress.org/" title="爱樱花，爱商城！">爱樱花，爱商城！</a></h1>
		<p class="message register">注册超级管理员</p>
		<form name="registerform" id="registerform" action="ManagerLoginServlet?action=register" method="post" onsubmit="return check(this);">
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
			<p id="reg_passmail">请向站长取得邀请码。</p>
		<br class="clear">
		<input type="hidden" name="redirect_to" value="">
		<p class="submit"><input type="submit" name="wp-submit" id="wp-submit" class="button button-primary button-large" value="注册"></p>
		</form>
		
		<p id="nav">
		<a href="index.jsp">登录</a> |
		<a href="http://www.ixiqi.com/wp-login.php?action=lostpassword" title="找回密码">忘记密码？</a>
		</p>
	
		<p id="backtoblog"><a href="/index.jsp" title="不知道自己在哪？">← 回到樱花商城主页！</a></p>
	</div>

	<script type="text/javascript">
		try{document.getElementById('user_login').focus();}catch(e){}
		if(typeof wpOnload=='function')wpOnload();
	</script>
	
	<link rel="stylesheet" id="theme-my-login-css" href="http://www.ixiqi.com/wp-content/themes/illacrimo-101/theme-my-login.css?ver=6.3.8" type="text/css" media="all">
	<div class="clear"></div>

</body>
</html>



