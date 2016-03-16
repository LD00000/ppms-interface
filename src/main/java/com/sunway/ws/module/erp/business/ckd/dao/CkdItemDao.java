package com.sunway.ws.module.erp.business.ckd.dao;

import java.util.List;

import com.sunway.ws.core.dao.BaseDao;
import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.erp.business.ckd.bean.CkdItemBean;

@MyBatisDao
public interface CkdItemDao extends BaseDao<CkdItemBean> {
	
	public List<CkdItemBean> queryForListByCkdh(String ckdh);
	
	public List<CkdItemBean> queryForListByHeadId(Long headId);

}
