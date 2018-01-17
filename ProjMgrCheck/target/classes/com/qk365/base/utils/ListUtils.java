package com.qk365.base.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 列表工具类
 */
public class ListUtils {

	private static final Logger logger = Logger.getLogger(ListUtils.class);

	/**
	 * 列表排序
	 * 
	 * @param list
	 *            数据源
	 * @param methodName
	 *            获取排序数据的方法名
	 * @param desc
	 *            是否倒序
	 * @throws Exception
	 */
	public static <T> void sortList(List<T> list, String methodName, final boolean desc) throws Exception {
		if ((list == null) || (list.size() == 0)) {
			return;
		}
		final Method method = list.get(0).getClass().getDeclaredMethod(methodName, new Class[0]);
		Collections.sort(list, new Comparator<T>() {
			public int compare(T t1, T t2) {
				try {
					double n1 = Double.parseDouble(method.invoke(t1, new Object[0]).toString());
					double n2 = Double.parseDouble(method.invoke(t2, new Object[0]).toString());
					if (n1 > n2) {
						return desc ? -1 : 1;
					}
					if (n1 == n2) {
						return 0;
					}

					return desc ? 1 : -1;
				} catch (Exception e) {
					ListUtils.logger.error("", e);
				}
				return 0;
			}
		});
	}

	/**
	 * 结构对象列表转指定的属性列表
	 * 
	 * @param list
	 * @param clazz
	 * @param keyGetMethod
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, E> List<E> toKeyList(List<T> list, Class<T> clazz, String keyGetMethod) {
		List<E> idList = new ArrayList<E>();
		if (null == keyGetMethod) {
			keyGetMethod = "getId";
		}
		try {
			Method method = clazz.getDeclaredMethod(keyGetMethod);
			if (list != null && list.size() > 0) {
				for (T t : list) {
					E id = (E) method.invoke(t);
					idList.add(id);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return idList;
	}

	/**
	 * 查看集合中是否包含某条相等的数据,如果包含,返回集合中的这条数据,否则返回NULL
	 * 
	 * @param list
	 * @param bean
	 * @return
	 */
	public static <T> T isListContainsBean(List<T> list, T bean) {
		if (list == null || list.size() == 0 || bean == null) {
			return null;
		}
		for (T tmp : list) {
			if (tmp.equals(bean)) {
				return tmp;
			}
		}
		return null;
	}

	/**
	 * 查看对象集合中是否包含某个属性等于某个值的对象,如果有,返回该对象,否则返回NULL
	 * 
	 * @param list
	 * @param methodName
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static <T> T isListContainsBeanValue(List<T> list, String methodName, Object value) throws Exception {
		if (list == null || list.size() == 0 || methodName == null || methodName.length() == 0 || value == null) {
			return null;
		}
		final Method method = list.get(0).getClass().getDeclaredMethod(methodName, new Class[0]);
		for (T tmp : list) {
			if (value.equals(method.invoke(tmp))) {
				return tmp;
			}
		}
		return null;
	}

	/**
	 * map集合是否已经包含某个map,如果包含,返回该map,否则返回NULL(不能为空)
	 * 
	 * @param list
	 * @param key
	 * @param val
	 *            toString之后在进行比较
	 * @return
	 */
	public static <T, V> List<Map<T, V>> isMapListContainsKeyVal(List<Map<T, V>> list, T key, V val) {
		if (list == null || list.size() == 0 || key == null || val == null) {
			return null;
		}
		List<Map<T, V>> returnList = new ArrayList<Map<T, V>>();
		for (Map<T, V> map : list) {
			if (map.containsKey(key) && (val.toString().trim()).equals(map.get(key).toString().trim())) {
				returnList.add(map);
			}
		}
		return returnList;
	}

	/**
	 * map集合是否已经包含某个key,如果包含,返回该map,否则返回NULL(不能为空)
	 * 
	 * @param list
	 * @param key
	 * @return
	 */
	public static <T, V> Map<T, V> isMapListContainsKey(List<Map<T, V>> list, T key) {
		if (list == null || list.size() == 0 || key == null) {
			return null;
		}
		for (Map<T, V> map : list) {
			if (map.containsKey(key)) {
				return map;
			}
		}
		return null;
	}
}