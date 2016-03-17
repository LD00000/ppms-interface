package com.sunway.ws.module.erp.common.consumer;

import java.util.HashMap;
import java.util.Map;

import com.sunway.ws.core.Constants;
import com.sunway.ws.core.cache.CacheManager;
import com.sunway.ws.core.consumer.WSDefaultConsumer;
import com.sunway.ws.core.consumer.MessageExtInner;
import com.sunway.ws.core.consumer.MessageListener;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.DataStatus;
import com.sunway.ws.module.erp.business.cght.CghtWSInterface;
import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;

public class ErpConsumerFactory {
	
	private final static Map<WSInterface, WSDefaultConsumer> consumers = new HashMap<WSInterface, WSDefaultConsumer>();
	
	public static WSDefaultConsumer getConsumer(WSInterface wsInterface) {
		if (consumers.get(wsInterface) == null) {
			synchronized (ErpConsumerFactory.class) {
				if (consumers.get(wsInterface) == null) {
					final WSDefaultConsumer consumer = new WSDefaultConsumer(wsInterface);
					
					switch (wsInterface) {
					case ERP_CGHT:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								final CghtWSInterface client = 
										(CghtWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getErpInterface().getName());
								client.siSEGPPMSCAPOCRTREQAOUT((CghtServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_KJXY:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_CKD:
			
						break;
					case ERP_RKD:
			
						break;
					case ERP_LCB:
			
						break;
					default:
					}
					
					consumers.put(wsInterface, consumer);
				}
			}
		}
		return consumers.get(wsInterface);
	}

}
