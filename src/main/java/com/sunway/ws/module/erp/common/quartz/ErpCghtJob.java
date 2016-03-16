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
import com.sunway.ws.module.erp.business.cght.CghtWSInterface;
import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;
import com.sunway.ws.module.erp.business.cght.dao.CghtDao;
import com.sunway.ws.module.erp.business.cght.service.CghtService;

/**
 * 旧JOB ,废弃
 */
@Deprecated
@DisallowConcurrentExecution
public class ErpCghtJob extends QuartzJobBean {
	
	private final static Logger logger = LogManager.getLogger(ErpCghtJob.class);
	
	@Autowired
	private CghtDao cghtDao;
	@Autowired
	private CghtService cghtService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("job run, des:{}, NextFireTime:{}", context.getJobDetail().getDescription(), context.getTrigger().getNextFireTime());
		
		final Object insertClientObj = CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_CGHT.getName());
		if (insertClientObj == null) {
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", WSInterface.ERP_CGHT.getName());
			return;
		}
		
		QuartzManager.updateCronExpression(context, 
				(String) CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_CGHT.getName() + Constants.CRON));
		
		final CghtWSInterface insertClient = (CghtWSInterface)insertClientObj;
		
		cghtDao.pullCght();	// 从业务表构造数据
		
		final List<CghtServiceBean> cghtServiceBeans = cghtService.getPushErpCghts();
		for (CghtServiceBean cghtServiceBean : cghtServiceBeans) {
			try {
				insertClient.siSEGPPMSCAPOCRTREQAOUT(cghtServiceBean);	// 推送数据
			} catch (Exception e) {
				cghtServiceBean.getIsheader().setStatus(Constants.PUSH_FAILED);
				throw new ClientException("采购合同推送出错，合同编码：{}" + cghtServiceBean.getIsheader().getHtbm(), e);
			}
			
			cghtServiceBean.getIsheader().setStatus(Constants.PUSH_SUCCESS);
			cghtDao.updateStatus(cghtServiceBean.getIsheader());
			
			logger.info("ERP合同接口，推送成功，合同编码：{}", cghtServiceBean.getIsheader().getHtbm());
		}
	}

}
