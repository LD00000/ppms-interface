package com.sunway.ws.module.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sunway.ws.core.utils.SpringUtils;
import com.sunway.ws.module.common.bean.InterfaceDataStatusBean;

public class InterfaceDataStatusDaoImpl implements InterfaceDataStatusDao {
	
	private final SqlSession sqlSession = SpringUtils.getBean("sqlSession");
	private final InterfaceDataStatusDao dao = sqlSession.getMapper(InterfaceDataStatusDao.class);

	@Override
	public int insert(InterfaceDataStatusBean interfaceDataStatusBean) {
		return dao.insert(interfaceDataStatusBean);
	}

	@Override
	public List<InterfaceDataStatusBean> queryRetryData() {
		return dao.queryRetryData();
	}

	@Override
	public void update(InterfaceDataStatusBean interfaceDataStatusBean) {
		dao.update(interfaceDataStatusBean);
	}

}
