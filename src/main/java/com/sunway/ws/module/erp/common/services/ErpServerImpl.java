package com.sunway.ws.module.erp.common.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.erp.business.cght.bean.CghtFdServerBean;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhFdServiceBean;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhMessage;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhServiceBean;
import com.sunway.ws.module.erp.business.cgjh.service.CgjhService;
import com.sunway.ws.module.erp.business.ckd.bean.CkdFdServerBean;
import com.sunway.ws.module.erp.business.feedback.service.FeedbackService;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyFdServiceBean;
import com.sunway.ws.module.erp.business.lcb.bean.LcbFdServiceBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdFdServerBean;
import com.sunway.ws.module.erp.common.consumer.ErpConsumerFactory;

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
	public void insertCgjh(CgjhServiceBean cgjh) {
		logger.info("插入 ERP 采购计划...");
		
		CgjhMessage cgjhMessage = new CgjhMessage();
		cgjhMessage.setNumber(cgjh.getCgjh().getZcgjh());
		cgjhMessage.setType("E");
		cgjhMessage.setMessage("接收失败");
		
		try {
			cgjhService.insertCgjh(cgjh);
			cgjhMessage.setType("S");
			cgjhMessage.setMessage("接收成功");
		} catch (Exception e) {
			logger.error(e);
			cgjhMessage.setMessage(e.getMessage());
		}
		
		CgjhFdServiceBean cgjhFd = new CgjhFdServiceBean();
		cgjhFd.setEsmsghead(cgjh.getMsgHead());
		List<CgjhMessage> messages = new ArrayList<CgjhMessage>();
		messages.add(cgjhMessage);
		cgjhFd.setEtmessage(messages);
		
		ErpConsumerFactory.getConsumer(WSInterface.ERP_CGJH_FEEDBACK)
						  .prepareData(cgjhFd, cgjh.getMsgHead().getGuid(), cgjh.getCgjh().getZcgjh())
						  .run();
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
