//package com.sunway.ws.module.erp.business;
//
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.sunway.ws.module.erp.business.lcb.bean.LcbServiceBean;
//import com.sunway.ws.module.erp.business.lcb.service.LcbService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath*:spring-context.xml"})
//@Rollback(true)
//public class LcbTest {
//	
//	@Autowired
//	private LcbService lcbService;
//	
//	@Test
//	public void lcbServiceTest() {
//		final List<LcbServiceBean> lcbServiceBeans = lcbService.getPushErpLcb();
//		
//		System.out.println("lcbServiceBeans:" + lcbServiceBeans);
//		
//		for (LcbServiceBean lcbServiceBean : lcbServiceBeans) {
//			System.out.println("lcbServiceBean:" + lcbServiceBean);
//		}
//		
//	}
//
//}
