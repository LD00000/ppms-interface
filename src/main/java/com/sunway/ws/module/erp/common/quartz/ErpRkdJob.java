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
import com.sunway.ws.module.erp.business.rkd.RkdWSInterface;
import com.sunway.ws.module.erp.business.rkd.bean.RkdServerBean;
import com.sunway.ws.module.erp.business.rkd.dao.RkdDao;
import com.sunway.ws.module.erp.business.rkd.service.RkdService;

/**
 * 旧JOB ,废弃
 */
@Deprecated
@DisallowConcurrentExecution
public class ErpRkdJob extends QuartzJobBean {
	
	private final static Logger logger = LogManager.getLogger(ErpCkdJob.class);
	
	@Autowired
	private RkdDao rkdDao;
	@Autowired
	private RkdService rkdService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("job run, des:{}, NextFireTime:{}", context.getJobDetail().getDescription(), context.getTrigger().getNextFireTime());

		final Object clientO = CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_RKD.getName());
		if (clientO == null) {
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", WSInterface.ERP_RKD.getName());
			return;
		}
		
		QuartzManager.updateCronExpression(context, 
				(String) CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_RKD.getName() + Constants.CRON));

		final RkdWSInterface client = (RkdWSInterface)clientO;
		try {
			rkdDao.pullRkd();	// 从业务表构造数据
			
			final List<RkdServerBean> rkdServerBeans = rkdService.getPushErpRkd();
			for (RkdServerBean rkdServerBean : rkdServerBeans) {
				rkdServerBean.getIsheader().setStatus(Constants.PUSH_FAILED);
				
				client.siSEGPPMSCAGRREQAOUT(rkdServerBean);	// 推送数据
				
				rkdServerBean.getIsheader().setStatus(Constants.PUSH_SUCCESS);
				rkdDao.updateStatus(rkdServerBean.getIsheader());
				
				logger.info("ERP 入库单接口, 推送成功，编码：" + rkdServerBean.getIsheader().getRkdh());
			}
		} catch (Exception e) {
			throw new ClientException(e);
		}
	}

}
