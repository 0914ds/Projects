package com.qk365.base.utils;

import java.io.InputStream;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;

public class HttpClientUtil {
	private static int connTimeout = 60000; // 连接超时 60s
	private static int responeTimeout = 60000; // 相应超时60s

	private static String executeMethod(String method, String uri,
			Map<String, String> paramMap, String encoding) throws Exception {
		HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams()
				.setConnectionTimeout(connTimeout);
		client.getHttpConnectionManager().getParams()
				.setSoTimeout(responeTimeout);

		HttpMethod httpMethod = null;
		String body = "";
		InputStream input = null;

		if ("POST".equalsIgnoreCase(method)) {
			PostMethod post = new PostMethod(uri);
			if (paramMap != null) {
				NameValuePair[] params = new NameValuePair[paramMap.size()];
				int i = 0;
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					// params[i] = new NameValuePair(entry.getKey(),
					// URLEncoder.encode(entry.getValue(),encoding));
					params[i] = new NameValuePair(entry.getKey(),
							entry.getValue());
					i++;
				}
				post.setRequestBody(params);
			}
			httpMethod = post;
		} else if ("GET".equalsIgnoreCase(method)) {
			StringBuilder sb = new StringBuilder(uri);
			if (paramMap != null) {
				sb.append("?");
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					sb.append(entry.getKey()).append("=")
							.append(entry.getValue()).append("&");
				}
			}
			httpMethod = new GetMethod(sb.toString());
		} else {
			throw new RuntimeException("http方法名不支持." + method);
		}
		httpMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler()); // 系统默认3次

		try {
			int stateCode = client.executeMethod(httpMethod);
			if (stateCode != HttpStatus.SC_OK) {
				throw new RuntimeException("执行http失败."
						+ httpMethod.getStatusText() + ",stateCode:"
						+ httpMethod.getStatusCode());
			}
			input = httpMethod.getResponseBodyAsStream();
			body = IOUtils.toString(input, encoding);
			if (body != null) {
				body = body.trim();
			}
		} finally {
			if (input != null)
				input.close();
			if (httpMethod != null)
				httpMethod.releaseConnection();
			if (client != null) {
				SimpleHttpConnectionManager manager = (SimpleHttpConnectionManager) client
						.getHttpConnectionManager();
				manager.shutdown();
			}
		}
		return body;
	}

	public static String executeGetMethod(String uri,
			Map<String, String> paramMap) throws Exception {
		return executeMethod("GET", uri, paramMap, "utf-8");
	}

	public static String executePostMethod(String uri,
			Map<String, String> paramMap) throws Exception {
		return executeMethod("POST", uri, paramMap, "utf-8");
	}

	public static String executeGetMethod(String uri,
			Map<String, String> paramMap, String encoding) throws Exception {
		return executeMethod("GET", uri, paramMap, encoding);
	}

	public static String executePostMethod(String uri,
			Map<String, String> paramMap, String encoding) throws Exception {
		return executeMethod("POST", uri, paramMap, encoding);
	}

	public static String executeGetMethod(String uri) throws Exception {
		return executeMethod("GET", uri, null, "utf-8");
	}

	public static String executePostMethod(String uri) throws Exception {
		return executeMethod("POST", uri, null, "utf-8");
	}

}
