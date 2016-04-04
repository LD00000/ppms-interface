package com.sunway.ws.module.erp.common;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunway.ws.core.general.GeneralQuery;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.bean.InterfaceConfigBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-context.xml"})
@Rollback(true)
@ActiveProfiles("test")
public class ConfigTest {

	@Test
	public void conTest() {
		List<InterfaceConfigBean> configs = GeneralQuery.getAllInterfaceConfig();
		
		for (InterfaceConfigBean config : configs) {
			System.out.println(config.getId());
			System.out.println(config.getName());
			System.out.println(WSInterface.valueOf(config.getName()));
			System.out.println(WSInterface.valueOf(config.getName()).getWSInterfaceClazz());
			
		}
	}
	
}
