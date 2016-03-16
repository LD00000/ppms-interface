package com.sunway.ws.module.erp.common.quartz;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.bean.InterfaceDataStatusBean;
import com.sunway.ws.module.common.dao.InterfaceDataStatusDao;
import com.sunway.ws.module.erp.business.cght.service.CghtService;
import com.sunway.ws.module.erp.common.consumer.ErpConsumerFactory;

@DisallowConcurrentExecution
public class ErpWSJob extends QuartzJobBean {
	
	private final static Logger logger = LogManager.getLogger(ErpWSJob.class);
	
	@Autowired
	private InterfaceDataStatusDao interfaceDataStatusDao;
	@Autowired
	private CghtService cghtService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("job run, des:{}, NextFireTime:{}", context.getJobDetail().getDescription(), context.getTrigger().getNextFireTime());
		
		final List<InterfaceDataStatusBean> interfaceDataStatusBeans = interfaceDataStatusDao.queryRetryData();
		
		for (InterfaceDataStatusBean interfaceDataStatusBean : interfaceDataStatusBeans) {
			ErpConsumerFactory.getConsumer(WSInterface.ERP_CGHT)
							  .prepareData(cghtService.getPushErpCght(interfaceDataStatusBean.getbPk()), interfaceDataStatusBean.getbPk())
							  .retry(interfaceDataStatusBean)
							  .run();
		}
	}

}
