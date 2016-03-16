package com.sunway.ws.module.erp.business.lcb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunway.ws.module.erp.business.lcb.bean.LcbBean;
import com.sunway.ws.module.erp.business.lcb.bean.LcbServiceBean;
import com.sunway.ws.module.erp.business.lcb.dao.LcbDao;
import com.sunway.ws.module.erp.business.lcb.dao.LcbItemDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@Service
public class LcbService {
	
	@Autowired
	private LcbDao lcbDao;
	@Autowired
	private LcbItemDao lcbItemDao;
	
	@Transactional
	public List<LcbServiceBean> getPushErpLcb() {
		List<LcbServiceBean> lcbServiceBeans = new ArrayList<LcbServiceBean>();
		
		LcbBean lcbQ = new LcbBean();
		lcbQ.setStatus("1");
		List<LcbBean> lcbs = lcbDao.queryForList(lcbQ);
		for (LcbBean lcb : lcbs) {
			LcbServiceBean lcbService = new LcbServiceBean();
			lcbService.setIsmsghead(new MsgHead());
			
			lcbService.setIsdochead(lcb);
			lcbService.setItdocitem(lcbItemDao.queryForListByHeadId(lcb.getId())); 
			
			lcbServiceBeans.add(lcbService);
		}
		
		return lcbServiceBeans;
	}

}
