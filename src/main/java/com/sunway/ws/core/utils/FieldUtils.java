package com.sunway.ws.core.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.ArrayUtils;

/**
 * field 工具类
 */
public final class FieldUtils extends org.apache.commons.lang3.reflect.FieldUtils {
	
	/**
	 * 获取子类和父类的所有属性
	 * 
	 * @param clazz	
	 * @param fields 
	 * @return
	 */
	public static final Field[] getFields(Class<?> clazz, Field[] fields) {
		if (clazz == null) {
			throw new IllegalArgumentException("clazz is null...");
		}
		
		for (Field field : clazz.getDeclaredFields()) {
			ArrayUtils.add(fields, field);
		}
		
		if (clazz.getSuperclass() != null) {
			fields = getFields(clazz.getSuperclass(), fields);
		}
		
		return fields;
	}
	
	/**
	 * 调用字段 get 方法返回对象
	 * 
	 * @param clazz 
	 * @param field 
	 * @return
	 */
	public static final Object readDeclaredField(Object object, Field field) {
		Object obj = null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), object.getClass());
			obj = pd.getReadMethod().invoke(object);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (IntrospectionException e) {
			throw new RuntimeException(e);
		}
		
		return obj;
	}
	
}
