package com.sunway.ws.module.erp.business.cgjh.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.InsertSqlProvider;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhItemKjxyBean;

@MyBatisDao
public interface CgjhItemKjxyDao extends BaseDao<CgjhItemKjxyBean> {
	
	/**
	 * 批量插入
	 * 
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = InsertSqlProvider.class, method = "batchInsert")
//	@SelectKey(statement="call next value for SEQ_INTERFACE", before = true, keyProperty = "id", resultType = long.class)
	public int batchInsert(@Param("list") List<CgjhItemKjxyBean> list);

}
