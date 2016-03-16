package com.sunway.ws.module.erp.business.kjxy.dao;

import java.util.List;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyItemBean;

@MyBatisDao
public interface KjxyItemDao extends BaseDao<KjxyItemBean>{

	public List<KjxyItemBean> queryForListByZecconh(String zecconh);
	
	public List<KjxyItemBean> queryForListByHeadId(Long headId);
	
}
