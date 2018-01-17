package com.qk365.base.utils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期时间工具类
 */
public class DateUtils {

	// /** 日期格式化字符换 **/
	// public static final SimpleDateFormat sf_date = new SimpleDateFormat(DATE_DF);
	// /** 时间格式化字符串 **/
	// public static final SimpleDateFormat sf_datetime = new SimpleDateFormat(TIMESTAMP_DF);
	// /** 时间格式化字符串带毫秒 **/
	// public static final SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);

	/** yyyy-MM-dd格式化 **/
	public static final String DATE_DF = "yyyy-MM-dd";
	/** yyyyMMdd格式化 **/
	public static final String DATE_DF_2 = "yyyyMMdd";
	/** yyyy-MM格式化 **/
	public static final String DATE_MF = "yyyy-MM";
	/** yyyy格式化 **/
	public static final String DATE_YF = "yyyy";
	/** yyyy-MM-dd HH:mm:ss格式化 **/
	public static final String TIMESTAMP_DF = "yyyy-MM-dd HH:mm:ss";
	/** yyyy-MM-dd HH:mm:ss格式化 **/
	public static final String TIMESTAMP_DF1 = "yyyy-MM-dd HH:mm";
	/** yyyy-MM-dd HH:mm:ss:SSS格式化 **/
	public static final String TIMESTAMP_DF2 = "yyyy-MM-dd HH:mm:ss:SSS";
	/** yyyyMMddhhmmssSS格式化 **/
	public static final String TIMESTAMP_DF_MS = "yyyyMMddhhmmssSS";
	/** yyyyMMddhhmmss格式化 **/
	public static final String TIMESTAMP_DF_S = "yyyyMMddhhmmss";

	/**
	 * 返回当日最大最小时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getTodayRange() throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		String str = new SimpleDateFormat(DATE_DF).format(new Date());
		Date[] arr = { sf_datetime_mini.parse(new StringBuilder().append(str).append(" 00:00:00:000").toString()), sf_datetime_mini.parse(new StringBuilder().append(str).append(" 23:59:59:999").toString()) };
		return arr;
	}

	/**
	 * 返回指定日期的最大最小时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getRange(Date date) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		String str = new SimpleDateFormat(DATE_DF).format(date);
		Date[] arr = { sf_datetime_mini.parse(new StringBuilder().append(str).append(" 00:00:00:000").toString()), sf_datetime_mini.parse(new StringBuilder().append(str).append(" 23:59:59:999").toString()) };
		return arr;
	}

	/**
	 * 返回指定日期(yyyy-MM-dd)的最大最小时间
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getRange(String str) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		Date[] arr = { sf_datetime_mini.parse(new StringBuilder().append(str).append(" 00:00:00:000").toString()), sf_datetime_mini.parse(new StringBuilder().append(str).append(" 23:59:59:999").toString()) };
		return arr;
	}

	/**
	 * 字符串转时间
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date toDatetime(String str) throws ParseException {
		return new SimpleDateFormat(TIMESTAMP_DF).parse(str);
	}

	/**
	 * 字符串转日期
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return new SimpleDateFormat(DATE_DF).format(date);
	}

	/**
	 * 根据时间分页
	 * 
	 * @param pageId
	 * @param pageSize
	 * @return
	 */
	public static Date[] getDataArrayByPage(int pageId, int pageSize) {
		Date[] arr = new Date[pageSize];
		Calendar c = Calendar.getInstance();
		c.add(5, -1);
		pageId--;
		if (pageId > 0) {
			int diff = pageId * pageSize * -1;
			c.add(5, diff);
		}
		for (int i = 0; i < pageSize; i++) {
			arr[i] = c.getTime();
			c.add(5, -1);
		}
		return arr;
	}

	/**
	 * 日期是否同一天
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean isSame(Date d1, Date d2) {
		String s1 = dateToString(d1);
		String s2 = dateToString(d2);
		return s1.equals(s2);
	}

	/**
	 * 是否在开通时间范围内
	 * 
	 * @param openTime
	 * @return
	 */
	public static boolean isOpenTime(String openTime) {
		String[] arr = openTime.split("-");
		int start = Integer.parseInt(arr[0]);
		int end = Integer.parseInt(arr[1]);
		Calendar c = Calendar.getInstance();
		int hour = c.get(11);
		if ((start <= hour) && (hour < end)) {
			return true;
		}
		return false;
	}

	/**
	 * String -> Date，使用默认的日期格式{@link #TIMESTAMP_DF}解析
	 * 
	 * @param strDate
	 *            ，strDate 待解析的字符串
	 * @return Date对象
	 */
	public static Date parseDate(String strDate) {
		return parseDate(strDate, null);
	}

	/**
	 * String -> Date
	 * 
	 * @param strDate
	 *            待解析的字符串
	 * @param strFomate
	 *            格式 数值为空时 ,使用默认的日期格式{@link #TIMESTAMP_DF}解析
	 * @return Date对象
	 */
	public static Date parseDate(String strDate, String strFomate) {
		if (strFomate == null)
			strFomate = TIMESTAMP_DF;
		SimpleDateFormat df = new SimpleDateFormat(strFomate);

		return df.parse(strDate, new ParsePosition(0));
	}

	/**
	 * Date -> String
	 * 
	 * @param date
	 * @param strFormat
	 * @return
	 */
	public static String dateToString(Date date, String strFormat) {
		if (date == null || strFormat == null || strFormat.trim().length() == 0) {
			return "";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strFormat);
		return simpleDateFormat.format(date);
	}

	/**
	 * 根据年月 获取月份天数
	 * 
	 * @param dyear
	 * @param dmouth
	 * @return
	 * @throws ParseException
	 */
	public static int calDayByYearAndMonth(int dyear, int dmouth) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM");
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(simpleDate.parse(dyear + "/" + dmouth));
		return rightNow.getActualMaximum(Calendar.DAY_OF_MONTH);// 根据年月 获取月份天数
	}

	/**
	 * 获取指定时间的上一个自然月的始末日期
	 * 
	 * @param cal
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getPassedMonth(Calendar cal) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		int daysLastMonth = DateUtils.calDayByYearAndMonth(year, month - 1);// 上月天数
		String beginStr = new StringBuilder("").append(year).append("-").append(month - 1).append("-01 00:00:00:000").toString();
		String endStr = new StringBuilder("").append(year).append("-").append(month - 1).append("-").append(daysLastMonth).append(" 23:59:59:999").toString();
		Date begin = sf_datetime_mini.parse(beginStr);
		Date end = sf_datetime_mini.parse(endStr);
		Date[] arr = { begin, end };
		return arr;
	}

	/**
	 * 获取指定时间的当前自然月的始末日期
	 * 
	 * @param cal
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getThisMonth(Calendar cal) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		int daysLastMonth = DateUtils.calDayByYearAndMonth(year, month);// 该月天数
		String beginStr = new StringBuilder("").append(year).append("-").append(month).append("-01 00:00:00:000").toString();
		String endStr = new StringBuilder("").append(year).append("-").append(month).append("-").append(daysLastMonth).append(" 23:59:59:999").toString();
		Date begin = sf_datetime_mini.parse(beginStr);
		Date end = sf_datetime_mini.parse(endStr);
		Date[] arr = { begin, end };
		return arr;
	}

	/**
	 * 获取指定时间,之前7天的始末日期
	 * 
	 * @param cal
	 * @return
	 * @throws ParseException
	 */
	public static Date[] get7DayPassed(Calendar cal) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		Date endDate = cal.getTime();
		Date day7Before = getDate(endDate, 6);

		String beginStr = dateToString(day7Before, "yyyy-MM-dd") + " 00:00:00:000";
		String endStr = dateToString(endDate, "yyyy-MM-dd") + " 23:59:59:999";

		Date begin = sf_datetime_mini.parse(beginStr);
		Date end = sf_datetime_mini.parse(endStr);

		Date[] arr = { begin, end };
		return arr;

	}

	/**
	 * 获取指定时间,之前30天的始末日期
	 * 
	 * @param cal
	 * @return
	 * @throws ParseException
	 */
	public static Date[] get30DayPassed(Calendar cal) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		Date endDate = cal.getTime();
		Date day7Before = getDate(endDate, 29);

		String beginStr = dateToString(day7Before, "yyyy-MM-dd") + " 00:00:00:000";
		String endStr = dateToString(endDate, "yyyy-MM-dd") + " 23:59:59:999";

		Date begin = sf_datetime_mini.parse(beginStr);
		Date end = sf_datetime_mini.parse(endStr);

		Date[] arr = { begin, end };
		return arr;

	}

	/**
	 * 获取指定时间,最近一个自然月的始末日期(上月的N号 - 今天(N号日子))
	 * 
	 * @param cal
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getMonthPassed(Calendar cal) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		Date endDate = cal.getTime();
		cal.add(Calendar.MONTH, -1);
		Date day7Before = cal.getTime();

		String beginStr = dateToString(day7Before, "yyyy-MM-dd") + " 00:00:00:000";
		String endStr = dateToString(endDate, "yyyy-MM-dd") + " 23:59:59:999";

		Date begin = sf_datetime_mini.parse(beginStr);
		Date end = sf_datetime_mini.parse(endStr);

		Date[] arr = { begin, end };
		return arr;
	}

	/**
	 * 给定一个日期,返回该月初到该日期之前一天的日期<br>
	 * 比如给定 2014-05-15,则返回[2014-05-01,2014-05-14]<br>
	 * 比如给定 2014-05-01,则返回[],空数组<br>
	 * 
	 * @param cal
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getMonthPassed2(Calendar cal) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		int date = cal.get(Calendar.DATE);// 得到天
		if (date == 1) {
			return new Date[0];
		}
		int newDate = date - 1;
		String newDateStr = null;
		if (newDate < 10) {
			newDateStr = "0" + newDate;
		} else {
			newDateStr = "" + newDate;
		}
		String beginStr = new StringBuilder("").append(year).append("-").append(month).append("-01 00:00:00:000").toString();
		String endStr = new StringBuilder("").append(year).append("-").append(month).append("-").append(newDateStr).append(" 23:59:59:999").toString();
		Date begin = sf_datetime_mini.parse(beginStr);
		Date end = sf_datetime_mini.parse(endStr);
		Date[] arr = { begin, end };
		return arr;
	}

	/**
	 * 给定一个日期,返回该月初到该日期的日期<br>
	 * 比如给定 2014-05-15,则返回[2014-05-01 00:00:00:000,2014-05-15 23:59:59:999]<br>
	 * 比如给定 2014-05-01,则返回[2014-05-01 00:00:00:000,2014-05-15 23:59:59:999]<br>
	 * 
	 * @param cal
	 * @return
	 * @throws ParseException
	 */
	public static Date[] getMonthPassed3(Calendar cal) throws ParseException {
		SimpleDateFormat sf_datetime_mini = new SimpleDateFormat(TIMESTAMP_DF2);
		int year = cal.get(Calendar.YEAR);// 得到年
		int month = cal.get(Calendar.MONTH) + 1;// 得到月，因为从0开始的，所以要加1
		int date = cal.get(Calendar.DATE);// 得到天

		String newDateStr = null;
		if (date < 10) {
			newDateStr = "0" + date;
		} else {
			newDateStr = "" + date;
		}
		String beginStr = new StringBuilder("").append(year).append("-").append(month).append("-01 00:00:00:000").toString();
		String endStr = new StringBuilder("").append(year).append("-").append(month).append("-").append(newDateStr).append(" 23:59:59:999").toString();
		Date begin = sf_datetime_mini.parse(beginStr);
		Date end = sf_datetime_mini.parse(endStr);
		Date[] arr = { begin, end };
		return arr;
	}

	/**
	 * 根据日期 和 提前天数 ， 获得 指定日期提前几天的日期对象
	 * 
	 * @param inputDate
	 *            日期对象
	 * @param lazyDays
	 *            倒推的天数
	 * @return 指定日期倒推指定天数后的日期对象
	 * @throws ParseException
	 */
	public static Date getDate(Date inputDate, int beforeDays) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputDate);
		int inputDayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, inputDayOfYear - beforeDays);
		return cal.getTime();
	}

	/**
	 * 计算后一个日期比前一个日期多几天
	 * 
	 * @param inputDate
	 * @param inputDate
	 * @return
	 */
	public static int days(Date before, Date after) {
		before = DateUtils.parseDate(DateUtils.dateToString(before, DATE_DF), DATE_DF);
		after = DateUtils.parseDate(DateUtils.dateToString(after, DATE_DF), DATE_DF);
		Long i = (after.getTime() - before.getTime()) / (1000 * 60 * 60 * 24);
		return i.intValue();
	}

	/**
	 * 获取两个日历的月份之差
	 * 
	 * @param calendarBirth
	 * @param calendarNow
	 * @return
	 */
	public static int getDifferMonths(Calendar calendarOld, Calendar calendarNow) {
		return (calendarNow.get(Calendar.YEAR) - calendarOld.get(Calendar.YEAR)) * 12 + calendarNow.get(Calendar.MONTH) - calendarOld.get(Calendar.MONTH);
	}

	/**
	 * 判断这一天是否是月底
	 * 
	 * @param calendar
	 * @return
	 */
	public static boolean isEndOfMonth(Calendar calendar) {
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		if (dayOfMonth == calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
			return true;
		return false;
	}

	/**
	 * 判断这一天是否是月初1号
	 * 
	 * @param calendar
	 * @return
	 */
	public static boolean isBeginOfMonth(Calendar calendar) {
		int dayOfMonth = calendar.get(Calendar.DATE);
		return dayOfMonth == 1;
	}
}