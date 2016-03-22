package com.sunway.ws.module.erp.business.cght.dao;

import java.util.List;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.cght.bean.CghtPayBean;

@MyBatisDao
public interface CghtPayDao extends BaseDao<CghtPayBean> {
	
	/**
	 * 根据主表id，查询采购合同付款接口表数据
	 * 
	 * @param headId
	 * @return
	 */
	public List<CghtPayBean> queryForListByHeadId(Long headId);
	
	/**
	 * 根据合同编码获得推送 ERP 的合同付款计划
	 * 
	 * @param htbm
	 * @return
	 */
	public List<CghtPayBean> queryPushErpCghtPays(String htbm);
	
}
