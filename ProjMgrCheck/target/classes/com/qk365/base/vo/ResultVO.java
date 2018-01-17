package com.qk365.base.vo;

/**
 * 返回值对象
 */
public class ResultVO {

	/** 返回状态 - 正常 **/
	public static final int Result_Success = 0;
	/** 返回状态 - 异常 **/
	public static final int Result_Error = -1;
	/** 返回状态 - 无权限 **/
	public static final int Result_Non_Security = 1008;
	
	protected int code;						//返回状态
	protected String message="";			//返回信息
	protected String msg="";				//返回信息(同message,兼容用)
	protected Object data;					//返回数据
	protected Object value;					//返回值
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		this.msg = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String getMsg() {
		return msg;
	}
}
