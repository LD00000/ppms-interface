package com.sunway.ws.core.persistence.provider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.jdbc.SQL;

import com.sunway.ws.core.utils.ClassUtils;
import com.sunway.ws.core.utils.ObjectUtils;
import com.sunway.ws.core.utils.StringUtils;

/**
 * 提供 insert 通用语句
 */
public class InsertSqlProvider<T> extends MapperTemplate<T> {
	
	/**
	 * 插入<br>
	 * 驼峰命名会转下划线命名
	 * 
	 * @param obj
	 * @return
	 */
	public String insert(T obj) {
		@SuppressWarnings("unchecked")
		final Class<T> clazz = ClassUtils.getOriginalClass((Class<T>) obj.getClass());
		
		SQL sql = new SQL().INSERT_INTO(super.getTableName(clazz));
		
		for (Field property : clazz.getDeclaredFields()) {
			if (property.isAnnotationPresent(Transient.class)) {
				continue;
			}
			
			final String propertyName = property.getName();
			
			Object inValue = null;
			try {
				inValue = PropertyUtils.getProperty(obj, propertyName);
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
			
			sql.VALUES(StringUtils.camelhumpToUnderline(propertyName), "#{"+ propertyName +"}");
		}
		
		return sql.toString();
	}
	
	/**
	 * 批量插入
	 * 默认 List<T> 中 T 对象的结构都相同 <br>
	 * Oracle 批量插入方式，无数据库方言 <br>
	 * 驼峰命名会转下划线命名
	 * 
	 * <p>insert into table (id,htbm)
	 * <p>select '3','2' from dual 
	 * <p>union all 
	 * <p>select '4','2' from dual
	 * 
	 * @param objs
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public String batchInsert(Map<String, Object> para) {
		if (para.get("list") == null) 
			return "SELECT 1 FROM dual";
					
		final List<T> list = (List<T>) para.get("list");
		
		if (list.size() == 0) {	
			return "SELECT 1 FROM dual";	
		}
		
		final Object firstObj = list.get(0);
		final Class<T> clazz = ClassUtils.getOriginalClass((Class<T>) firstObj.getClass());
		
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(super.getTableName(clazz)).append(" (");
		StringBuilder valueSql = new StringBuilder(" SELECT ");
		
		List<Field> fields = super.getUnEmptyFields(firstObj, clazz.getDeclaredFields());
		int i = 0;
		for (Field field : fields) {
			if (i++ > 0) {
				sql.append(",");
				valueSql.append(",");
			}
			
			sql.append(StringUtils.camelhumpToUnderline(field.getName()));
			valueSql.append("#{list[?].").append(field.getName()).append("}");
		}
		sql.append(") \n");
		valueSql.append(" FROM dual \n");
		
		for (int j = 0; j < list.size(); j++) {
			if (j > 0) {
				sql.append(" UNION ALL \n");
			}
			
			sql.append(StringUtils.replaceChars(valueSql.toString(), "?", String.valueOf(j)));
		}
		
		return sql.toString();
	}
	
}
