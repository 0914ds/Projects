<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-inverse navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse" type="button">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><small>上海青客X系统</small></a>
    </div>
    <div class="navbar-collapse collapse" role="navigation" aria-expanded="true">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><small style="font-size:20px;color:#fff;">欢迎光临，<span>${sessionScope.LOGIN_INFO.usrAccount}</span></small></a></li>
        <li><a href="#" style="padding-bottom:0;padding-top:10px;"><button class="btn btn-xs btn-danger" onclick="quit()" style="padding:6px 10px;">退出</button></a></li>
      </ul>
    </div>
  </div>
</nav>
<script type="text/javascript">
	function quit() {
		$.get("${ctx}/login/quit.html", function(data) {
			window.location.href = "${ctx}" + data;
		});
	}
</script>