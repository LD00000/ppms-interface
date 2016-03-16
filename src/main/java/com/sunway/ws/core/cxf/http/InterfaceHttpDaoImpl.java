package com.sunway.ws.core.cxf.http;

import org.apache.ibatis.session.SqlSession;

import com.sunway.ws.core.utils.SpringUtils;

public class InterfaceHttpDaoImpl implements InterfaceHttpDao {
	
	private SqlSession sqlSession = SpringUtils.getBean("sqlSession");

	public int insert(InterfaceHttpBean interfaceHttpBean) {
		InterfaceHttpDao interfaceHttpDao = sqlSession.getMapper(InterfaceHttpDao.class);
		
		return interfaceHttpDao.insert(interfaceHttpBean);
	}

}
