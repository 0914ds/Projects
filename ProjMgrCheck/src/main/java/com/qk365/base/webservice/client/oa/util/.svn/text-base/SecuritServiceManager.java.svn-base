package com.qk365.base.webservice.client.oa.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;

import com.qk365.base.utils.JsonUtil;
import com.qk365.base.utils.PropertiesUtil;
import com.qk365.base.webservice.client.oa.ISecurityServices;
import com.qk365.base.webservice.client.oa.SecurityService;
import com.qk365.base.webservice.client.oa.bean.LoginResultDto;
import com.qk365.base.webservice.client.oa.bean.PersonFunctionDto;

/**
 * 登录new_HouseRent数据库的web service工具类
 * 
 * @author zhaoxy
 *
 */
public class SecuritServiceManager {

	// http://192.168.1.236:8080/iDataService/services/SecurityService?wsdl

	private final QName Services_SERVICE_NAME = new QName("http://impl.Security.WebService.jdnet.com/",
			"SecurityService");
	private static URL Services_wsdlURL;

	static {
		try {
			Services_wsdlURL = new URL(PropertiesUtil.getProperty("serviceURL") + "SecurityService?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回值不带员工号的登录接口,该接口对应的OA权限是直接分配到人的操作，未使用角色和组
	 * 
	 * @param tag：系统标示，在new_HouseRent数据库的tbl_function表的f_key字段
	 * @param userName
	 * @param password
	 * @return
	 */
	public LoginResultDto loginOAWithoutGroupRole(String systemTag, String userName, String password) {
		String result = "";

		result = login2(systemTag, userName, password);

		LoginResultDto user = null;
		if (null == result) {
			user = new LoginResultDto();
			return user;
		}
		user = JsonUtil.jsonToBean(result, LoginResultDto.class);
		if (user.getResult() == 0) {
			List<PersonFunctionDto> list = user.getPersonFunctionJsonDtoList();
			try {
				for (PersonFunctionDto personFunctionDto : list) {
					String code = personFunctionDto.getFunctionCode();
					personFunctionDto.setLvNum(code.split("_").length - 1 + "");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			user.setPersonFunctionJsonDtoList(list);
		}

		return user;
	}

	/**
	 * 返回值带员工号的登录接口,该接口对应的OA权限分配使用了角色和组
	 * 
	 * @param tag：系统标示，在new_HouseRent数据库的tbl_function表的f_key字段
	 * @param userName
	 * @param password
	 * @return
	 */
	public LoginResultDto loginOAWithGroupRole(String systemTag, String userName, String password) {
		String result = "";

		result = login3(systemTag, userName, password);

		LoginResultDto user = null;
		if (null == result) {
			user = new LoginResultDto();
			return user;
		}

		user = JsonUtil.jsonToBean(result, LoginResultDto.class);
		if (user.getResult() == 0) {
			List<PersonFunctionDto> list = user.getPersonFunctionJsonDtoList();
			try {
				for (PersonFunctionDto personFunctionDto : list) {
					String code = personFunctionDto.getFunctionCode();
					personFunctionDto.setLvNum(code.split("_").length - 1 + "");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			user.setPersonFunctionJsonDtoList(list);
		}

		return user;
	}

	/**
	 * 返回值不带员工号的登录接口,该接口对应的OA权限是直接分配到人的操作，未使用角色和组
	 * 
	 * @param tag：系统标示，在new_HouseRent数据库的tbl_function表的f_key字段
	 * @param userName
	 * @param password
	 * @return
	 */
	private String login2(String tag, String userName, String password) {
		String result = "";
		try {
			SecurityService service = new SecurityService(Services_wsdlURL);
			ISecurityServices iSecurityServices = service.getSecurityServicesImplPort();

			result = iSecurityServices.login2(tag, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 返回值带员工号的登录接口,该接口对应的OA权限分配使用了角色和组
	 * 
	 * @param tag：系统标示，在new_HouseRent数据库的tbl_function表的f_key字段
	 * @param userName
	 * @param password
	 * @return
	 */
	private String login3(String tag, String userName, String password) {
		String result = "";
		try {
			SecurityService service = new SecurityService(Services_wsdlURL, Services_SERVICE_NAME);
			ISecurityServices iSecurityServices = service.getSecurityServicesImplPort();

			result = iSecurityServices.login3(tag, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String modifyPassword(String userName, String oldPassword, String newPassword) {
		String result = "";
		try {
			SecurityService service = new SecurityService(Services_wsdlURL);
			ISecurityServices iSecurityServices = service.getSecurityServicesImplPort();
			result = iSecurityServices.modifyPassword(userName, oldPassword, newPassword);
		} catch (Exception e) {
			return result;
		}
		return result;
	}

	// /**
	// * 登录OA
	// * @param systemTag
	// * @param userName
	// * @param password
	// * @return
	// */
	// public static String login(String systemTag,String userName,String
	// password){
	// SecurityService sec=new SecurityServiceImple();
	// return sec.login3(systemTag, userName, password);
	// }

	public static void main(String[] args) {
		// 4无权限,

		// String result =login("KQ", "zac", "111111");//
		// iSecurityServices.login(IFACETOKEN, userDto.getUsername(),
		// userDto.getPassword());
		// LoginResultDto user = loginOA("KQ", "zac", "a123456");
		// System.out.println(user);
		/*
		 * if(null==result){ user = new LoginResultDto(); return; }
		 * System.out.println(result); user = ObjectUtil.jsonToBean(result,
		 * LoginResultDto.class);
		 */

		/*
		 * List<PersonFunctionDto> list=user.getPersonFunctionJsonDtoList(); for
		 * (PersonFunctionDto personFunctionDto : list) { String
		 * code=personFunctionDto.getFunctionCode();
		 * System.out.println(personFunctionDto.getPermissions());
		 * System.out.println(personFunctionDto.getLvNum());
		 * 
		 * }
		 */

	}
}
