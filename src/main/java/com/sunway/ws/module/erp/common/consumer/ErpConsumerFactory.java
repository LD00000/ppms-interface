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
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhFdServiceBean;
import com.sunway.ws.module.erp.business.ckd.CkdWSInterface;
import com.sunway.ws.module.erp.business.ckd.bean.CkdServiceBean;
import com.sunway.ws.module.erp.business.feedback.CgjhFeedbackWSInterface;
import com.sunway.ws.module.erp.business.kjxy.KjxyWSInterface;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyServiceBean;
import com.sunway.ws.module.erp.business.lcb.LcbWSInterface;
import com.sunway.ws.module.erp.business.lcb.bean.LcbServiceBean;
import com.sunway.ws.module.erp.business.rkd.RkdWSInterface;
import com.sunway.ws.module.erp.business.rkd.bean.RkdServiceBean;

public class ErpConsumerFactory {
	
	private final static Map<WSInterface, WSDefaultConsumer> consumers = new HashMap<WSInterface, WSDefaultConsumer>();
	
	public static WSDefaultConsumer getConsumer(WSInterface wsInterface) {
		if (consumers.get(wsInterface) == null) {
			synchronized (consumers) {
				if (consumers.get(wsInterface) == null) {
					final WSDefaultConsumer consumer = new WSDefaultConsumer(wsInterface);
					
					switch (wsInterface) {
					case ERP_CGJH_FEEDBACK:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								final CgjhFeedbackWSInterface client = 
										(CgjhFeedbackWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getWsInterface().getName());
								
								if (client == null) 
									return DataStatus.WARN_NO_CLIENT;
								
								client.siSEGPPMSCAPRRESPOUT((CgjhFdServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_CGHT:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								final CghtWSInterface client = 
										(CghtWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getWsInterface().getName());
								
								if (client == null) 
									return DataStatus.WARN_NO_CLIENT;
								
								client.siSEGPPMSCAPOCRTREQAOUT((CghtServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_KJXY:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								final KjxyWSInterface client = 
										(KjxyWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getWsInterface().getName());
								
								if (client == null) 
									return DataStatus.WARN_NO_CLIENT;
								
								client.siSEGPPMSCAKJXYREQAOUT((KjxyServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_CKD:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								final CkdWSInterface client = 
										(CkdWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getWsInterface().getName());
								
								if (client == null) 
									return DataStatus.WARN_NO_CLIENT;
								
								client.siSEGPPMSCAGIREQOUT((CkdServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_RKD:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								final RkdWSInterface client = 
										(RkdWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getWsInterface().getName());
								
								if (client == null) 
									return DataStatus.WARN_NO_CLIENT;
								
								client.siSEGPPMSCAGRREQAOUT((RkdServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_LCB:
						consumer.registerListener(new MessageListener() {
							
							@Override
							public DataStatus consumeMessage(MessageExtInner message) {
								final LcbWSInterface client = 
										(LcbWSInterface) CacheManager.getObject(Constants.CACHE_NAME, message.getWsInterface().getName());
								
								if (client == null) 
									return DataStatus.WARN_NO_CLIENT;
								
								client.siSEGPPMSCALCBREQAOUT((LcbServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
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
