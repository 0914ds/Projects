package com.qk365.base.webservice.client.oa.bean;



public class PersonFunctionDto {
	private String functionCode;
	private String functionName;
	private String path;
	private String permissions;
	private String lvNum;
	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getPath() {
		return path;
	}

	@Override
	public String toString() {
		return "PersonFunction [functionCode=" + functionCode + ", functionName=" + functionName + ", path=" + path
				+ ", permissions=" + permissions + "]";
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getLvNum() {
		return lvNum;
	}

	public void setLvNum(String lvNum) {
		this.lvNum = lvNum;
	}
	
	
}
