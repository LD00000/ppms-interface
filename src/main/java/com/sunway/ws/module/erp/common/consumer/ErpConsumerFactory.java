package com.sunway.ws.module.erp.common.consumer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sunway.ws.core.Constants;
import com.sunway.ws.core.cache.CacheManager;
import com.sunway.ws.core.consumer.WSDefaultConsumer;
import com.sunway.ws.core.utils.SpringUtils;
import com.sunway.ws.core.consumer.DataHandler;
import com.sunway.ws.core.consumer.MessageExtInner;
import com.sunway.ws.core.consumer.MessageListener;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.DataStatus;
import com.sunway.ws.module.erp.business.cght.CghtWSInterface;
import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;
import com.sunway.ws.module.erp.business.cght.service.CghtService;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhFdServiceBean;
import com.sunway.ws.module.erp.business.ckd.CkdWSInterface;
import com.sunway.ws.module.erp.business.ckd.bean.CkdServiceBean;
import com.sunway.ws.module.erp.business.ckd.service.CkdService;
import com.sunway.ws.module.erp.business.feedback.CgjhFeedbackWSInterface;
import com.sunway.ws.module.erp.business.kjxy.KjxyWSInterface;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyServiceBean;
import com.sunway.ws.module.erp.business.kjxy.service.KjxyService;
import com.sunway.ws.module.erp.business.lcb.LcbWSInterface;
import com.sunway.ws.module.erp.business.lcb.bean.LcbServiceBean;
import com.sunway.ws.module.erp.business.lcb.service.LcbService;
import com.sunway.ws.module.erp.business.rkd.RkdWSInterface;
import com.sunway.ws.module.erp.business.rkd.bean.RkdServiceBean;
import com.sunway.ws.module.erp.business.rkd.service.RkdService;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@Component
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
								
								final CgjhFdServiceBean cgjhFdServiceBean = (CgjhFdServiceBean) message.getData();
								cgjhFdServiceBean.setEsmsghead(new MsgHead());
								
								client.siSEGPPMSCAPRRESPOUT(cgjhFdServiceBean);
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_CGHT:
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
								
								if (client == null) 
									return DataStatus.WARN_NO_CLIENT;
								
								client.siSEGPPMSCAPOCRTREQAOUT((CghtServiceBean) message.getData());
								
								return DataStatus.SUCCESS;
							}
						});
						break;
					case ERP_KJXY:
						consumer.handleMessage(new DataHandler() {
							
							@Override
							public MessageExtInner handleMessage(MessageExtInner message) {
								final KjxyService kjxyService = SpringUtils.getBean(KjxyService.class);
								final KjxyServiceBean kjxyServiceBean = kjxyService.getPushErpKjxy(message.getPk());
								
								if (kjxyServiceBean != null) {
									kjxyServiceBean.setIsmsghead(new MsgHead());
									message.setData(kjxyServiceBean);
									message.setGuid(kjxyServiceBean.getIsmsghead().getGuid());
								}
								
								return message;
							}
						});

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
						consumer.handleMessage(new DataHandler() {
							
							@Override
							public MessageExtInner handleMessage(MessageExtInner message) {
								final CkdService ckdService = SpringUtils.getBean(CkdService.class);
								final CkdServiceBean ckdServiceBean = ckdService.getPushErpCkd(message.getPk());
								
								if (ckdServiceBean != null) {
									ckdServiceBean.setIsmsghead(new MsgHead());
									message.setData(ckdServiceBean);
									message.setGuid(ckdServiceBean.getIsmsghead().getGuid());
								}
								
								return message;
							}
						});

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
						consumer.handleMessage(new DataHandler() {
							
							@Override
							public MessageExtInner handleMessage(MessageExtInner message) {
								final RkdService rkdService = SpringUtils.getBean(RkdService.class);
								final RkdServiceBean rkdServiceBean = rkdService.getPushErpRkd(message.getPk());
								
								if (rkdServiceBean != null) {
									rkdServiceBean.setIsmsghead(new MsgHead());
									message.setData(rkdServiceBean);
									message.setGuid(rkdServiceBean.getIsmsghead().getGuid());
								}
								return message;
							}
						});

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
						consumer.handleMessage(new DataHandler() {
							
							@Override
							public MessageExtInner handleMessage(MessageExtInner message) {
								final LcbService lcbService = SpringUtils.getBean(LcbService.class);
								final LcbServiceBean lcbServiceBean = lcbService.getPushErpLcb(message.getPk());
								
								if (lcbServiceBean != null) {
									lcbServiceBean.setIsmsghead(new MsgHead());
									message.setData(lcbServiceBean);
									message.setGuid(lcbServiceBean.getIsmsghead().getGuid());
								}
								
								return message;
							}
						});

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
