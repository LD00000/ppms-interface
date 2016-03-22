package com.sunway.ws.module.erp.business.cght.dao;

import java.util.List;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.cght.bean.CghtItemBean;

@MyBatisDao
public interface CghtItemDao extends BaseDao<CghtItemBean> {
	
	/**
	 * 根据主表id，查询采购合同明细接口表数据
	 * 
	 * @param headId
	 * @return
	 */
	public List<CghtItemBean> queryForListByHeadId(Long headId);
	
	/**
	 * 根据合同编码获得推送 ERP 的合同明细
	 * 
	 * @param htbm 合同编码
	 * @return
	 */
	public List<CghtItemBean> queryPushErpCghtItems(String htbm);
	
}
