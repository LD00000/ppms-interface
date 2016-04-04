package com.sunway.ws.module.erp.business.cgjh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunway.ws.core.general.GeneralQuery;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhServiceBean;
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
	public void insertCgjh(CgjhServiceBean cgjhServiceBean) {
		Long headId = GeneralQuery.getDbSeq("SEQ_INTERFACE");
		
		cgjhServiceBean.getCgjh().setId(headId);
		cgjhDao.insert(cgjhServiceBean.getCgjh());
		
		this.addHeadId(cgjhServiceBean.getCgjhItems(), headId);
		this.addHeadId(cgjhServiceBean.getCgjhItemGyss(), headId);
		this.addHeadId(cgjhServiceBean.getCgjhItemKjxys(), headId);
		this.addHeadId(cgjhServiceBean.getCgjhItemLcbs(), headId);
		this.addHeadId(cgjhServiceBean.getCgjhItemZfcls(), headId);
		
		cgjhItemDao.batchInsert(cgjhServiceBean.getCgjhItems());
		cgjhItemGysDao.batchInsert(cgjhServiceBean.getCgjhItemGyss());
		cgjhItemKjxyDao.batchInsert(cgjhServiceBean.getCgjhItemKjxys());
		cgjhItemLcbDao.batchInsert(cgjhServiceBean.getCgjhItemLcbs());
		cgjhItemZfclDao.batchInsert(cgjhServiceBean.getCgjhItemZfcls());
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
