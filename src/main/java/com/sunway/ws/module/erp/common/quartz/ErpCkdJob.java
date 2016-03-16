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
import com.sunway.ws.module.erp.business.ckd.CkdWSInterface;
import com.sunway.ws.module.erp.business.ckd.bean.CkdServerBean;
import com.sunway.ws.module.erp.business.ckd.dao.CkdDao;
import com.sunway.ws.module.erp.business.ckd.service.CkdService;

/**
 * 旧JOB ,废弃
 */
@Deprecated
@DisallowConcurrentExecution
public class ErpCkdJob extends QuartzJobBean {
	
	private final static Logger logger = LogManager.getLogger(ErpCkdJob.class);
	
	@Autowired
	private CkdDao ckdDao;
	@Autowired
	private CkdService ckdService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("job run, des:{}, NextFireTime:{}", context.getJobDetail().getDescription(), context.getTrigger().getNextFireTime());
		
		final Object clientO = CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_CKD.getName());
		if (clientO == null) {
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", WSInterface.ERP_CKD.getName());
			return;
		}
		
		QuartzManager.updateCronExpression(context, 
				(String) CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_CKD.getName() + Constants.CRON));
		
		final CkdWSInterface client = (CkdWSInterface) clientO;
		try {
			ckdDao.pullCkd();	// 从业务表构造数据
			
			final List<CkdServerBean> ckdServerBeans = ckdService.getPushErpCkd();
			for (CkdServerBean ckdServerBean : ckdServerBeans) {
				ckdServerBean.getIsheader().setStatus(Constants.PUSH_FAILED);
				
				client.siSEGPPMSCAGIREQOUT(ckdServerBean);	// 推送数据
				
				ckdServerBean.getIsheader().setStatus(Constants.PUSH_SUCCESS);
				ckdDao.updateStatus(ckdServerBean.getIsheader());
				
				logger.info("ERP出库单接口，推送成功，出库单号：" + ckdServerBean.getIsheader().getCkdh());
			}
		} catch (Exception e) {
			throw new ClientException(e);
		}
	}

}
