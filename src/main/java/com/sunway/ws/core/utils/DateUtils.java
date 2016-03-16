package com.sunway.ws.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * {@link Date}相关的工具类
 */
public final class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	
	/**
	 * 日期和时间的格式化方法
	 * 
	 * @param dateTime 要被格式化的{@link Date}
	 * @return 格式化为{@link #DEFAULT_DATETIME_FORMAT}的{@link String}
	 */
	public static final String formatDateTime(final Date dateTime) {
		if (dateTime == null)
			return "";
		
		return new SimpleDateFormat(DEFAULT_DATETIME_FORMAT).format(dateTime);
	}
	
	/**
	 * 日期的格式化方法
	 * 
	 * @param date 要被格式化的{@link Date}
	 * @return 格式化为{@link #DEFAULT_DATE_FORMAT}的{@link String}
	 */
	public static final String formatDate(final Date date) {
		if (date == null)
			return "";
		
		return new SimpleDateFormat(DEFAULT_DATE_FORMAT).format(date);
	}
	
	/**
	 * 时间的格式化方法
	 * 
	 * @param time 要被格式化的{@link Date}
	 * @return 格式化为{@link #DEFAULT_DATE_FORMAT}的{@link String}
	 */
	public static final String formatTime(final Date time) {
		if (time == null)
			return "";
		
		return new SimpleDateFormat(DEFAULT_TIME_FORMAT).format(time);
	}
	
	/**
	 * 根据指定的格式，格式化日期和时间的方法
	 * 
	 * @param dateTime 要被格式化的{@link Date}
	 * @return 格式化为{@link #DEFAULT_DATETIME_FORMAT}的{@link String}
	 */
	public static final String formart(final Date time, final String pattern) {
		return new SimpleDateFormat(pattern).format(time);
	}
	
	
	/**
	 * 把指定的日期转换成从January 1, 1970, 00:00:00 GMT开始的天数
	 * 
	 * @param date 指定的日期
	 * @return 天数
	 */
	public static final Long getDays(final Date date) {
		if (date == null) {
			return 0L;
		}
		
		return date.getTime() / (1000 * 60 * 60 * 24);
	}
	
}
