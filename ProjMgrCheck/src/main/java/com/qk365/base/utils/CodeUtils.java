package com.qk365.base.utils;

import org.springframework.util.Assert;

/**
 * 数据编码工具类
 */
public class CodeUtils {

	/**
	 * 根据ID生成指定位数的编码
	 * @param id
	 * @param length
	 * @return
	 */
	public static String getCode(Long id, int length){
		Assert.isTrue(length > 0);
		if(id.toString().length() >= length){
			return id.toString();
		}
		int diff = length - id.toString().length();
		String code = "";
		for(int i=0; i<diff; i++){
			code += "0";
		}
		code += id.toString();
		return code;
	}
	
}
