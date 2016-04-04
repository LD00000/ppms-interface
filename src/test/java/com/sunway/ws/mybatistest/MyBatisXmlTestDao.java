package com.sunway.ws.mybatistest;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface MyBatisXmlTestDao {

	public String queryDual();
	
}
