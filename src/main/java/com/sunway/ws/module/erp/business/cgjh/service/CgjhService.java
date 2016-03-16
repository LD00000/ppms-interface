package com.sunway.ws.module.erp.business.cgjh.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunway.ws.core.general.GeneralQuery;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhMessage;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhServerBean;
import com.sunway.ws.module.erp.business.cgjh.dao.CgjhDao;
import com.sunway.ws.module.erp.business.cgjh.dao.CgjhItemDao;
import com.sunway.ws.module.erp.business.cgjh.dao.CgjhItemGysDao;
import com.sunway.ws.module.erp.business.cgjh.dao.CgjhItemKjxyDao;
import com.sunway.ws.module.erp.business.cgjh.dao.CgjhItemLcbDao;
import com.sunway.ws.module.erp.business.cgjh.dao.CgjhItemZfclDao;

@Service
public class CgjhService {
	
	@Autowired
	private CgjhDao cgjhDao;
	@Autowired
	private CgjhItemDao cgjhItemDao;
	@Autowired
	private CgjhItemGysDao cgjhItemGysDao;
	@Autowired
	private CgjhItemKjxyDao cgjhItemKjxyDao;
	@Autowired
	private CgjhItemLcbDao cgjhItemLcbDao;
	@Autowired
	private CgjhItemZfclDao cgjhItemZfclDao;
		
	/**
	 * 插入 ERP 采购计划
	 * 
	 * @param msg
	 */
	@Transactional
	public List<CgjhMessage> insertCgjh(CgjhServerBean cgjhServerBean) {
		Long headId = GeneralQuery.getDbSeq("SEQ_INTERFACE");
		
		cgjhServerBean.getCgjh().setId(headId);
		cgjhDao.insert(cgjhServerBean.getCgjh());
		
		this.addHeadId(cgjhServerBean.getCgjhItems(), headId);
		this.addHeadId(cgjhServerBean.getCgjhItemGyss(), headId);
		this.addHeadId(cgjhServerBean.getCgjhItemKjxys(), headId);
		this.addHeadId(cgjhServerBean.getCgjhItemLcbs(), headId);
		this.addHeadId(cgjhServerBean.getCgjhItemZfcls(), headId);
		
		cgjhItemDao.batchInsert(cgjhServerBean.getCgjhItems());
		cgjhItemGysDao.batchInsert(cgjhServerBean.getCgjhItemGyss());
		cgjhItemKjxyDao.batchInsert(cgjhServerBean.getCgjhItemKjxys());
		cgjhItemLcbDao.batchInsert(cgjhServerBean.getCgjhItemLcbs());
		cgjhItemZfclDao.batchInsert(cgjhServerBean.getCgjhItemZfcls());
		
		CgjhMessage cgjhMessage = new CgjhMessage();
		cgjhMessage.setType("S");
		cgjhMessage.setMessage("接收成功");
		
		List<CgjhMessage> messages = new ArrayList<CgjhMessage>();
		messages.add(cgjhMessage);
		
		return messages;
	}
	
	/**
	 * 为列表中对象的 headid 赋值
	 * 
	 * @param list
	 * @param headId
	 */
	private <T> void addHeadId(List<T> list, Long headId) {
		if (list == null) {
			return;
		}
		
		try {
			for (T obj : list) {
				obj.getClass().getMethod("setHeadId", Long.class).invoke(obj, headId);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
