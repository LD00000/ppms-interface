package com.sunway.ws.module.erp.business.rkd.dao;

import java.util.List;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.rkd.bean.RkdItemBean;

@MyBatisDao
public interface RkdItemDao extends BaseDao<RkdItemBean> {
	
	/**
	 * 根据入库单号，查询入库单明细接口表数据 
	 * 
	 * @param rkdh
	 * @return
	 */
	public List<RkdItemBean> queryForListByRkdh(String rkdh);
	
	public List<RkdItemBean> queryForListByHeadId(Long headId);
	
	/**
	 * 根据制单编号获得推送 ERP 的入库单明细
	 * 
	 * @param zdbh
	 * @return
	 */
	public List<RkdItemBean> queryPushErpRkdItems(String zdbh);

}
