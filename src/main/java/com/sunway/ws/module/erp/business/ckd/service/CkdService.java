package com.sunway.ws.module.erp.business.ckd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.ws.module.erp.business.ckd.bean.CkdBean;
import com.sunway.ws.module.erp.business.ckd.bean.CkdServiceBean;
import com.sunway.ws.module.erp.business.ckd.dao.CkdDao;
import com.sunway.ws.module.erp.business.ckd.dao.CkdItemDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@Service
public class CkdService {
	
	@Autowired
	private CkdDao ckdDao;
	@Autowired
	private CkdItemDao ckdItemDao;
	
	/**
	 * 根据制单编号获得推送 ERP 的出库单
	 * 
	 * @param zdbh 制单编号
	 * @return
	 */
	public CkdServiceBean getPushErpCkd(final String zdbh) {
		final CkdBean ckd = ckdDao.queryPushErpCkd(zdbh);
		if (ckd == null)
			return null;
		
		final CkdServiceBean ckdServiceBean = new CkdServiceBean();
		ckdServiceBean.setIsmsghead(new MsgHead());
		ckdServiceBean.setIsheader(ckd);
		ckdServiceBean.setItitems(ckdItemDao.queryPushErpCkdItems(zdbh));
		
		return ckdServiceBean;
	}

}
