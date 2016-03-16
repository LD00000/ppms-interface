package com.sunway.ws.module.erp.common;

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
import com.sunway.ws.module.erp.business.cght.CghtWSInterface;
import com.sunway.ws.module.erp.business.ckd.CkdWSInterface;
import com.sunway.ws.module.erp.business.feedback.CgjhFeedbackWSInterface;
import com.sunway.ws.module.erp.business.kjxy.KjxyWSInterface;
import com.sunway.ws.module.erp.business.lcb.LcbWSInterface;
import com.sunway.ws.module.erp.business.rkd.RkdWSInterface;

@Component
public class ConfigSchedule {
	
	private final static Logger logger = LogManager.getLogger(ConfigSchedule.class);
	
	/**
	 * 更新接口配置， 5分钟一次
	 */
	@Scheduled(fixedDelay=5 * 60 * 1000, initialDelayString="3000")
	public void updateConfig() {
		logger.info("更新接口配置...");
		
		updateCache(WSInterface.ERP_CGJH_FEEDBACK.getName(), CgjhFeedbackWSInterface.class);
		updateCache(WSInterface.ERP_CGHT.getName(), CghtWSInterface.class);
		updateCache(WSInterface.ERP_CKD.getName(), CkdWSInterface.class);
		updateCache(WSInterface.ERP_RKD.getName(), RkdWSInterface.class);
		updateCache(WSInterface.ERP_KJXY.getName(), KjxyWSInterface.class);
		updateCache(WSInterface.ERP_LCB.getName(), LcbWSInterface.class);
	}
	
	/**
	 * 存入缓存
	 * 
	 * @param interfaceName
	 * @param serviceClass
	 */
	private void updateCache(String interfaceName,  Class<?> serviceClass) {
		InterfaceConfigBean config = GeneralQuery.getInterfaceConfig(interfaceName);
		if (config == null || Constants.NO_STR.equals(config.getEnabled())) {
			CacheManager.putObject(Constants.CACHE_NAME, interfaceName, null);
		} else {
			CacheManager.putObject(Constants.CACHE_NAME, interfaceName, 
					new JaxwsClient(config, serviceClass).getClientByJaxWsProxyFactory());
			CacheManager.putObject(Constants.CACHE_NAME, interfaceName + Constants.CRON, config.getTime()); 
		}
	}

}
