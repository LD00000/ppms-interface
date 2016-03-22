package com.sunway.ws.module.erp.business.ckd.dao;

import java.util.List;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.ckd.bean.CkdItemBean;

@MyBatisDao
public interface CkdItemDao extends BaseDao<CkdItemBean> {
	
	public List<CkdItemBean> queryForListByCkdh(String ckdh);
	
	public List<CkdItemBean> queryForListByHeadId(Long headId);
	
	/**
	 * 根据制单编号获得推送 ERP 的出库单明细
	 * 
	 * @param zdbh
	 * @return
	 */
	public List<CkdItemBean> queryPushErpCkdItems(String zdbh);

}
