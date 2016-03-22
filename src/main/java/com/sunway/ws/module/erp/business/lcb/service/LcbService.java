package com.sunway.ws.module.erp.business.lcb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	/**
	 * 根据请购单编码获得推送 ERP 的里程碑
	 * 
	 * @param qgdbm 请购单编码
	 * @return
	 */
	public LcbServiceBean getPushErpLcb(final String qgdbm) {
		final LcbBean lcb = lcbDao.queryPushErpLcb(qgdbm);
		if (lcb == null)
			return null;
		
		final LcbServiceBean lcbServiceBean = new LcbServiceBean();
		
		lcbServiceBean.setIsmsghead(new MsgHead());
		lcbServiceBean.setIsdochead(lcb);
		lcbServiceBean.setItdocitem(lcbItemDao.queryPushErpLcbItems(qgdbm));
		
		return lcbServiceBean;
	}

}
