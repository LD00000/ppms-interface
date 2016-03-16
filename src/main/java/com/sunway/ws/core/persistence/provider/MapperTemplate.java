package com.sunway.ws.core.persistence.provider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.beanutils.PropertyUtils;

import com.sunway.ws.core.utils.ObjectUtils;

public abstract class MapperTemplate<T> {
	
	/**
	 * 获取非空字段
	 * 
	 * @param obj
	 * @param fields
	 * @return
	 */
	protected List<Field> getUnEmptyFields(Object obj, Field... fields) {
		List<Field> retFields = new ArrayList<Field>();
		for (Field property : fields) {
			if (property.isAnnotationPresent(Transient.class)) {
				continue;
			}
			
			final String propertyName = property.getName();
			
			Object inValue = null;
			try {
				inValue = PropertyUtils.getProperty(obj, propertyName);
			} catch (IllegalAccessException e) {
				throw new RuntimeException("获取字段值 error...", e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException("获取字段值 error...", e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException("获取字段值 error...", e);
			}
			
			// 只添加非空的字段
			if (ObjectUtils.isEmpty(inValue)) {
				continue;
			}
			
			retFields.add(property);
		}
		return retFields;
	}
	
	/**
	 * 根据注解获得表名
	 * 
	 * @param info
	 * @return
	 */
	protected static final String getTableName(final Class<?> clazz) {
		if(clazz.isAnnotationPresent(Table.class)) {
			Table table = clazz.getAnnotation(Table.class);
			
			if (table != null) {
				return table.name().toLowerCase();
			}
		}
		
		return clazz.getSimpleName().toLowerCase();
	}
	
}
