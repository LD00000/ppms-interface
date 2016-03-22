package com.sunway.ws.module.erp.business.lcb.dao;

import java.util.List;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.lcb.bean.LcbItemBean;

@MyBatisDao
public interface LcbItemDao extends BaseDao<LcbItemBean> {
	
	public List<LcbItemBean> queryForListByQgdbm(String qgdbm);
	
	public List<LcbItemBean> queryForListByHeadId(Long headId);
	
	/**
	 * 根据请购单编码获得推送 ERP 的请购单里程碑明细
	 * 
	 * @param qgdbm
	 * @return
	 */
	public List<LcbItemBean> queryPushErpLcbItems(String qgdbm);

}
