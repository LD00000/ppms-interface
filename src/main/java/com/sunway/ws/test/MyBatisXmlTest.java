package com.sunway.ws.test;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;

@MyBatisDao
public interface MyBatisXmlTest {

	public String queryDual();
	
}
