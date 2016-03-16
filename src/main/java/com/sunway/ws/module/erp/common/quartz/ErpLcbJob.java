package com.sunway.ws.module.erp.common.quartz;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.sunway.ws.core.Constants;
import com.sunway.ws.core.cache.CacheManager;
import com.sunway.ws.core.exception.ClientException;
import com.sunway.ws.core.quartz.QuartzManager;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.erp.business.lcb.LcbWSInterface;
import com.sunway.ws.module.erp.business.lcb.bean.LcbServiceBean;
import com.sunway.ws.module.erp.business.lcb.dao.LcbDao;
import com.sunway.ws.module.erp.business.lcb.service.LcbService;

/**
 * 旧JOB ,废弃
 */
@Deprecated
@DisallowConcurrentExecution
public class ErpLcbJob extends QuartzJobBean {
	
	private final static Logger logger = LogManager.getLogger(ErpLcbJob.class);
	
	@Autowired
	private LcbService lcbService;
	@Autowired
	private LcbDao lcbDao;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("job run, des:{}, NextFireTime:{}", context.getJobDetail().getDescription(), context.getTrigger().getNextFireTime());
		
		final Object clientO = CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_LCB.getName());
		if (clientO == null) {
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", WSInterface.ERP_LCB.getName());
			return;
		}
		
		QuartzManager.updateCronExpression(context, 
				(String) CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_LCB.getName() + Constants.CRON));

		final LcbWSInterface client = (LcbWSInterface)clientO;
		
		try {
			lcbDao.pullLcb();	// 从业务表构造数据
			
			final List<LcbServiceBean> lcbServiceBeans = lcbService.getPushErpLcb();
			for (LcbServiceBean lcbService : lcbServiceBeans) {
				lcbService.getIsdochead().setStatus(Constants.PUSH_FAILED);
				
				client.siSEGPPMSCALCBREQAOUT(lcbService);	// 推送数据
				
				lcbService.getIsdochead().setStatus(Constants.PUSH_SUCCESS);
				lcbDao.updateStatus(lcbService.getIsdochead());
				
				logger.info("ERP 里程碑接口, 推送成功，编码：{}", lcbService.getIsdochead().getId());
			}
		} catch (Exception e) {
			throw new ClientException("ERP 里程碑接口出错...", e);
		}
		
	}

}
