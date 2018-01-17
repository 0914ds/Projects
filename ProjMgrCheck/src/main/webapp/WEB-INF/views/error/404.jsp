<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.lang.*" %>
<%
	String webName = " - 系统";
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="utf-8"/>
		<meta http-equiv="Cache-Control" content="no-store"/>
		<meta http-equiv="Pragma" content="no-cache"/>
		<meta http-equiv="Expires" content="0"/>
		
		<title>404错误</title>
		<link rel="stylesheet" href="<%=basePath%>/css/login.css"/>
		<script src="<%=basePath%>static/js/jquery/jquery.min.js" type="text/javascript"></script>
		
	</head>
	<body>
		404错误，正在跳转到登录页面，请稍等
		<jsp:forward page="/login/goLogin" /> 
	</body>
</html>