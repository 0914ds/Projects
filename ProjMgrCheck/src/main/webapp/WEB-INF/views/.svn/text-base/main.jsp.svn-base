<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>X系统</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
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
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.min.css"  charset="UTF-8">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/reset.css"  charset="UTF-8">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/SimpleCanleder.css"  charset="UTF-8">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/style.css">
	<link rel="stylesheet" href="${ctx}/static/bootstrap/css/main.css">
	<!-- 任务模块 加 日历 -->
    <link rel="stylesheet" href="${ctx}/static/bootstrap/css/datepicker.css">
	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
      <script src="${ctx}/static/js/misc/html5shiv.min.js"></script>
      <script src="${ctx}/static/js/misc/respond.min.js"></script>
    <![endif]-->
     <!--  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script> -->

	<script type="text/javascript"  src="${ctx}/static/js/jquery/1.11.2/jquery.min.js"  charset="UTF-8"></script> 
	<script type="text/javascript"  src="${ctx}/static/bootstrap/js/bootstrap.min.js"  charset="UTF-8"></script>
	<!-- 任务模块 加 日历 -->
	<script type="text/javascript"  src="${ctx}/static/bootstrap/js/bootstrap-datepicker.js" data-context="${ctx }" id="bootstrap-datepicker"></script>
	<script type="text/javascript"  src="${ctx}/static/bootstrap/js/SimpleCanleder.js"  charset="UTF-8"></script>
	<script type="text/javascript"  src="${ctx}/static/bootstrap/js/jquery.timer.js"  charset="UTF-8"></script>
	
	<!-- 为表格添加动态表头 -->
	<script type="text/javascript" src="${ctx}/static/bootstrap/js/jquery.ba-throttle-debounce.min.js"></script>
	<script type="text/javascript" src="${ctx}/static/bootstrap/js/jquery.stickyheader.js"></script>
	
	<!-- 分页插件 -->
	<script type="text/javascript" src="${ctx}/static/bootstrap/js/bootstrap-paginator.min.js"></script>
</head>

<body>

<div style="width:100%;">
	<%@ include file="head.jsp"%>
</div>	
	
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2">
		<%@ include file="menu.jsp"%>
		</div>
		<div class="col-sm-9  col-md-10" >
			<div id="main">
				<div class="breadcrumbs">
					<ul class="breadcrumb">
						<li><span class="glyphicon glyphicon-home" aria-hidden="true"></span>
							<a href="#">我的位置：主页</a></li>
						<li class="active">主页</li>
					</ul>
				</div>
				<div class="container-fluid">
					<div class="page-content">
						<div class="page-header">
							<p>主页</p>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<h1>欢迎来到X系统</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
 <script type="text/javascript">
    	$(".test").simpleCanleder(); 
    	var menuNo="${sessionScope.MENU_NO}";
		$(function () {
		    $('.tree li').addClass('parent_li').find(' > div').attr('title', 'Collapse this branch');
		    
		    //修改后
            for(var no=1;no<=3;no++){
            	if(menuNo!='id'+no){
            		firstchild = $('.tree li.parent_li > #tree_li_'+no).parent('li.parent_li').find('> ul > li');
 				    firstchild.hide();
            	}
            }
		    
		/*     if(menuNo=='id1'){
		    //第一个
		    lastchild = $('.tree li.parent_li > #tree_li_3').parent('li.parent_li').find('> ul > li');
		    lastchild.hide();
		    }else{
		    	if(menuNo=='id3'){
		    		  //第三个
				    firstchild = $('.tree li.parent_li > #tree_li_1').parent('li.parent_li').find('> ul > li');
				    firstchild.hide();
		    	}else{
		    		 //第二个
				    child = $('.tree li.parent_li > div.parent_li_title').parent('li.parent_li').find('> ul > li');
				    child.hide();
				    
		    	}
		    } */
		    
		       //$('.parent_li').on('click', function (e) {		    	
		    $('.tree > ul > li').on('click', function (e) {	
		    	var menuNo=$(this).attr('id');
		    	$.post("${ctx}/login/menu.html",{menuNo:menuNo});
		    	
		    	var children = $(this).find(' > ul > li');
		    	if (children.is(":visible")) {
		      		children.hide('fast');
		    	} else {
		      		children.show('fast');
		    	}
		    	e.stopPropagation();
		  	}); 
		    
		   
		    	 
		});
		 function lostTab(){
     		//alert($(".sticky-wrap").parent().innerHTML);
     		//$(".sticky-wrap").parent.name
     		alert( $(".scroll_table").hasChildren("sticky-wrap"));
     		
     }
		 
		 var message=""; 

function clickIE() {if (document.all) {(message);return false;}} 
function clickNS(e) {if 
(document.layers||(document.getElementById&&!document.all)) { 
if (e.which==2||e.which==3) {(message);return false;}}} 
if (document.layers) 
{document.captureEvents(Event.MOUSEDOWN);document.onmousedown=clickNS;} 
else{document.onmouseup=clickNS;document.oncontextmenu=clickIE;} 
document.oncontextmenu=new Function("return false") 

	</script>
 
</body>
</html>