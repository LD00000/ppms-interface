package com.sunway.ws.module.erp.business;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.ws.core.Constants;
import com.sunway.ws.core.cache.CacheManager;
import com.sunway.ws.core.consumer.DataHandler;
import com.sunway.ws.core.consumer.MessageExtInner;
import com.sunway.ws.core.consumer.MessageListener;
import com.sunway.ws.core.consumer.WSDefaultConsumer;
import com.sunway.ws.core.cxf.client.JaxwsClient;
import com.sunway.ws.core.general.GeneralQuery;
import com.sunway.ws.core.utils.SpringUtils;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.DataStatus;
import com.sunway.ws.module.common.bean.InterfaceConfigBean;
import com.sunway.ws.module.common.bean.InterfaceDataStatusBean;
import com.sunway.ws.module.common.dao.InterfaceDataStatusDao;
import com.sunway.ws.module.erp.business.cght.CghtWSInterface;
import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;
import com.sunway.ws.module.erp.business.cght.service.CghtService;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-context.xml"})
@Rollback(true)
@ActiveProfiles("test")
public class RetryTest {
	
	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	@Autowired
	private InterfaceDataStatusDao interfaceDataStatusDao;
	
	@Test
	public void reTest() {
		final List<InterfaceDataStatusBean> interfaceDataStatusBeans = interfaceDataStatusDao.queryRetryData();
		
		System.out.println(interfaceDataStatusBeans.size());
		
		int i =0;
		for (InterfaceDataStatusBean interfaceDataStatusBean : interfaceDataStatusBeans) {
			final WSInterface wsInterface = WSInterface.valueOf(interfaceDataStatusBean.getInterfaceName());
			
			System.out.println(i++ + "    " + wsInterface);
			
			if (wsInterface != WSInterface.ERP_CGHT)
				continue;
			
			System.out.println(interfaceDataStatusBean.getbPk());
			System.out.println(interfaceDataStatusBean.getData());
			System.out.println(gson.fromJson(interfaceDataStatusBean.getData(), wsInterface.getServiceBeanClazz()));
			
//			ErpConsumerFactory.getConsumer(wsInterface)
//							  .retry(interfaceDataStatusBean, wsInterface.getServiceBeanClazz())
//							  .run();
			
			WSDefaultConsumer consumer = new WSDefaultConsumer(WSInterface.ERP_CGHT);
			
			consumer.handleMessage(new DataHandler() {
				
				@Override
				public MessageExtInner handleMessage(MessageExtInner message) {
					final CghtService cghtService = SpringUtils.getBean(CghtService.class);
					final CghtServiceBean cghtServiceBean = cghtService.getPushErpCght(message.getPk());
					
					if (cghtServiceBean != null) {
						cghtServiceBean.setIsmsghead(new MsgHead());
						
						message.setData(cghtServiceBean);
						message.setGuid(cghtServiceBean.getIsmsghead().getGuid());
					}
					return message;
				}
			});
			
			consumer.registerListener(new MessageListener() {
				
				@Override
				public DataStatus consumeMessage(MessageExtInner message) {
					 CghtWSInterface client = 
							(CghtWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getWsInterface().getName());
					
					List<InterfaceConfigBean> configs = GeneralQuery.getAllInterfaceConfig();
					
					for (InterfaceConfigBean config : configs) {
						if (!Constants.NO_STR.equals(config.getEnabled()) && config.getName().equals("ERP_CGHT")) {
							client = (CghtWSInterface) 
									(new JaxwsClient(config, WSInterface.valueOf(config.getName()).getWSInterfaceClazz()).getClientByJaxWsProxyFactory());
						}
					}
					
					if (client == null) 
						return DataStatus.WARN_NO_CLIENT;
					
					client.siSEGPPMSCAPOCRTREQAOUT((CghtServiceBean) message.getData());
					
					return DataStatus.SUCCESS;
				}
			});
			
			consumer.retry(interfaceDataStatusBean, wsInterface.getServiceBeanClazz());
//			consumer.setPk("201603000054");
			
			consumer.run();
		}
		
		
		
	}

}
