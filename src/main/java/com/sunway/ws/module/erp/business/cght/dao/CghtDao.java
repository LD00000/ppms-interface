package com.sunway.ws.module.erp.business.cght.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.SelectSqlProvider;
import com.sunway.ws.module.erp.business.cght.bean.CghtBean;

@MyBatisDao
public interface CghtDao extends BaseDao<CghtBean> {

	/**
	 * 更新接口表状态
	 * 
	 * @param cght
	 * @return
	 */
	public int updateStatus(CghtBean cght);
	
	/**
	 * 从 PPMS 拉取合同数据
	 */
	public void pullCght();
	
	/**
	 * 根据合同编码获取推送 ERP 的采购合同主表
	 * 
	 * @param htbm 合同编码
	 * @return
	 */
	public CghtBean queryPushErpCght(String htbm);
	
	/**
	 * 查询多条数据
	 * 
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SelectSqlProvider.class, method = "querySingleTable")
	public List<CghtBean> queryForList(CghtBean entity);
	
}
