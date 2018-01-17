package com.qk365.base.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @Title: properties文件操作类
 * @Description: 自定义PropertyPlaceholderConfigurer读取properties文件，
 *               提供根据key读取value的方法
 */
public class PropertyConfig extends PropertyPlaceholderConfigurer {

	/** properties文件内容 */
	private final static Map<String, String> ctxPropertiesMap = new HashMap<String, String>();

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		// 存储properties文件中的key,value到map中
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	/**
	 * 根据properties中的key获取对应的value
	 * 
	 * @param key
	 *            properties中的key
	 * @return properties文件中的value
	 */
	public static String getContextProperty(String key) {
		return ctxPropertiesMap.get(key);
	}
}