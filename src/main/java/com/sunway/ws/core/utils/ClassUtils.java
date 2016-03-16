package com.sunway.ws.core.utils;

public class ClassUtils extends org.apache.commons.lang3.ClassUtils {

	/**
     * 用于判断是否是Proxy
     * CGLib 代理  判断字段  {@code $$EnhancerByCGLIB$$}
     * JDK 代理  判断字段  {@code $Proxy}
     * 
     * @param clazz {@link Class}用来判断
     * @return {@code true} 如果是Proxy
     */
	public static final boolean isProxy(final Class<?> clazz) {
		if (clazz == null)
			return false;
		
		final String name = clazz.getName();
		
		return name.contains("$$EnhancerByCGLIB$$") ||
				name.contains("$Proxy"); 
	}
	
	/**
	 * 获取一个类的原始类，避免取得{@code proxy}
	 * 
	 * @param <T> 类名
	 * @param clazz 要被取原始类的{@link Class}
	 * @return 原生类
	 */
	@SuppressWarnings("unchecked")
	public static final <T> Class<T> getOriginalClass(final Class<T> clazz) {
		if (isProxy(clazz)) {
			return (Class<T>) clazz.getSuperclass();
		} else {
			return clazz;
		}
	}
	
}
