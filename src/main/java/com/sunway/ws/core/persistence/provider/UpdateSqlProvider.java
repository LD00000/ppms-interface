package com.sunway.ws.core.persistence.provider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.Transient;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.jdbc.SQL;

import com.sunway.ws.core.utils.ClassUtils;
import com.sunway.ws.core.utils.ObjectUtils;
import com.sunway.ws.core.utils.StringUtils;

/**
 * 提供更新通用语句
 */
public class UpdateSqlProvider<T> extends MapperTemplate<T> {
	
	/**
	 * 更新</br>
	 * 根据 id 更新</br>
	 * 驼峰命名会转下划线命名
	 * 
	 * @param obj
	 * @return
	 */
	public String update(T obj) {
		@SuppressWarnings("unchecked")
		final Class<T> clazz = ClassUtils.getOriginalClass((Class<T>) obj.getClass());
		
		SQL sql = new SQL().UPDATE(super.getTableName(clazz));
		
		for (Field property : clazz.getDeclaredFields()) {
			if (property.isAnnotationPresent(Transient.class)) {
				continue;
			}
			
			final String propertyName = property.getName();
			
			Object inValue = null;
			try {
				inValue = PropertyUtils.getProperty(obj, propertyName);
			} catch (IllegalAccessException e) {
				throw new RuntimeException("构造 update 语句 error...", e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException("构造 update 语句 error...", e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException("构造 update 语句 error...", e);
			}
			
			// 只添加非空的字段
			if (ObjectUtils.isEmpty(inValue)) {
				continue;
			}
			
			sql.SET(StringUtils.camelhumpToUnderline(propertyName) + " = " + "#{"+ propertyName +"}");
		}
		sql.WHERE("ID = #{id}");
		
		return sql.toString();
	}
	
}
