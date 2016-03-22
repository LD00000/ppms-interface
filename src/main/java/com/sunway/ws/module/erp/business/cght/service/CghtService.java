package com.sunway.ws.module.erp.business.cght.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.ws.module.erp.business.cght.bean.CghtBean;
import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;
import com.sunway.ws.module.erp.business.cght.dao.CghtDao;
import com.sunway.ws.module.erp.business.cght.dao.CghtItemDao;
import com.sunway.ws.module.erp.business.cght.dao.CghtPayDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

/**
 * 采购合同 service
 */
@Service
public class CghtService {
	
	@Autowired
	private CghtDao cghtDao;
	@Autowired
	private CghtItemDao cghtItemDao;
	@Autowired
	private CghtPayDao cghtPayDao;
	
	/**
	 * 根据合同编码获得推送 ERP 的采购合同
	 * 
	 * @param htbm 合同编码
	 * @return
	 */
	public CghtServiceBean getPushErpCght(final String htbm) {
		final CghtBean cght = cghtDao.queryPushErpCght(htbm);
		if (cght == null)
			return null;
		
		final CghtServiceBean cghtServiceBean = new CghtServiceBean();
		
		cghtServiceBean.setIsmsghead(new MsgHead());
		cghtServiceBean.setIsheader(cght);
		cghtServiceBean.setItitems(cghtItemDao.queryPushErpCghtItems(htbm));
		cghtServiceBean.setItpay(cghtPayDao.queryPushErpCghtPays(htbm));
		
		return cghtServiceBean;
	}
	
}
