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
import com.sunway.ws.module.erp.business.kjxy.KjxyWSInterface;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyServiceBean;
import com.sunway.ws.module.erp.business.kjxy.dao.KjxyDao;
import com.sunway.ws.module.erp.business.kjxy.service.KjxyService;

/**
 * 旧JOB ,废弃
 */
@Deprecated
@DisallowConcurrentExecution
public class ErpKjxyJob extends QuartzJobBean {
	
	private final static Logger logger = LogManager.getLogger(ErpKjxyJob.class);
	
	@Autowired
	private KjxyService kjxyService;
	@Autowired
	private KjxyDao kjxyDao;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("job run, des:{}, NextFireTime:{}", context.getJobDetail().getDescription(), context.getTrigger().getNextFireTime());
		
		final Object clientO = CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_KJXY.getName());
		if (clientO == null) {
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", WSInterface.ERP_KJXY.getName());
			return;
		}
		
		QuartzManager.updateCronExpression(context, 
				(String) CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_KJXY.getName() + Constants.CRON));
		
		final KjxyWSInterface kjxyClient = (KjxyWSInterface)clientO;
		
		try {
			kjxyDao.pullKjxy();	// 从业务表构造数据
			
			final List<KjxyServiceBean> kjxyServiceBeans = kjxyService.getPushErpKjxy();
			for (KjxyServiceBean kjxyserviceBean : kjxyServiceBeans) {
				kjxyserviceBean.getIsekohead().setStatus(Constants.PUSH_FAILED);
				
				kjxyClient.siSEGPPMSCAKJXYREQAOUT(kjxyserviceBean);	// 推送数据
				
				kjxyserviceBean.getIsekohead().setStatus(Constants.PUSH_SUCCESS);
				kjxyDao.updateStatus(kjxyserviceBean.getIsekohead());
				
				logger.info("ERP 框架协议接口, 推送成功，编码：{}", kjxyserviceBean.getIsekohead().getId());
			}
		} catch (Exception e) {
			throw new ClientException("ERP 框架协议接口出错...", e);
		}
		
	}

}
