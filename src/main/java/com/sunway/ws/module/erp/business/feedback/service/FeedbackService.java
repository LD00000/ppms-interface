package com.sunway.ws.module.erp.business.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.ws.core.general.GeneralQuery;
import com.sunway.ws.module.erp.business.cght.bean.CghtFdServerBean;
import com.sunway.ws.module.erp.business.ckd.bean.CkdFdServerBean;
import com.sunway.ws.module.erp.business.feedback.bean.ErpLog;
import com.sunway.ws.module.erp.business.feedback.dao.ErpLogDao;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyFdServiceBean;
import com.sunway.ws.module.erp.business.lcb.bean.LcbFdServiceBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdFdServerBean;

/**
 * erp 反馈接口 service
 * 
 * @author lidong
 */
@Service
public class FeedbackService {
	
	private static final String SEQNAME = "SEQ_INTERFACE_LOG";	// 序列名
	
	private final Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	@Autowired
	private ErpLogDao erpLogDao;
	
	/**
	 * 插入采购合同反馈信息
	 * 
	 * @param cghtFd
	 */
	public void insertCghtFeedback(CghtFdServerBean cghtFd) {
		final ErpLog erpLog = new ErpLog();
		erpLog.setId(GeneralQuery.getDbSeq(SEQNAME));
		erpLog.setInterfaceName("CghtFeedback");
		erpLog.setLog(gson.toJson(cghtFd));
		if (cghtFd.getCghtLogs() != null) {
			erpLog.setMsgid(cghtFd.getCghtLogs().get(0).getMsgid());
		} else {
			erpLog.setMsgid("null");
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
		erpLog.setId(GeneralQuery.getDbSeq(SEQNAME));
		erpLog.setInterfaceName("RkdFeedback");
		erpLog.setLog(gson.toJson(rkdFd));
		if (rkdFd.getRkdLogs() != null) {
			erpLog.setMsgid(rkdFd.getRkdLogs().get(0).getMsgid());
		} else {
			erpLog.setMsgid("null");
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
		erpLog.setId(GeneralQuery.getDbSeq(SEQNAME));
		erpLog.setInterfaceName("CkdFeedback");
		erpLog.setLog(gson.toJson(ckdFd));
		if (ckdFd.getCkdLogs() != null) {
			erpLog.setMsgid(ckdFd.getCkdLogs().get(0).getMsgid());
		} else {
			erpLog.setMsgid("null");
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
		erpLog.setId(GeneralQuery.getDbSeq(SEQNAME));
		erpLog.setInterfaceName("LcbFeedback");
		erpLog.setLog(gson.toJson(lcbFd));
		if (lcbFd.getMsgHead() != null) {
			erpLog.setMsgid(lcbFd.getMsgHead().getGuid());
		} else {
			erpLog.setMsgid("null");
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
		erpLog.setId(GeneralQuery.getDbSeq(SEQNAME));
		erpLog.setInterfaceName("KjxyFeedback");
		erpLog.setLog(gson.toJson(kjxyFd));
		if (kjxyFd.getKjxyLoghs() != null) {
			erpLog.setMsgid(kjxyFd.getKjxyLoghs().get(0).getMsgid());
		} else {
			erpLog.setMsgid("null");
		}
		
		erpLogDao.insert(erpLog);
	}
	
}
