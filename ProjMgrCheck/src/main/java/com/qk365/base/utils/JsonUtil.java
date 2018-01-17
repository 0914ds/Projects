package com.qk365.base.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
	private static final Logger LOG = Logger.getLogger(JsonUtil.class);
	
	/***
	 * Convert Object[] to VO
	 * @param data List<Object[]>
	 * @param clazz
	 * @param targetProperty Order ASC
	 * @return
	 */
	public static  <T>List<T> convertVO(List<Object[]> list, Class<T> clazz,String... targetProperty) {
		try {
			if (list != null && targetProperty.length > 0 && list.size() > 0) {
				List<T> dataList = new ArrayList<T>();
				if (!(list.get(0) instanceof Object[])) {
					String p = targetProperty[0];
					for (Object o : list) {
						T obj = (T) clazz.newInstance();
						Field fd = clazz.getDeclaredField(p);
						fd.setAccessible(true);
						fd.set(obj, o);
						dataList.add(obj);
					}

				} else {
					for (Object os : list) {
						Object[] oss = (Object[]) os;
						T obj = (T) clazz.newInstance();
						for (int i = 0; i < targetProperty.length; i++) {
							Field fd = clazz.getDeclaredField(targetProperty[i]);
							fd.setAccessible(true);
							if (oss[i] instanceof Number) {
								Number nb = (Number) oss[i];
								if (	   fd.getType().equals(Double.class)
										|| fd.getType().equals(double.class)) {
									fd.set(obj, nb.doubleValue());
								} else if (fd.getType().equals(byte.class)
										|| fd.getType().equals(Byte.class)) {
									fd.set(obj, nb.byteValue());
								} else if (fd.getType().equals(long.class)
										|| fd.getType().equals(Long.class)) {
									fd.set(obj, nb.longValue());
								} else if (fd.getType().equals(Float.class)
										||fd.getType().equals(float.class)) {
									fd.set(obj, nb.floatValue());
								} else if (fd.getType().equals(Integer.class)
										||fd.getType().equals(int.class)) {
									fd.set(obj, nb.intValue());
								} else if (fd.getType().equals(Boolean.class)
										|| fd.getType().equals(boolean.class)) {
									if (nb.intValue() == 1) {
										fd.set(obj, true);
									} else {
										fd.set(obj, false);
									}
								} else {
									fd.set(obj, nb);
								}
							} else {
								if (fd.getType().getSuperclass().getSimpleName().equalsIgnoreCase("enum")) {
									fd.set(obj,fd.getType().getDeclaredMethod(
															"valueOf",String.class).invoke(null, oss[i]));

								} else {
									fd.set(obj, oss[i]);
								}

							}
						}
						dataList.add(obj);

					}
				}

				
				return dataList;
			}
			return new ArrayList<T>();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * JSON转map
	 * @param jsonStr
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String jsonStr) {
		return jsonToBean(jsonStr, Map.class);
	}
	
	/**
	 * JavaBean转JSON
	 * @param <T>
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("finally")
	public static <T> String beanToJson(T obj) {
		String json = null;
		if (obj == null) { return json; }
		ObjectMapper mapper = null;
		try {
			mapper = new ObjectMapper();
			json = mapper.writeValueAsString(obj); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mapper = null;
			return json;
		}
	}
	
	/**
	 * JSON转JavaBean
	 * @param <T>
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	@SuppressWarnings({ "finally", "unchecked" })
	public static <T> T jsonToBean(String jsonStr, Class<?> valueType) {
		T obj = null;
		if (jsonStr == null || "".equals(jsonStr)) {
			return null;
		}
		ObjectMapper mapper = null;
		try {
			mapper = new ObjectMapper();
			obj = (T) mapper.readValue(jsonStr, valueType); 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			mapper = null;
			return obj;
		}
	}
	
	public static String getJsonString(JSONObject obj, String key, String defValue) {
		try {
			return obj.getString(key);
		} catch (JSONException e) {
			LOG.error("error",e);
			return defValue;
		}
	}
	
	public static double getJsonDouble(JSONObject obj, String key, double defValue) {
		try {
			return obj.getDouble(key);
		} catch (JSONException e) {
			LOG.error("error",e);
			return defValue;
		}
	}
	
	public static int getJsonInt(JSONObject obj, String key, int defValue) {
		try {
			return obj.getInt(key);
		} catch (JSONException e) {
			LOG.error("error",e);
			return defValue;
		}
	}
}
