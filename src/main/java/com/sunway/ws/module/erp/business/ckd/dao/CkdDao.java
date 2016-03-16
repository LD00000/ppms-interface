package com.sunway.ws.module.erp.business.ckd.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.SelectSqlProvider;
import com.sunway.ws.module.erp.business.ckd.bean.CkdBean;

@MyBatisDao
public interface CkdDao extends BaseDao<CkdBean> {
	
	public void pullCkd();
	
	public int updateStatus(CkdBean ckd);
	
	/**
	 * 查询多条数据
	 * 
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SelectSqlProvider.class, method = "querySingleTable")
	public List<CkdBean> queryForList(CkdBean entity);

}
