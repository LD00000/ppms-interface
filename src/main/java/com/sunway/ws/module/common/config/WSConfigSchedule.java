package com.sunway.ws.module.common.config;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sunway.ws.core.Constants;
import com.sunway.ws.core.cache.CacheManager;
import com.sunway.ws.core.cxf.client.JaxwsClient;
import com.sunway.ws.core.general.GeneralQuery;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.bean.InterfaceConfigBean;

@Component
public class WSConfigSchedule {
	
	private final static Logger logger = LogManager.getLogger(WSConfigSchedule.class);
	
	/**
	 * 更新接口配置， 5分钟一次
	 */
	@Scheduled(fixedDelay=5 * 60 * 1000, initialDelayString="3000")
	public void updateConfig() {
		logger.info("更新接口配置...");
		
		List<InterfaceConfigBean> configs = GeneralQuery.getAllInterfaceConfig();
		
		for (InterfaceConfigBean config : configs) {
			if (!Constants.NO_STR.equals(config.getEnabled())) {
				CacheManager.putObject(Constants.CACHE_NAME, config.getName(), 
						new JaxwsClient(config, WSInterface.valueOf(config.getName()).getWSInterfaceClazz()).getClientByJaxWsProxyFactory());
			}
		}
	}
	
}
