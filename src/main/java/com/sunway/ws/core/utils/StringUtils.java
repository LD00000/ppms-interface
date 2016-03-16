package com.sunway.ws.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

	/**
	 * 驼峰命名转下划线命名
	 * 
	 * @param str
	 * @return
	 */
	public static String camelhumpToUnderline(String str) {
		final char[] chars;
		final StringBuilder builder = new StringBuilder((chars = str.toCharArray()).length * 3 / 2 + 1);
		for (char c : chars) {
			if (isUppercaseAlpha(c)) {
				builder.append("_").append(toLowerAscii(c));
			} else {
				builder.append(toUpperAscii(c));
			}
		}
		return builder.charAt(0) == '_' ? builder.substring(1) : builder.toString();
	}
	
	/**
	 * 下划线命名转驼峰
	 * 
	 * @param str
	 * @return
	 */
	public static String underlineToCamelhump(String str) {
		Matcher matcher = Pattern.compile("_[a-z]").matcher(str);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; matcher.find(); i++) {
			builder.replace(matcher.start() - i, matcher.end() - i, matcher.group().substring(1).toUpperCase());
		}
		if (Character.isUpperCase(builder.charAt(0))) {
			builder.replace(0, 1, String.valueOf(Character.toLowerCase(builder.charAt(0))));
		}
		return builder.toString();
	}
	
	private static boolean isUppercaseAlpha(char c) {
		return (c >= 'A') && (c <= 'Z');
	}
	
//	private static boolean isLowercaseAlpha(char c) {
//		return (c >= 'a') && (c <= 'z');
//	}
	
	private static char toUpperAscii(char c) {
		if (isUppercaseAlpha(c)) {
			c -= (char) 0x20;
		}
		return c;
	}
	
	private static char toLowerAscii(char c) {
		if (isUppercaseAlpha(c)) {
			c += (char) 0x20;
		}
		return c;
	}
	
}
