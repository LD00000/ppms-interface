package com.sunway.ws.module.erp.business.cght.dao;

import java.util.List;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.cght.bean.CghtQtfyBean;

@MyBatisDao
public interface CghtQtfyDao {
	
	/**
	 * 根据合同编码获得推送 ERP 的合同其他费用
	 * 
	 * @param htbm
	 * @return
	 */
	public List<CghtQtfyBean> queryPushErpCghtQtfys(String htbm);

}
