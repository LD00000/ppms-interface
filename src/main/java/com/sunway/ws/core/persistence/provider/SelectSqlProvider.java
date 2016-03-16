package com.sunway.ws.core.persistence.provider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Transient;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.jdbc.SQL;

import com.sunway.ws.core.utils.ClassUtils;
import com.sunway.ws.core.utils.ObjectUtils;

/**
 * 提供查询通用语句
 */
public class SelectSqlProvider<T> extends MapperTemplate<T> {

	/**
	 * 根据条件查询多条数据
	 * 
	 * @param condition
	 * @return
	 */
	public String querySingleTable(T condition) {
		@SuppressWarnings("unchecked")
		final Class<T> clazz = ClassUtils.getOriginalClass((Class<T>) condition.getClass());
		
		SQL sql = new SQL().FROM(super.getTableName(clazz));
		
		for (Field property : clazz.getDeclaredFields()) {
			if (property.isAnnotationPresent(Transient.class)) {
				continue;
			}
			
			final String propertyName = property.getName();
			sql.SELECT(propertyName);
			
			Object inValue = null;
			try {
				inValue = PropertyUtils.getProperty(condition, propertyName);
			} catch (IllegalAccessException e) {
				throw new RuntimeException("构造 insert 语句 error...", e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException("构造 insert 语句 error...", e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException("构造 insert 语句 error...", e);
			}
			
			// 只添加非空的字段
			if (ObjectUtils.isEmpty(inValue)) {
				continue;
			}
			
			sql.WHERE(propertyName + " = #{" + propertyName + "}");
		}
		
		return sql.toString();
	}
	
}
