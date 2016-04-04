package com.sunway.ws.mybatistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-context.xml"})
@Rollback(true)
@ActiveProfiles("test")
public class MyBatisTest {
	
	@Autowired
	private MyBatisTestDao myBatisTestDao;
	
	@Test
	public void mTest() {
		myBatisTestDao.queryDual("1");
	}

}
