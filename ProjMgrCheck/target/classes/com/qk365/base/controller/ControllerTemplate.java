package com.qk365.base.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qk365.base.vo.ResultVO;

import net.sf.json.JSONObject;

/**
 * 针对微信端的控制器
 */
public abstract class ControllerTemplate {

	private static final Logger logger = Logger.getLogger(ControllerTemplate.class);
	

	/** 跨域访问所需回调函数的参数名 **/
	private static final String JSON_Callback_Key = "jsoncallback";

	/**
	 * 输出消息
	 * 
	 * @param result
	 * @param request
	 * @param response
	 */
	protected void outputResult(ResultVO result, HttpServletRequest request, HttpServletResponse response) {
		JSONObject jsonObject = JSONObject.fromObject(result);
		String data = jsonObject.toString();
		// System.out.println();
		// System.out.println(data);
		// System.out.println();
		outout(data, request, response);
	}

	/**
	 * 经过代理以后，由于在客户端和服务之间增加了中间层，因此服务器无法直接拿到客户端的IP，<br>
	 * 服务器端应用也无法直接通过转发请求的地址返回给客户端。 但是在转发请求的HTTP头信息中，<br>
	 * 增加了X－FORWARDED－FOR信息用以跟踪原有的客户端IP地址和原来客户端请求的服务器地址。
	 * 原来如此，我们的项目中正好是有前置apache， 将一些请求转发给后端的weblogic，<br>
	 * 看来就是这样导致的。
	 * 
	 * 
	 * @param request
	 * @return 获取真实的IP
	 */
	public String getRemoteAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.split(",").length > 1) {
			ip = ip.split(",")[0];
		}
		return ip;
	}

	// ****Private Function****
	/**
	 * 输出数据
	 * 
	 * @param data
	 * @param request
	 * @param response
	 */
	private void outout(String data, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		String jsoncallback = request.getParameter(JSON_Callback_Key);
		// 是否有跨域回调参数
		if (null != jsoncallback && jsoncallback.trim().length() > 0) {
			data = jsoncallback + "(" + data + ");";
		}
		try {
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
		} catch (IOException e) {
			logger.error("out print error", e);
		}
	}

}
