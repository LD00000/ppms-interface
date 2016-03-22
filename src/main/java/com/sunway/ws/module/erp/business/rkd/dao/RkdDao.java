package com.sunway.ws.module.erp.business.rkd.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.SelectSqlProvider;
import com.sunway.ws.module.erp.business.rkd.bean.RkdBean;

@MyBatisDao
public interface RkdDao extends BaseDao<RkdBean> {
	
	public void pullRkd();
	
	public int updateStatus(RkdBean rkd);
	
	/**
	 * 查询多条数据
	 * 
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SelectSqlProvider.class, method = "querySingleTable")
	public List<RkdBean> queryForList(RkdBean entity);
	
	/**
	 * 根据制单编号获得推送 ERP 的入库单
	 * 
	 * @param zdbh
	 * @return
	 */
	public RkdBean queryPushErpRkd(String zdbh);

}
