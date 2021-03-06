package com.sunway.ws.module.common.quartz;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.sunway.ws.core.quartz.QuartzManager;
import com.sunway.ws.core.utils.PropertiesLoader;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.bean.InterfaceDataStatusBean;
import com.sunway.ws.module.common.dao.InterfaceDataStatusDao;
import com.sunway.ws.module.erp.common.consumer.ErpConsumerFactory;

/**
 * 重发数据 job</br>
 * 每次运行会从配置文件读取cron参数，并更新
 */
@DisallowConcurrentExecution
public class WSRetryJob extends QuartzJobBean {
	
	private final static Logger logger = LogManager.getLogger(WSRetryJob.class);
	
	@Autowired
	private InterfaceDataStatusDao interfaceDataStatusDao;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("job run, des:{}, NextFireTime:{}", context.getJobDetail().getDescription(), context.getTrigger().getNextFireTime());
		
		QuartzManager.updateCronExpression(context, PropertiesLoader.getProperty("retry.cron"));
		
		try {
			final List<InterfaceDataStatusBean> interfaceDataStatusBeans = interfaceDataStatusDao.queryRetryData();
			
			logger.info("需重发数据条数：{}", interfaceDataStatusBeans.size());
			
			for (InterfaceDataStatusBean interfaceDataStatusBean : interfaceDataStatusBeans) {
				logger.info("重发数据...");
				final WSInterface wsInterface = WSInterface.valueOf(interfaceDataStatusBean.getInterfaceName());
				
				ErpConsumerFactory.getConsumer(wsInterface)
								  .retry(interfaceDataStatusBean, wsInterface.getServiceBeanClazz())
								  .run();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
