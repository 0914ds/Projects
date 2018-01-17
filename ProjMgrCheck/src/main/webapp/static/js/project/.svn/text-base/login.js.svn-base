/**
 * 登录
 * @param baseUrl
 * @returns {Boolean}
 */
function checkLogin(baseUrl){
	
	var uname =$.trim($("#userName").val());
	var pw = $.trim($("#password").val());
	
	if(uname ==""){
		$("#alerts").text("请输入用户名");
		return false;
	}else if(pw ==""){
		$("#alerts").text("请输入密码");
		return false;
	}else{
		$.ajax({
			type:"post",
			data:{
				userName:uname,
				password:pw
				},
			url:baseUrl+"/login/userLogin.html",
			success:function(data){
				if(data.result == 0){
						//$("#alerts").text("登录成功");
					window.location = baseUrl + data.location;
				}else if(data.result == 1){
					//$("#alerts").text(data.error);
					alert("result=1"+data.error);
				}
			},
			error:function(data){
				$("#alerts").text("用户名或密码错误");
			}
		});
	}
}

/**
 * 修改密码
 */
function modifyPassword(baseUrl){
	$.ajax({
		type:"post",
		data:{
			userName:"bill",
			oldPassWord:"111111",
			newPassWord:"222222"
			},
		url:baseUrl+"login/modify.html",
		success:function(data){
				if(data.result == 0){
					alertMsg.correct("密码修改成功!");
					//调用退出系统方法
					userQuit(baseUrl);
				}else if(data.result == 1){
					alertMsg.error(data.error);	
				}
			},
		error:function(data){
			alertMsg.error("系统异常！");
			}
	});
	
}

/**
 * 用户退出
 * @param baseUrl
 */
function userQuit(baseUrl){
	$.ajax({
		type:"post",
		url:baseUrl+"login/userQuit.html",
		success:function(data){
				if(data.result == 0){
					//跳转到登录界面
					window.location =baseUrl+"login/goLogin.html";
				}else if(data.result == 1){
					alertMsg.error(data.error);	
				}
			},
		error:function(data){
			alertMsg.error("系统异常！");
			}
	});
}
/**
 * 提交 修改密碼
 */
function checkPass(baseUrl){
	var hibPwd =$.trim($("#hibPwd").val());
	
	var oldPwd =$.trim($("#oldPwd").val());
	var newPwd =$.trim($("#newPwd").val());
	var repeatPwd =$.trim($("#repeatPwd").val());
	
	if(oldPwd.trim()==""){
		alertMsg.info("请输入原始密码");
		return false;
	}
	if(newPwd.trim()==""){
		alertMsg.info("请输入新的密码");
		return false;
	}
	if(repeatPwd.trim()==""){
		alertMsg.info("请重新输入新的密码");
		return false;
	}
	
	if(oldPwd.length<6||oldPwd.length>16){
		alertMsg.info("原始密码长度必须为6-16个字符");
		return false;
	}
	
	if(newPwd.length<6||newPwd.length>16){
		alertMsg.info("新的密码长度必须为6-16个字符");
		return false;
	}
	
	if(repeatPwd.length<6||repeatPwd.length>16){
		alertMsg.info("再次输入的密码长度必须为6-16个字符");
		return false;
	}
	if(oldPwd.trim()!=hibPwd.trim()){
		alertMsg.info("原始密码输入不正确");
		return false;
	}
	
	if(newPwd.trim()!=repeatPwd.trim()){
		alertMsg.info("新密码两次输入不一致");
		return false;
	}
	
	$.ajax({
		type:"post",
		data:{
			oldPassWord:oldPwd,
			newPassWord:newPwd
			},
		url:baseUrl+"login/modify.html",
		success:function(data){
				if(data.result == 0){
					alertMsg.correct("密码修改成功!");
					//调用退出系统方法
					userQuit(baseUrl);
				}else if(data.result == 1){
					alertMsg.error(data.error);	
				}
			},
		error:function(data){
			alertMsg.error("系统异常！");
			}
	});
	
	

}

document.onkeydown=function(event){
	 var e = event || window.event || arguments.callee.caller.arguments[0];
		if(e&&e.keyCode==13){
			var path =$.trim($("#path").val());
			checkLogin(path);
		}
}