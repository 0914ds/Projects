package com.qk365.base.utils;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;

/**
 * Webservice调用工具类
 */
public abstract class WebServiceUtils {

	private static final DynamicClientFactory dcf = DynamicClientFactory.newInstance();

	/**
	 * Webservice调用
	 * 
	 * @param url
	 * @param method
	 * @return
	 */
	public static Object[] invoke(String url, String method) {
		return invoke(url, method, new Object[0]);
	}

	/**
	 * Webservice调用
	 * 
	 * @param url
	 * @param method
	 * @param params
	 * @return
	 */
	public static Object[] invoke(String url, String method, Object[] params) {
		return invoke(url, null, method, params);
	}

	/**
	 * Webservice调用
	 * 
	 * @param url
	 * @param namespace
	 * @param method
	 * @param params
	 * @return
	 */
	public static Object[] invoke(String url, String namespace, String method, Object[] params) {
		Object[] result = null;
		Client client = dcf.createClient(url);
		try {
			result = namespace != null ? client.invoke(new QName(namespace, method), params) : client.invoke(method, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// public static void main(String[] args) {
	// String url = "http://esb.mysnail.com:3322/eHRSystemService/eHRSystemService.asmx?wsdl";
	// // String namespace = "http://server.webservice.inte.snail.com/";
	// Object[] result = invoke(url, "GetGreenOfficeEmpList");
	// System.out.println(result[0]);
	//
	// /*
	// * url = "http://58.211.28.186:81/eHRSystemService/eHRSystemService.asmx?wsdl"; result = WebServiceUtils.invoke(url, "GetGreenOfficeEmpList"); System.out.println(result[0]);
	// */
	// }

}
