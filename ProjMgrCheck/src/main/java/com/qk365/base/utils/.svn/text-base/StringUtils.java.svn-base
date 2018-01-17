package com.qk365.base.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 */
public class StringUtils {

	private static final Random random = new Random();
	private static final String randomString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * 字符串不为空
	 * 
	 * @param str
	 * @return true:不为空
	 */
	public static boolean isNotEmpty(String str) {
		if (null != str && str.trim().length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 字符串为空
	 * 
	 * @param str
	 * @return true:不为空
	 */
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}

	/**
	 * 随机生成指定长度字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String RandomString(int length) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(62);
			buf.append(randomString.charAt(num));
		}
		return buf.toString();
	}

	/**
	 * 将字符串数组自动匹配成正则表达式匹配字符串数组
	 * 
	 * @param modules
	 *            要匹配的字符串
	 * @return 正则表达式字符串数组
	 */

	public static String[] createRegex(String[] modules) {
		for (int i = 0; i < modules.length; i++) {
			modules[i] = modules[i].startsWith("/") ? modules[i] : ("/" + modules[i]);
			// 是否以统配符结尾
			boolean all = modules[i].endsWith("*");
			// 是否需要目录区分
			modules[i] = modules[i].replaceAll("\\.", "\\\\.");
			String uris[] = modules[i].split("[*]");
			StringBuilder sb = new StringBuilder("^");
			for (int k = 0; k < uris.length - 1; k++) {
				if (!"".equals(uris[k]))
					sb.append(uris[k]);
				sb.append("(.)+");
			}
			if (!"".equals(uris[uris.length - 1]))
				sb.append(uris[uris.length - 1]);
			if (all) {
				sb.append("(.)+");
			}
			sb.append("$");
			modules[i] = sb.toString();
		}
		return modules;
	}

	/**
	 * 只要有一个匹配就返回true
	 * 
	 * @param uri
	 *            要去匹配的字符串
	 * @param regexs
	 *            正则表达试字符串数组对象
	 * @return 匹配的索引, 没有找到则返回 -1
	 */
	public static int regexsMatches(String uri, String[] regexs) {
		for (int i = 0; i < regexs.length; i++) {
			if (uri.matches(regexs[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 检查是否全为数字
	 * 
	 * @param some
	 * @return
	 */
	public static boolean isAllDigital(String some) {
		Pattern p = Pattern.compile("^[\\d]+$");
		Matcher m = p.matcher(some);
		return m.find();
	}

	/**
	 * 判断是否全为字母
	 * 
	 * @param input
	 * @return
	 */
	public static boolean isAllLetter(String input) {
		int len = input.length();
		String format = "\\w{" + len + "}";
		return Pattern.compile(format).matcher(input.toLowerCase()).matches();

	}

	/**
	 * 获取字符串第一个字符大写的Unicode值
	 * 
	 * @param str
	 *            字符串
	 * @return 小于65535的整数
	 */
	public static int getFirstUpperUnicode(String str) {
		String firstUpper = str.substring(0, 1).toUpperCase();
		int ret = firstUpper.hashCode();
		if (ret <= 65535) {
			return ret;
		} else {
			return 0;
		}
	}

	/**
	 * 判断是否为JSON字条串
	 * 
	 * @param json
	 *            JSON字符串
	 * @return
	 */
	public static boolean isJSONString(String json) {
		int len = json.length();
		for (int i = 0; i < len; i++) {
			if (json.charAt(i) != ' ' && json.charAt(i) != '\r' && json.charAt(i) != '\n') {
				if (json.charAt(i) != '{') {
					return false;
				} else {
					break;
				}
			}
		}
		for (int i = len - 1; i > 0; i--) {
			if (json.charAt(i) != ' ' && json.charAt(i) != '\r' && json.charAt(i) != '\n') {
				if (json.charAt(i) != '}') {
					return false;
				} else {
					break;
				}
			}
		}
		return true;
	}

	/**
	 * 判断是否为XML字条串
	 * 
	 * @param xml
	 * @return
	 */
	public static boolean isXMLString(String xml) {
		int len = xml.length();
		xml.trim();
		for (int i = 0; i < len; i++) {
			if (xml.charAt(i) != ' ' && xml.charAt(i) != '\r' && xml.charAt(i) != '\n') {
				if (xml.charAt(i) != '<') {
					return false;
				} else {
					break;
				}
			}
		}
		for (int i = len - 1; i > 0; i--) {
			if (xml.charAt(i) != ' ' && xml.charAt(i) != '\r' && xml.charAt(i) != '\n') {
				if (xml.charAt(i) != '>') {
					return false;
				} else {
					break;
				}
			}
		}
		return true;
	}

}
