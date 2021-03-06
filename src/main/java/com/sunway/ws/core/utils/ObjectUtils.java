package com.sunway.ws.core.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {
	
	/**
	 * 判断是否为空,只判断如下几种情况
	 * 1. Null
	 * 2. CharSequence or StringBuilder or StringBuffer = ""
	 * 3. Map.size = 0
	 * 4. Array.size = 0
	 * 5. Collection.size = 0
	 * 
	 * @param target 被判断的Object
	 * @return true 如果空
	 */
	public static final boolean isEmpty(final Object target) {
		if (target == null)
			return true;

		final Class<? extends Object> clazz = target.getClass();

		// 判断是不是CharSequence
		if (CharSequence.class.isAssignableFrom(clazz)) {
			return ((CharSequence)target).length() == 0;
		}
		
		// 判断是不是StringBuilder
		if (target instanceof StringBuilder)
			return ((StringBuilder) target).length()==0;
		
		// 判断是不是StringBuffer
		if (target instanceof StringBuffer)
			return ((StringBuffer) target).length()==0;

		// 判断是不是array
		if (clazz.isArray()) {
			if (Array.getLength(target)==0)
				return true;
			
			return false;
		}
		
		// 判断是不是Collection
		if (Collection.class.isAssignableFrom(clazz)) {
			if (((Collection<?>) target).size()==0)
				return true;
			
			return false;
		}
		
		// 判断是不是Map
		if (Map.class.isAssignableFrom(clazz)) {
			if (((Map<?,?>) target).size()==0)
				return true;
			
			return false;
		}
		
		return false;
	}

}
