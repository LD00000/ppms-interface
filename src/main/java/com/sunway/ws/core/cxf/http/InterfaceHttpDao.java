package com.sunway.ws.core.cxf.http;

import org.apache.ibatis.annotations.InsertProvider;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.InsertSqlProvider;

@MyBatisDao
public interface InterfaceHttpDao {
	
	/**
	 * 插入
	 * 
	 * @param interfaceHttpBean
	 * @return
	 */
	@InsertProvider(type = InsertSqlProvider.class, method = "insert")
	public int insert(InterfaceHttpBean interfaceHttpBean);
	
}
