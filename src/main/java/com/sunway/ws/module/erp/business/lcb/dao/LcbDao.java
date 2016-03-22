package com.sunway.ws.module.erp.business.lcb.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.SelectSqlProvider;
import com.sunway.ws.module.erp.business.lcb.bean.LcbBean;

@MyBatisDao
public interface LcbDao extends BaseDao<LcbBean> {
	
	public void pullLcb();
	
	public int updateStatus(LcbBean lcb);
	
	/**
	 * 查询多条数据
	 * 
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SelectSqlProvider.class, method = "querySingleTable")
	public List<LcbBean> queryForList(LcbBean entity);
	
	/**
	 * 根据请购单编码获得推送 ERP 的请购单里程碑
	 * 
	 * @param qgdbm
	 * @return
	 */
	public LcbBean queryPushErpLcb(String qgdbm);

}
