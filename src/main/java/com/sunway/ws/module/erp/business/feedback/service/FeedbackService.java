package com.sunway.ws.module.erp.business.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.ws.module.erp.business.cght.bean.CghtFdServerBean;
import com.sunway.ws.module.erp.business.ckd.bean.CkdFdServerBean;
import com.sunway.ws.module.erp.business.feedback.bean.ErpLog;
import com.sunway.ws.module.erp.business.feedback.dao.ErpLogDao;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyFdServiceBean;
import com.sunway.ws.module.erp.business.lcb.bean.LcbFdServiceBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdFdServerBean;

/**
 * erp 反馈接口 service
 */
@Service
public class FeedbackService {
	
	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	@Autowired
	private ErpLogDao erpLogDao;
	
	/**
	 * 插入采购合同反馈信息
	 * 
	 * @param cghtFd
	 */
	public void insertCghtFeedback(CghtFdServerBean cghtFd) {
		final ErpLog erpLog = new ErpLog();
		erpLog.setInterfaceName("CghtFeedback");
		erpLog.setLog(gson.toJson(cghtFd));
		if (cghtFd != null && cghtFd.getMsgHead() != null)
			erpLog.setGuid(cghtFd.getMsgHead().getGuid());
		if (cghtFd.getCghtLogs() != null && cghtFd.getCghtLogs().size() != 0) {
			erpLog.setStatus("S".equals(cghtFd.getCghtLogs().get(0).getType()) ? "0" : "1");
		}
		
		
		erpLogDao.insert(erpLog);
	}
	
	/**
	 * 插入入库单反馈信息
	 * 
	 * @param rkdFd
	 */
	public void insertRkdFeedback(RkdFdServerBean rkdFd) {
		final ErpLog erpLog = new ErpLog();
		erpLog.setInterfaceName("RkdFeedback");
		erpLog.setLog(gson.toJson(rkdFd));
		if (rkdFd != null && rkdFd.getMsgHead() != null)
			erpLog.setGuid(rkdFd.getMsgHead().getGuid());
		if (rkdFd.getRkdLogs() != null && rkdFd.getRkdLogs().size() != 0) {
			erpLog.setStatus("S".equals(rkdFd.getRkdLogs().get(0).getType()) ? "0" : "1");
		}
		
		erpLogDao.insert(erpLog);
	}
	
	/**
	 * 插入出库单反馈信息
	 * 
	 * @param ckdFd
	 */
	public void insertCkdFeedback(CkdFdServerBean ckdFd) {
		final ErpLog erpLog = new ErpLog();
		erpLog.setInterfaceName("CkdFeedback");
		erpLog.setLog(gson.toJson(ckdFd));
		if (ckdFd != null && ckdFd.getMsgHead() != null)
			erpLog.setGuid(ckdFd.getMsgHead().getGuid());
		if (ckdFd.getCkdLogs() != null && ckdFd.getCkdLogs().size() != 0) {
			erpLog.setStatus("S".equals(ckdFd.getCkdLogs().get(0).getType()) ? "0" : "1");
		}
		
		erpLogDao.insert(erpLog);
	}
	
	/**
	 * 插入里程碑反馈信息
	 * 
	 * @param lcbFd
	 */
	public void insertLcbFeedback(LcbFdServiceBean lcbFd) {
		final ErpLog erpLog = new ErpLog();
		erpLog.setInterfaceName("LcbFeedback");
		erpLog.setLog(gson.toJson(lcbFd));
		if (lcbFd != null && lcbFd.getMsgHead() != null)
			erpLog.setGuid(lcbFd.getMsgHead().getGuid());
		if (lcbFd.getLcbLogs() != null && lcbFd.getLcbLogs().size() != 0) {
			erpLog.setStatus("S".equals(lcbFd.getLcbLogs().get(0).getType()) ? "0" : "1");
		}
		
		erpLogDao.insert(erpLog);
	}
	
	/**
	 * 插入框架协议反馈信息
	 * 
	 * @param kjxyFd
	 */
	public void insertKjxyFeedback(KjxyFdServiceBean kjxyFd) {
		final ErpLog erpLog = new ErpLog();
		erpLog.setInterfaceName("KjxyFeedback");
		erpLog.setLog(gson.toJson(kjxyFd));
		if (kjxyFd != null && kjxyFd.getMsgHead() != null)
			erpLog.setGuid(kjxyFd.getMsgHead().getGuid());
		if (kjxyFd.getKjxyLoghs() != null && kjxyFd.getKjxyLoghs().size() != 0) {
			erpLog.setStatus(kjxyFd.getKjxyLoghs().get(0).getFlag());
		}
		
		erpLogDao.insert(erpLog);
	}
	
}
