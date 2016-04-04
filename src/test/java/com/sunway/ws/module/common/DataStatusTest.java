package com.sunway.ws.module.common;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunway.ws.module.common.bean.InterfaceDataStatusBean;
import com.sunway.ws.module.common.dao.InterfaceDataStatusDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-context.xml"})
@Rollback(true)
@ActiveProfiles("test")
public class DataStatusTest {
	
	@Autowired
	private InterfaceDataStatusDao interfaceDataStatusDao;
	
	@Test
	public void queryTest() {
		final List<InterfaceDataStatusBean> interfaceDataStatusBeans = interfaceDataStatusDao.queryRetryData();
		
		System.out.println(interfaceDataStatusBeans);
		System.out.println(interfaceDataStatusBeans.size());
	}

}
