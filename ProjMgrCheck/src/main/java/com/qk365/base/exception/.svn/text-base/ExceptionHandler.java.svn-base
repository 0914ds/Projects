package com.qk365.base.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.qk365.base.utils.ResultUtils;

import net.sf.json.JSONObject;

public class ExceptionHandler implements HandlerExceptionResolver {

	private static final Logger logger = Logger.getLogger(ExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception e) {
		logger.error("捕捉异常：", e);
		response.setContentType("text/html;charset=UTF-8");
		try {
			JSONObject jsonObject = JSONObject.fromObject(ResultUtils.buildErrorMessage("服务器繁忙"));
			String data = jsonObject.toString();
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
		} catch (IOException e1) {
			logger.error("", e1);
		}
		return null;
	}

}
