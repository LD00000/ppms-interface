package com.sunway.ws.module.erp.business.feedback.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectKey;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.InsertSqlProvider;
import com.sunway.ws.module.erp.business.feedback.bean.ErpLog;

@MyBatisDao
public interface ErpLogDao {
	
	/**
	 * 插入
	 * 
	 * @param entity
	 * @return
	 */
	@InsertProvider(type = InsertSqlProvider.class, method = "insert")
	@SelectKey(statement="SELECT SEQ_INTERFACE_LOG.NEXTVAL FROM DUAL", before = true, keyProperty = "id", resultType = long.class)
	public int insert(ErpLog entity);

}
