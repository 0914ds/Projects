package com.qk365.base.utils;

import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;

/**
 * 统计所需的工具函数
 */
public class StatUtils {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 根据时间date，获得提前|滞后min分钟
	 * @param date 时间
	 * @param min 分钟
	 * @return
	 */
	public static Date getAheadOfTime(Date date, int min) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, min);
		return c.getTime();
	}

	/**
	 * 获取昨日最小-最大时间
	 * 
	 * @return
	 */
	public static Entry<Date, Date> getYesterdayBoundary() {
		// 时间设定到昨天
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		// 当日最小时间
		c.set(year, month, date, 0, 0, 0);
		Date start = c.getTime();
		// 当日最大时间
		c.set(year, month, date, 23, 59, 59);
		Date end = c.getTime();
		Entry<Date, Date> entry = new AbstractMap.SimpleEntry<Date, Date>(start, end);
		return entry;
	}

	/**
	 * 获取昨天日期
	 * 
	 * @return
	 */
	public static Date getYesterday() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	/**
	 * 获取给定日期的最小-最大时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date[] getDateBoundary(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		// 当日最小时间
		c.set(year, month, day, 0, 0, 0);
		Date start = c.getTime();
		// 当日最大时间
		c.set(year, month, day, 23, 59, 59);
		Date end = c.getTime();
		return new Date[] { start, end };
	}

	/**
	 * 格式化后日期
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateFormat.format(date);
	}

}
