package com.sunway.ws.module.common.dao;

import org.apache.ibatis.annotations.InsertProvider;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.InsertSqlProvider;
import com.sunway.ws.module.common.bean.InterfaceLogBean;

@MyBatisDao
public interface InterfaceLogDao {
	
	@InsertProvider(type = InsertSqlProvider.class, method = "insert")
	public int insert(InterfaceLogBean interfaceLogBean);

}
