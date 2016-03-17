package com.sunway.ws.module.erp.common.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunway.ws.core.Constants;
import com.sunway.ws.core.cache.CacheManager;
import com.sunway.ws.core.exception.ServerException;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.erp.business.cght.bean.CghtFdServerBean;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhFdServerBean;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhMessage;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhServerBean;
import com.sunway.ws.module.erp.business.cgjh.service.CgjhService;
import com.sunway.ws.module.erp.business.ckd.bean.CkdFdServerBean;
import com.sunway.ws.module.erp.business.feedback.CgjhFeedbackWSInterface;
import com.sunway.ws.module.erp.business.feedback.service.FeedbackService;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyFdServiceBean;
import com.sunway.ws.module.erp.business.lcb.bean.LcbFdServiceBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdFdServerBean;
import com.sunway.ws.module.erp.common.Validators;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@WebService(serviceName = "erpServer", targetNamespace="http://services.common.erp.webservice.sunwayworld.com/")
@Component(value = "ErpServerImpl")
public class ErpServerImpl implements ErpServer {
	
	private final static Logger logger = LogManager.getLogger(ErpServerImpl.class);
	
	@Autowired
	private CgjhService cgjhService;
	@Autowired
	private FeedbackService feedbackService;

	@WebMethod
	@Override
	public void insertCgjh(CgjhServerBean cgjh) {
		logger.info("插入 ERP 采购计划...");
		
		Validators.checkCgjh(cgjh);
		
		List<CgjhMessage> messages = cgjhService.insertCgjh(cgjh);
		
		final Object clientObj = CacheManager.getObject(Constants.CACHE_NAME, WSInterface.ERP_CGJH_FEEDBACK.getName());
		if (clientObj == null) {
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", WSInterface.ERP_CGJH_FEEDBACK.getName());
			return ;
		}
		
		logger.info("发送 ERP 采购计划反馈...");
		CgjhFeedbackWSInterface client = (CgjhFeedbackWSInterface) clientObj;
		
		CgjhFdServerBean cgjhFd = new CgjhFdServerBean();
		cgjhFd.setEsmsghead(new MsgHead());
		cgjhFd.setEtmessage(messages);
		
		try {
			client.siSEGPPMSCAPRRESPOUT(cgjhFd);
		} catch (Exception e) {
			throw new ServerException("调用 erp_cgjh_feedback 失败...", e);
		}
	}

	@Override
	public void insertCghtFeedback(CghtFdServerBean cghtFd) {
		logger.info("插入ERP合同反馈...");
		feedbackService.insertCghtFeedback(cghtFd);
	}

	@Override
	public void insertRkdFeedback(RkdFdServerBean rkdFd) {
		logger.info("插入ERP入库单反馈...");
		feedbackService.insertRkdFeedback(rkdFd);
	}

	@Override
	public void insertCkdFeedback(CkdFdServerBean ckdFd) {
		logger.info("插入ERP出库单反馈...");
		feedbackService.insertCkdFeedback(ckdFd);
	}

	@Override
	public void insertLcbFeedback(LcbFdServiceBean lcbFd) {
		logger.info("插入ERP里程碑反馈...");
		feedbackService.insertLcbFeedback(lcbFd);
	}

	@Override
	public void insertKjxyFeedback(KjxyFdServiceBean kjxyFd) {
		logger.info("插入ERP框架协议反馈...");
		feedbackService.insertKjxyFeedback(kjxyFd);
	}

}
