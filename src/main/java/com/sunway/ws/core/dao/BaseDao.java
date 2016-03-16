package com.sunway.ws.core.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;

import com.sunway.ws.core.persistence.provider.InsertSqlProvider;
import com.sunway.ws.core.persistence.provider.SelectSqlProvider;

public interface BaseDao<T> {

	/**
	 * 查询一个对象
	 * 
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SelectSqlProvider.class, method = "querySingleTable")
	public T queryForObject(T entity);

//	/**
//	 * 查询多条数据
//	 * 
//	 * @param entity
//	 * @return
//	 */
//	@SelectProvider(type = SelectSqlProvider.class, method = "querySingleTable")
//	public List<T> queryForList(T entity);
	
	/**
	 * 插入
	 * 
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = InsertSqlProvider.class, method = "insert")
//	@SelectKey(statement="call next value for SEQ_INTERFACE", before = true, keyProperty = "id", resultType = long.class)
	public int insert(T entity);
	
//	/**
//	 * 批量插入
//	 * 
//	 * @param entity
//	 * @return
//	 */
//	@InsertProvider(type = InsertSqlProvider.class, method = "batchInsert")
////	@SelectKey(statement="call next value for SEQ_INTERFACE", before = true, keyProperty = "id", resultType = long.class)
//	public int batchInsert(List<T> list);
	
	/**
	 * 更新
	 * 
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除
	 * 
	 * @param entity
	 * @return
	 */
	public int delete(T entity);

}
