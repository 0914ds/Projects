package com.qk365.base.utils;

/**
 * 数字工具类
 */
public class NumberUtils {
	
	/**
	 * 小数转百分制数据,保留2位小数
	 * @param d
	 * @return
	 */
	public static double toRate(double d) {
		double num = Math.round(d * 10000.0D) / 10000.0D;
		num *= 100.0D;
		String str = String.valueOf(num);
		int index = str.indexOf(".");
		if ((index > 0) && (str.length() > index + 2)) {
			str = str.substring(0, index + 3);
			num = Double.parseDouble(str);
		}
		return num;
	}
}
