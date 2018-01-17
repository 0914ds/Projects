package com.qk365.base.webservice.client.oa.bean;

/**
 * 登录接口的结果状态值
 * @author zhaoxy
 *
 */
public enum EnumLoginResult {

	LOGIN_SUCCESS(0,"成功"),
	InvalidPassword(1, "密码错误"), 
	InvalidUser(2, "用户名或密码错误"),
	ImperfectInformation(3, "资料不完整"), 
	UnauthorizedPermission(4, "未授权权限"), 
	UnauthorizedArea(5, "未授权区域"),
	Failure_Unknown(6,"登录失败");
	
	private EnumLoginResult(Integer result,String msg){
		this.result = result;
		this.message = msg;
	}
	
	
	private int result; //登录接口的结果状态
	private String message;//登录接口的结果信息
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
