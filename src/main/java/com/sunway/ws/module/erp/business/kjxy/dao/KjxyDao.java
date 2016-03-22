package com.sunway.ws.module.erp.business.kjxy.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.SelectSqlProvider;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyBean;

@MyBatisDao
public interface KjxyDao {

	public void pullKjxy();
	
	public int updateStatus(KjxyBean lcb);
	
	/**
	 * 查询多条数据
	 * 
	 * @param entity
	 * @return
	 */
	@SelectProvider(type = SelectSqlProvider.class, method = "querySingleTable")
	public List<KjxyBean> queryForList(KjxyBean entity);
	
	/**
	 * 根据框架协议编号获取推送 ERP 的框架协议
	 * 
	 * @param kjxybh
	 * @return
	 */
	public KjxyBean queryPushErpKjxy(String kjxybh);
	
}
