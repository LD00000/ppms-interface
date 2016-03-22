package com.sunway.ws.module.erp.business.rkd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.ws.module.erp.business.rkd.bean.RkdBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdServiceBean;
import com.sunway.ws.module.erp.business.rkd.dao.RkdDao;
import com.sunway.ws.module.erp.business.rkd.dao.RkdItemDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@Service
public class RkdService {
	
	@Autowired
	private RkdDao rkdDao;
	@Autowired
	private RkdItemDao rkdItemDao;
	
	/**
	 * 根据制单编号获得推送 ERP 的入库单
	 * 
	 * @param zdbh 制单编号
	 * @return
	 */
	public RkdServiceBean getPushErpRkd(final String zdbh) {
		final RkdBean rkd = rkdDao.queryPushErpRkd(zdbh);
		if (rkd == null)
			return null;
		
		final RkdServiceBean rkdServiceBean = new RkdServiceBean();
		
		rkdServiceBean.setIsmsghead(new MsgHead());
		rkdServiceBean.setIsheader(rkd);
		rkdServiceBean.setItitems(rkdItemDao.queryPushErpRkdItems(zdbh));
		
		return rkdServiceBean;
	}

}
