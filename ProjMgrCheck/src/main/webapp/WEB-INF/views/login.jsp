<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Cache-Control" content="no-store" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/reset.css">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/SimpleCanleder.css">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/style.css">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/main.css">
	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
      <script src="${ctx}/static/js/misc/html5shiv.min.js"></script>
      <script src="${ctx}/static/js/misc/respond.min.js"></script>
    <![endif]-->
     <!--  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script> -->
      
	<script src="${ctx}/static/js/jquery/1.11.2/jquery.min.js"  type="text/javascript" charset="UTF-8"></script>
	<script src="${ctx}/static/bootstrap/js/bootstrap.min.js" type="text/javascript" ></script>
	<script src="${ctx}/static/bootstrap/js/SimpleCanleder.js" type="text/javascript" ></script>
	<script src="${ctx}/static/bootstrap/js/jquery.timer.js" type="text/javascript" ></script>
	<script src="${ctx}/static/js/project/login.js" type="text/javascript"></script>
</head>
<body class="loginpage">
	<div class="container-fluid">
		<div class="row">
			<div class="loginbox">
				<div class="loginboxinner">
					<!-- 标题 -->
					<h1 class="logo">xx系统</h1>
					<br>
					<h3 class="slogan">xx系统</h3>
 
					<div class="nopassword"  >
					
<%-- 						<div class="loginmsg" id="aa" <c:if test="${errMsg!=null}"> style='display:block;' </c:if> > ${errMsg}</div> --%>
					</div>
					<!-- 表单 -->
					<form class="form-horizontal" action="${ctx}/login/userLogin.html" method="post">
						<div class="form-group form_side">
							<label class="sr-only" for="inputusername">Email</label>
							
							<div class="texts" id="alerts"></div>
							
							<div class="input-group">
								<div class="input-group-addon">
									<img src="${ctx}/static/bootstrap/image/username.png">
								</div>
								<input type="text" class="form-control"  id="userName"
									placeholder="用户名" name="userName" >
							</div>
						</div>
						<div class="form-group form_side">
							<label class="sr-only" for="inputpwd">password</label>
							<div class="input-group">
								<div class="input-group-addon">
									<img src="${ctx}/static/bootstrap/image/password.png">
								</div>
								<input type="password" class="form-control" id="password"
									placeholder="密码" name="password">
							</div>
						</div>
						<div class="form-group form_side">
							<button type="submit" class="btn btn-warning"  onclick="checkLogin('${ctx}');">登录</button>
						</div>
						<div class="form-group">
							<div class="checkbox form_side_checkbox">
								<label class="checkbox" for="rememberMe">
								<input type="checkbox" id="rememberMe" name="rememberMe" /> 记住密码
								</label>
								<!-- <label> <input name="remeberMe" type="checkbox" checked="checked">记住密码 
								</label>
								-->
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>


</html>